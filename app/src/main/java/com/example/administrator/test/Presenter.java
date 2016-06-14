package com.example.administrator.test;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/26.
 */
public abstract class Presenter {
    int count;
    int getCount(){
        return 3;
    }
    abstract void loadData();
    abstract void getData();
    abstract void showLoading();

    public interface Callback{
        void success(ArrayList<MessageBean> messageBeanArrayList);
        void error(String errorMessage);
    }
}
