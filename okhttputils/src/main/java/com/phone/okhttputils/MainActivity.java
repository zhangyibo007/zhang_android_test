package com.phone.okhttputils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

import static android.os.Environment.getExternalStorageDirectory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvContent;
    private Button getData, asynget_data,post_string_data,post_stream_data;
    private ProgressBar progress;
    private Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListenter();
    }

    private void initListenter() {
        getData.setOnClickListener(this);
        asynget_data.setOnClickListener(this);
        post_string_data.setOnClickListener(this);
        post_stream_data.setOnClickListener(this);
    }

    private void initView() {
        tvContent = (TextView) findViewById(R.id.tv_content);
        getData = (Button) findViewById(R.id.get_data);
        post_string_data= (Button) findViewById(R.id.post_string_data);
        asynget_data = (Button) findViewById(R.id.asynget_data);
        post_stream_data = (Button) findViewById(R.id.post_stream_data);
        progress = (ProgressBar) findViewById(R.id.progress);
        gson = new Gson();
    }

    @Override
    public void onClick(View v) {
        if (v == getData) {
            progress.setVisibility(View.VISIBLE);
//            getDataOkHttp();
//            postDataOkttp();
            try {
                SynchronousGetData();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (v == asynget_data) {
//            progress.setVisibility(View.VISIBLE);
            asynGetData();

        }

        if(v==post_string_data){
            postString();
        }
        if(v==post_stream_data){
            PostStreaming();
        }
    }

    private void SynchronousGetData() throws IOException {
        final OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .get()
                .url("https://publicobject.com/helloworld.txt")
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Response execute = null;
                try {
                    execute = okHttpClient.newCall(request).execute();
                    if (!execute.isSuccessful()) {
                        Log.e("TAG", "请求失败了......");
                        return;
                    }
                    Log.e("TAG", "请求成功了......." + execute.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void asynGetData() {
        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .get()
                .url("https://publicobject.com/helloworld.txt")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "请求失败了...." + e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG", "请求成功了......." + response.body().string());
                Headers headers = response.headers();
                for (int i=0;i<headers.size();i++){
                    Log.e("TAG", "headName:"+headers.name(i)+"============value=:"+headers.value(i));
                }
            }
        });

    }


    public void  postString(){
        OkHttpClient okhtt=new OkHttpClient();
        String requestBodys = "create name";
        MediaType contentType=MediaType.parse("text/x-markdown; charset=utf-8");
        RequestBody requestBody=RequestBody.create(contentType,requestBodys);
        Request request=new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(requestBody)
                .build();
        okhtt.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "post上传字符串失败.........");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG", "post上传字符串成功........."+response.body().string());
            }
        });

    }


    public void PostStreaming(){
        OkHttpClient client=new OkHttpClient();

        RequestBody requestBody=new RequestBody() {
            @Override
            public MediaType contentType() {
                return MediaType.parse("text/x-markdown; charset=utf-8");
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                    sink.writeUtf8("12121212121212");
            }
        };
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "post上传提交流失败.........");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG", "post上传提交流成功........."+response.body().string());
            }
        });
    }

    private void postDataOkttp() {
        progress.setVisibility(View.VISIBLE);
        String url = "http://apis.juhe.cn/cook/query";
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(new File(getExternalStorageDirectory().getPath() + "/okhttps"), cacheSize);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();

        RequestBody requestBody = new FormBody.Builder()
                .add("key", "53b7845b77045f950ef656071165216f")
                .add("menu", "西红柿")
                .add("rn", "2")
                .build();

        final Request request = new Request.Builder()
                .post(requestBody)
                .addHeader("Cache-Control", "max-stale=3600")
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progress.setVisibility(View.GONE);
                        tvContent.setText(e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                final FoodBean foodBean = gson.fromJson(string, FoodBean.class);
                Log.e("TAG", "Response 1 cache response==========" + response.cacheResponse());
                Log.e("TAG", "Response 1 network response==========" + response.networkResponse());
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            progress.setVisibility(View.GONE);
                            tvContent.setText(foodBean.getReason());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });


        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progress.setVisibility(View.GONE);
                        tvContent.setText(e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                final FoodBean foodBean = gson.fromJson(string, FoodBean.class);

                Log.e("TAG", "Response 2 cache response==========" + response.cacheResponse());
                Log.e("TAG", "Response 2 network response==========" + response.networkResponse());
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            progress.setVisibility(View.GONE);
                            tvContent.setText(foodBean.getReason());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }

    //异步get方式获取数据
    private void getDataOkHttp() {
        String url = "http://zuowen.api.juhe.cn/zuowen/typeList?key=3697441117d0fe32af4c690eb6720226&id=1";
        OkHttpClient okHttpClient = new OkHttpClient();
        //创建get请求request
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        //异步请求
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            progress.setVisibility(View.GONE);
                            tvContent.setText(e.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            progress.setVisibility(View.GONE);
                            tvContent.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
