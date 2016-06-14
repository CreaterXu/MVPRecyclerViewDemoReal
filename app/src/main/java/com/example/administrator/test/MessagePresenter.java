package com.example.administrator.test;

import android.util.Log;

import java.util.AbstractList;
import java.util.ArrayList;

import Adpter.RecyclerViewAdpter;

/**
 * Created by Administrator on 2016/5/26.
 */
public class MessagePresenter extends Presenter{
    private final ModelInterface modelInterface;
    private  final ViewInterface viewInterface;
    MessagePresenter(ViewInterface viewInterface){
        this.modelInterface=new ModelImpl();
        this.viewInterface=viewInterface;
    }

    @Override
    public void loadData() {
        Log.e("xv","in load");
        modelInterface.getData(new Presenter.Callback(){
            @Override
            public void success(ArrayList<MessageBean> messageBeanAbstractList) {
                Log.e("xv","in success");
                viewInterface.showData(messageBeanAbstractList);
            }

            @Override
            public void error(String errorMessage) {
                viewInterface.showNetError();
            }
        });
    }

    @Override
    public void getData() {

    }

    @Override
    public void showLoading() {

    }
}
