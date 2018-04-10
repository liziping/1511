package com.example.dell.jingdongapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.jingdongapp.R;
import com.example.dell.jingdongapp.model.bean.FenLei;

import java.util.List;

/**
 * Created by DELL on 2018/4/9.
 */

public class TwoAdapter1 extends RecyclerView.Adapter<TwoAdapter1.MyHolder>{

    private Context context;
    private List<FenLei.DataBean> list;

    public TwoAdapter1(Context context, List<FenLei.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.two_1,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.textView.setText(list.get(position).getName());
        if(mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView4);
        }
    }

    public interface OnItemClickListener{
        void onClick( int position);
    }
    OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener=onItemClickListener;
    }

}
