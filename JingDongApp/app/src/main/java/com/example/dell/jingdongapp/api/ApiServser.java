package com.example.dell.jingdongapp.api;


import com.example.dell.jingdongapp.model.bean.FenLei;
import com.example.dell.jingdongapp.model.bean.LouBoTu;
import com.example.dell.jingdongapp.model.bean.TwoBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by DELL on 2018/4/1.
 */

public interface ApiServser {

    @GET("ad/getAd")
    Observable<LouBoTu> getImg();
    @GET("product/getCatagory")
    Observable<FenLei> getFenLei();
    @GET("product/getProductCatagory")
    Observable<TwoBean> getZifen(@Query("cid") String cid);

}
