package com.example.administrator.test;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/26.
 * 抽离的View层
 */
public interface ViewInterface {
    void showNetError();
    void showData(ArrayList<MessageBean> messageBeanArrayList);
    void showLoading();
}
