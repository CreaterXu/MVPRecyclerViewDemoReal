package com.example.administrator.test;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import Adpter.RecyclerViewAdpter;

/**
 * Created by Administrator on 2016/5/20.
 */
public class MessageFragment extends android.support.v4.app.Fragment implements ViewInterface{
    private  View contentView;
    private RecyclerView recyclerView;
    private RecyclerViewAdpter recyclerViewAdpter;
    //private FragmentActivity fragmentActivity;
    private Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView=inflater.inflate(R.layout.fragment_message,container,false);
        recyclerView=(RecyclerView) contentView.findViewById(R.id.recyclerView);
        Log.e("xv","on createView");
        presenter=new MessagePresenter(this);
        loadData();
        recyclerViewAdpter=new RecyclerViewAdpter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdpter);

        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.e("xv","on view created");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e("xv","on activity createed");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        Log.e("xv","on destory view");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("xv","on Destorty");
        super.onDestroy();
    }

    @Override
    public void onPause() {
        Log.e("xv","on pause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e("xv","on stop");
        super.onStop();
    }

    @Override
    public void onStart() {
        Log.e("xv","on start");
        super.onStart();
    }

    public void loadData(){
        presenter.loadData();
    }
    /**
     * 实现view抽离接口方法
     * */
    @Override
    public void showNetError() {
        Toast.makeText(getActivity(),"net error",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showData(ArrayList<MessageBean> messageBeanArrayList) {
        Log.e("xv","in show data "+messageBeanArrayList.toString());
        recyclerViewAdpter.setMessageBeanArrayList(messageBeanArrayList);
        //recyclerView.setAdapter(recyclerViewAdpter);
        recyclerViewAdpter.notifyDataSetChanged();

    }

    @Override
    public void showLoading() {

    }
}
