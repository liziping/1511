package com.example.dell.jingdongapp.view;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.jingdongapp.R;
import com.example.dell.jingdongapp.adapter.DiBuAdapter;
import com.example.dell.jingdongapp.adapter.FenLeiAdapter;
import com.example.dell.jingdongapp.adapter.MiaoShaAdapter;
import com.example.dell.jingdongapp.model.bean.FenLei;
import com.example.dell.jingdongapp.model.bean.LouBoTu;
import com.example.dell.jingdongapp.presenter.FenLeiPresenter;
import com.example.dell.jingdongapp.presenter.LunBoTuPresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 2018/4/9.
 */

public class Fragment1 extends Fragment implements LunBoTuView,FenLeiView{

    private Banner mBanner;
    private RecyclerView mRv1;
    /**
     * 京东秒杀：
     */
    private TextView mTv1;
    private RecyclerView mRv2;
    private List<FenLei.DataBean> fenlei;
    private List<LouBoTu.DataBean> lunbo;
    private LunBoTuPresenter lunBoTuPresenter;
    private FenLeiPresenter fenLeiPresenter;
    private List<String> list = new ArrayList<>();
    private FenLeiAdapter adapter;
    private List<LouBoTu.TuijianBean.ListBean> tuijian;
    private DiBuAdapter adapter2;
    private View view;
    private RecyclerView mRv3;
    private MiaoShaAdapter miaoShaAdapter;
    private List<LouBoTu.MiaoshaBean.ListBeanX> miaosha;
    private int time;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1,container,false);
        initView(view);

        lunBoTuPresenter = new LunBoTuPresenter(this);
        lunBoTuPresenter.relance();
        fenLeiPresenter = new FenLeiPresenter(this);
        fenLeiPresenter.relance();
        mBanner.setDelayTime(2000);
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        mBanner.setImages(list);
        mBanner.start();

        final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
        CountDownTimer countDownTimer = new CountDownTimer(time, 1000) {

            @Override
            public void onTick(long l) {

                String format = simpleDateFormat.format(new Date(l));
                mTv1.setText("京东秒杀:"+format);

            }

            @Override
            public void onFinish() {

            }
        }.start();
        return view;
    }

    @Override
    public void getFenLei(FenLei fenLei) {
        fenlei = fenLei.getData();
        GridLayoutManager grid = new GridLayoutManager(getActivity(), 8);
        mRv1.setLayoutManager(grid);
        adapter = new FenLeiAdapter(getActivity(), fenlei);
        mRv1.setAdapter(adapter);
    }

    @Override
    public void getLunBoTu(LouBoTu louBoTu) {
        lunbo = louBoTu.getData();
        time = louBoTu.getMiaosha().getTime();
        tuijian = louBoTu.getTuijian().getList();
        miaosha = louBoTu.getMiaosha().getList();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRv3.setLayoutManager(linearLayoutManager);
        miaoShaAdapter=new MiaoShaAdapter(getActivity(),miaosha);
        mRv3.setAdapter(miaoShaAdapter);

        for (int i = 0; i < lunbo.size(); i++) {
            String icon = lunbo.get(i).getIcon();
            this.list.add(icon);
        }
        mRv2.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter2 = new DiBuAdapter(getActivity(), tuijian);
        mRv2.setAdapter(adapter2);
    }

    private void initView(View view) {
        mBanner = (Banner) view.findViewById(R.id.banner);
        mRv1 = (RecyclerView) view.findViewById(R.id.rv1);
        mTv1 = (TextView) view.findViewById(R.id.tv1);
        mRv2 = (RecyclerView) view.findViewById(R.id.rv2);
        mRv3 = (RecyclerView) view.findViewById(R.id.rv3);
    }
}
