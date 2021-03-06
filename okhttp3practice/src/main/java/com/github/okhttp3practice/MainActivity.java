package com.github.okhttp3practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_connect = (Button) findViewById(R.id.btn_connect_network);
        txt_result = (TextView) findViewById(R.id.txt_result);
        txt_result.setMovementMethod(ScrollingMovementMethod.getInstance());

        btn_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*HttpClientTest
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new HttpClientTest().useHttpClientPost("http://www.baidu.com");
                        new HttpClientTest().useHttpClientGet("http://www.baidu.com");
                    }
                }).start();*/
                /*HttpURLConnectionTest
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new HttpUrlConnectionTest().useHttpUrlConnectionPost("http://www.baidu.com");
                    }
                }).start();*/

                /*OkHttpClientTest GET请求
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new OkHttpTest().getAsynHttpGET();
                    }
                }).start();*/
                //OkHttpClientTest POST请求
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new OkHttpTest().getAsynPost();
                    }
                }).start();*/
                /*download img test
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new OkHttpTest(MainActivity.this).downloadImage();
                    }
                }).start();*/
                /*download book test*/
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new OkHttpTest(MainActivity.this).downloadBook();
                    }
                }).start();
            }
        });

    }

    public void btnOkHttpActivity(View view){
        startActivity(new Intent(this,OkhttpActivity.class));
    }
}
