package com.example.dell.jingdongapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.dell.jingdongapp.R;
import com.bumptech.glide.Glide;

import com.example.dell.jingdongapp.model.bean.LouBoTu;

import java.util.List;

/**
 * Created by DELL on 2018/4/2.
 */

public class MiaoShaAdapter extends RecyclerView.Adapter<MiaoShaAdapter.MyHolder>{

    private Context context;
    private List<LouBoTu.MiaoshaBean.ListBeanX> list;

    public MiaoShaAdapter(Context context, List<LouBoTu.MiaoshaBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.miaosha,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        String images = list.get(position).getImages();
        if(images.contains("|")){
            String[] split = images.split("\\|");
            Glide.with(context).load(split[0]).into(holder.imageView);
        }else {
            Glide.with(context).load(images).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        Log.e("秒杀---------",list.size()+"");
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView;


        public MyHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView2);

        }
    }

}
