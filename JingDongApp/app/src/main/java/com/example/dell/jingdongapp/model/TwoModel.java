package com.example.dell.jingdongapp.model;

import android.util.Log;

import com.example.dell.jingdongapp.api.Api;
import com.example.dell.jingdongapp.api.ApiServser;
import com.example.dell.jingdongapp.model.bean.TwoBean;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2018/4/9.
 */

public class TwoModel {

    public interface CallBackDate{
        void backDate(TwoBean twoBean);
    }

    CallBackDate callBackDate;

    public void getCallBackDate(CallBackDate callBackDate){
        this.callBackDate=callBackDate;
    }

    public void getServer(String cid){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("TAG",message);
            }
        });

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.path)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiServser servser = retrofit.create(ApiServser.class);
        Observable<TwoBean> zifen = servser.getZifen(cid);
        zifen.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TwoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TwoBean twoBean) {
                        callBackDate.backDate(twoBean);
                    }
                });


    }

}
