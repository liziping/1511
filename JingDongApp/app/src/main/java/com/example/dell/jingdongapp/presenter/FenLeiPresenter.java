package com.example.dell.jingdongapp.presenter;

import com.example.dell.jingdongapp.model.FenLeiModel;
import com.example.dell.jingdongapp.model.bean.FenLei;
import com.example.dell.jingdongapp.view.FenLeiView;

/**
 * Created by DELL on 2018/4/1.
 */

public class FenLeiPresenter {

    private FenLeiModel fenLeiModel;
    private FenLeiView fenLeiView;

    public FenLeiPresenter(FenLeiView fenLeiView){
        this.fenLeiView=fenLeiView;
        fenLeiModel=new FenLeiModel();
    }

    public void relance(){
        fenLeiModel.getServer();
        fenLeiModel.getCallBackDate(new FenLeiModel.CallBackDate() {
            @Override
            public void backDate(FenLei fenLei) {
                fenLeiView.getFenLei(fenLei);
            }
        });

    }

}
