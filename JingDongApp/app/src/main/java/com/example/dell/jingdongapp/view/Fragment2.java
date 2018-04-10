package com.example.dell.jingdongapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.dell.jingdongapp.R;
import com.example.dell.jingdongapp.adapter.TwoAdapter1;
import com.example.dell.jingdongapp.adapter.TwoAdapter2;
import com.example.dell.jingdongapp.model.bean.FenLei;
import com.example.dell.jingdongapp.model.bean.TwoBean;
import com.example.dell.jingdongapp.presenter.FenLeiPresenter;
import com.example.dell.jingdongapp.presenter.TwoPresenter;

import java.util.List;

/**
 * Created by DELL on 2018/4/9.
 */

public class Fragment2 extends Fragment implements FenLeiView,TwoView{

    private View view;
    private RecyclerView mRv4;
    private ExpandableListView mElv;
    private FenLeiPresenter fenLeiPresenter;
    private List<FenLei.DataBean> list;
    private TwoAdapter1 twoAdapter1;
    private TwoAdapter2 twoAdapter2;
    private TwoPresenter twoPresenter;
    int cid=1;
    private List<TwoBean.DataBean> data;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        initView(view);

        fenLeiPresenter = new FenLeiPresenter(this);
        fenLeiPresenter.relance();
        twoPresenter=new TwoPresenter(this);
        twoPresenter.relance(cid+"");
        return view;
    }

    private void initView(View view) {
        mRv4 = (RecyclerView) view.findViewById(R.id.rv4);
        mElv = (ExpandableListView) view.findViewById(R.id.elv);
    }

    @Override
    public void getFenLei(FenLei fenLei) {
        list=fenLei.getData();
        mRv4.setLayoutManager(new LinearLayoutManager(getActivity()));
        twoAdapter1=new TwoAdapter1(getActivity(),list);
        mRv4.setAdapter(twoAdapter1);
        twoAdapter1.setOnItemClickListener(new TwoAdapter1.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                cid = list.get(position).getCid();
                Toast.makeText(getContext(), ""+cid, Toast.LENGTH_SHORT).show();
                twoPresenter.relance(cid+"");
            }
        });


    }

    @Override
    public void getZifen(TwoBean twoBean) {
        data = twoBean.getData();

        twoAdapter2=new TwoAdapter2(getActivity(),data);
        mElv.setAdapter(twoAdapter2);
        for (int i=0;i<twoAdapter2.getGroupCount();i++){
            mElv.expandGroup(i);
        }
    }
}
