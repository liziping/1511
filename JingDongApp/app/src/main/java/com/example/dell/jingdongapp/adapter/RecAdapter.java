package com.example.dell.jingdongapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.jingdongapp.R;
import com.example.dell.jingdongapp.model.bean.TwoBean;

import java.util.List;

/**
 * Created by DELL on 2018/4/9.
 */

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.MyHolder>{

    private Context context;
    private List<TwoBean.DataBean.ListBean> listBeans;

    public RecAdapter(Context context, List<TwoBean.DataBean.ListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.two2_2,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.textView.setText(listBeans.get(position).getName());
        Glide.with(context).load(listBeans.get(position).getIcon()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public MyHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            imageView=itemView.findViewById(R.id.imageView3);
        }
    }
}
