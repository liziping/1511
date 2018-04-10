package com.example.dell.jingdongapp.presenter;

import com.example.dell.jingdongapp.model.LuoBoModel;
import com.example.dell.jingdongapp.model.bean.LouBoTu;
import com.example.dell.jingdongapp.view.LunBoTuView;

/**
 * Created by DELL on 2018/4/1.
 */

public class LunBoTuPresenter {

    private LunBoTuView lunBoTuView;
    private LuoBoModel luoBoModel;

    public LunBoTuPresenter(LunBoTuView lunBoTuView){
        this.lunBoTuView=lunBoTuView;
        luoBoModel=new LuoBoModel();
    }

    public void relance(){
        luoBoModel.getServer();
        luoBoModel.getCallBackDate(new LuoBoModel.CallBackDate() {
            @Override
            public void backDate(LouBoTu louBouTu) {
                lunBoTuView.getLunBoTu(louBouTu);
            }
        });
    }

}
