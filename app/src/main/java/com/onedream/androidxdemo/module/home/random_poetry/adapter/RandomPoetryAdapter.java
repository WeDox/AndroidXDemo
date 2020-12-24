package com.onedream.androidxdemo.module.home.random_poetry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.onedream.androidxdemo.R;
import com.onedream.androidxdemo.common.bean.random_poetry.RandomPoetryBean;
import com.onedream.androidxdemo.databinding.ItemRandomPoetryBinding;
import com.onedream.androidxdemo.framework.base.BaseRecAdapter;
import com.onedream.androidxdemo.framework.base.BaseRecViewHolder;

import java.util.List;

public class RandomPoetryAdapter extends BaseRecAdapter<RandomPoetryBean, RandomPoetryAdapter.ViewHolderItemNews> {


    private List<RandomPoetryBean> dataBeans;

    private Context mContext;

    public RandomPoetryAdapter(List<RandomPoetryBean> dataBeans, Context mContext) {
        super(dataBeans);
        this.dataBeans = dataBeans;
        this.mContext = mContext;
    }

    @Override
    public void onHolder(ViewHolderItemNews holder, RandomPoetryBean bean, int position) {
        ItemRandomPoetryBinding itemNewsBinding = ((ViewHolderItemNews) holder).viewDataBinding;
        itemNewsBinding.setRandomPoetry(dataBeans.get(position));
        itemNewsBinding.executePendingBindings();
    }

    @Override
    public ViewHolderItemNews onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRandomPoetryBinding itemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_random_poetry, parent, false);
        return new ViewHolderItemNews(itemNewsBinding);
    }


    @Override
    public int getItemCount() {
        return dataBeans.size();
    }


    static class ViewHolderItemNews extends BaseRecViewHolder {

        private ItemRandomPoetryBinding viewDataBinding;

        private ViewHolderItemNews(ItemRandomPoetryBinding inflate) {
            super(inflate.getRoot());
            this.viewDataBinding = inflate;
        }
    }
}