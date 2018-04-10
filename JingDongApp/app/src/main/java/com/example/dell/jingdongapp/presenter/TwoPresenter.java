package com.example.dell.jingdongapp.presenter;

import com.example.dell.jingdongapp.model.TwoModel;
import com.example.dell.jingdongapp.model.bean.TwoBean;
import com.example.dell.jingdongapp.view.TwoView;

/**
 * Created by DELL on 2018/4/9.
 */

public class TwoPresenter {

    private TwoModel twoModel;
    private TwoView twoView;

    public TwoPresenter(TwoView twoView){
        this.twoView=twoView;
        twoModel=new TwoModel();
    }

    public void relance(String cid){
        twoModel.getServer(cid);
        twoModel.getCallBackDate(new TwoModel.CallBackDate() {
            @Override
            public void backDate(TwoBean twoBean) {
                twoView.getZifen(twoBean);
            }
        });
    }

}
