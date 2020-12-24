package com.onedream.androidxdemo.framework.base;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecAdapter<T, K extends BaseRecViewHolder> extends RecyclerView.Adapter<K> {

    private List<T> dataList;
    public Context context;


    public BaseRecAdapter(List<T> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public K onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return onCreateHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull K holder, int position) {
        onHolder(holder, dataList.get(position), position);
    }


    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }


    public abstract K onCreateHolder(@NonNull ViewGroup parent,int viewType);

    public abstract void onHolder(K holder, T bean, int position);

    /**
     * 通过资源res获得view
     */
    protected View getViewByRes(int res) {
        return LayoutInflater.from(context).inflate(res, null);
    }
}
