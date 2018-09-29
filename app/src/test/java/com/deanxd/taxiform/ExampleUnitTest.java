package com.deanxd.taxiform;

import android.support.annotation.NonNull;

import org.junit.Test;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testForInterceptor() throws Exception {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {

                System.out.println("this is one interceptor");
                Request request = chain.request();
                return chain.proceed(request);
            }
        };

        Interceptor interceptorTwo = new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                System.out.println("this is two interceptor");
                Request request = chain.request();
                return chain.proceed(request);
            }
        };

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptorTwo)
                .addInterceptor(interceptor)
                .build();

        Request request = new Request.Builder()
                .get()
                .url("https://www.baidu.com")
                .build();


        System.out.println("working thread:" + Thread.currentThread());


        Response response = okHttpClient.newCall(request).execute();
        System.out.print("response:" + response.body().string());

/*        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                System.out.println("working thread:" + Thread.currentThread());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                System.out.println("working thread:" + Thread.currentThread());
                System.out.print("response:" + response.body().string());
            }
        });*/

    }
}