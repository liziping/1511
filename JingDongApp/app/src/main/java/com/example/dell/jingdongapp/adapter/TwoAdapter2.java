package com.example.dell.jingdongapp.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.dell.jingdongapp.R;
import com.example.dell.jingdongapp.model.bean.TwoBean;

import java.util.List;

/**
 * Created by DELL on 2018/4/9.
 */

public class TwoAdapter2 extends BaseExpandableListAdapter {

    private Context context;
    private List<TwoBean.DataBean> list;
    private List<TwoBean.DataBean.ListBean> list1;

    public TwoAdapter2(Context context, List<TwoBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getGroupCount() {

        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {

        return list.get(i).getList().size();
    }

    @Override
    public Object getGroup(int i) {
        return list.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return list.get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        GruopHolder gruopHolder;
        if(view==null){
            gruopHolder=new GruopHolder();
            view=View.inflate(context, R.layout.two_2,null);
            gruopHolder.textView=view.findViewById(R.id.tv3);
            view.setTag(gruopHolder);
        }else {
            gruopHolder= (GruopHolder) view.getTag();
        }
        gruopHolder.textView.setText(list.get(i).getName());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        ChildHolder childHolder;
        if(view==null){
            childHolder=new ChildHolder();
            view=View.inflate(context, R.layout.two2_1,null);
            list1 = this.list.get(i).getList();
            childHolder.recyclerView=view.findViewById(R.id.rlv);
            childHolder.recyclerView.setLayoutManager(new GridLayoutManager(context,3));

            view.setTag(childHolder);
        }else {
            childHolder= (ChildHolder) view.getTag();
        }
        childHolder.recyclerView.setAdapter(new RecAdapter(context,list1));

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }


    class GruopHolder{
        TextView textView;
    }

    class ChildHolder{
        RecyclerView recyclerView;
    }

}
