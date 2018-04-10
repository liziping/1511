package com.example.dell.jingdongapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.dell.jingdongapp.R;
import com.example.dell.jingdongapp.model.bean.FenLei;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by DELL on 2018/4/1.
 */

public class FenLeiAdapter extends RecyclerView.Adapter<FenLeiAdapter.MyHolder>{

    private Context context;
    private List<FenLei.DataBean> list;


    public FenLeiAdapter(Context context, List<FenLei.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.fenlei,parent,false);
        MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.textView.setText(list.get(position).getName());
        Picasso.with(context).load(list.get(position).getIcon()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        Log.e("数据",list.size()+"");
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public MyHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.img);
            textView=itemView.findViewById(R.id.tv2);
        }
    }

}
