package com.deanxd.taxiform;

import android.support.annotation.NonNull;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


    @Test
    public void testForQueue() {
//        System.out.println("this is a test for queue");

//        SortDemo.bubblingSorting();

//        SortDemo.insertSorting();

//        SortDemo.selectSorting();

        bucketSort();
    }


    public void bucketSort() {
        String sourceStr = "DaFB1234cAz";

        StringBuilder[] buckets = new StringBuilder[3];

        for (int i = 0; i < sourceStr.length(); i++) {
            StringBuilder bucket = null;
            char value = sourceStr.charAt(i);
            if (Character.isLowerCase(value)) {
                bucket = buckets[0];
                if (bucket == null) {
                    bucket = new StringBuilder();
                    buckets[0] = bucket;
                }
            } else if (Character.isDigit(value)) {
                bucket = buckets[1];
                if (bucket == null) {
                    bucket = new StringBuilder();
                    buckets[1] = bucket;
                }
            } else if (Character.isUpperCase(value)) {
                bucket = buckets[2];
                if (bucket == null) {
                    bucket = new StringBuilder();
                    buckets[2] = bucket;
                }
            }

            if (bucket != null) {
                bucket.append(value);
            }
        }

        String result = "";
        if (buckets[0] != null) {
            result += buckets[0].toString();
        }
        if (buckets[1] != null) {
            result += buckets[1].toString();
        }
        if (buckets[2] != null) {
            result += buckets[2].toString();
        }

        System.out.println("排序前：" + sourceStr);
        System.out.println("排序后: " + result);
    }


}