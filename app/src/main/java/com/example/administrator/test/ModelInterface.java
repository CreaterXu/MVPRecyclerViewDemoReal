package com.example.administrator.test;

/**
 * Created by Administrator on 2016/5/26.
 * 抽离数据层接口
 */
public interface ModelInterface {
    void getData(Presenter.Callback callback);
}
