package com.example.dell.jingdongapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;import com.example.dell.jingdongapp.R;
import com.example.dell.jingdongapp.model.bean.LouBoTu;

import java.util.List;

/**
 * Created by DELL on 2018/4/2.
 */

public class DiBuAdapter extends RecyclerView.Adapter<DiBuAdapter.MyHolder>{

    private Context context;
    private List<LouBoTu.TuijianBean.ListBean> list;

    public DiBuAdapter(Context context, List<LouBoTu.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_1,parent,false);
        MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
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
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public MyHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView2);
        }
    }

}
