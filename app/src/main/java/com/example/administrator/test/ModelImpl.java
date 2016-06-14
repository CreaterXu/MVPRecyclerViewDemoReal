package com.example.administrator.test;

import com.squareup.okhttp.internal.http.HttpConnection;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/26.
 */
public class ModelImpl implements ModelInterface {
    private MessageBean messageBean;
    private ArrayList<MessageBean> messageBeanArrayList;
    @Override
    public void getData(final Presenter.Callback callback) {
        Thread get=new Thread(){
            @Override
            public void run() {
                super.run();
                messageBeanArrayList=new ArrayList<>();
                try {
                    HttpConnection httpConnection=new HttpConnection(null,null,null);

                }catch (IOException e){

                }

                for (int i=0;i<10;i++){
                    messageBean=new MessageBean();
                    messageBean.setName("xv"+i);
                    messageBeanArrayList.add(messageBean);
                }
                if (true){
                    callback.success(messageBeanArrayList);
                }else {
                    callback.error("net error");
                }

            }
        };
        get.start();
    }
}
