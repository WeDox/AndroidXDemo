package com.onedream.androidxdemo.module.home.random_poetry;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.onedream.androidxdemo.R;
import com.onedream.androidxdemo.common.bean.random_poetry.RandomPoetryBean;
import com.onedream.androidxdemo.common.vm.random_poetry.RandomPoetryViewModel;
import com.onedream.androidxdemo.common.vm.random_poetry.RandomPoetryViewModelFactory;
import com.onedream.androidxdemo.databinding.ActivityRandomPoetryBinding;
import com.onedream.androidxdemo.framework.base.BaseActivity;
import com.onedream.androidxdemo.module.home.random_poetry.adapter.RandomPoetryAdapter;

import java.util.ArrayList;
import java.util.List;

public class RandomPoetryActivity extends BaseActivity {
    private ActivityRandomPoetryBinding binding;
    //
    private RandomPoetryAdapter randomPoetryAdapter;
    private List<RandomPoetryBean> randomPoetryList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_random_poetry;
    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    @Override
    public void initData() {
        randomPoetryAdapter = new RandomPoetryAdapter(randomPoetryList, mContext);
        binding.recycleView.setLayoutManager(new LinearLayoutManager(mContext));
        binding.recycleView.setAdapter(randomPoetryAdapter);
        initMyViewModel();
    }

    @Override
    public void initEvent() {

    }

    private void initMyViewModel() {
        RandomPoetryViewModel myViewModel = new ViewModelProvider(this, new RandomPoetryViewModelFactory()).get(RandomPoetryViewModel.class);
        myViewModel.getListDataByPageNum(10);
        myViewModel.resultListDataLiveData.observe(this, new Observer<List<RandomPoetryBean>>() {
            @Override
            public void onChanged(List<RandomPoetryBean> dataList) {
                binding.tvHint.setVisibility(View.GONE);
                if (null != dataList && dataList.size() > 0) {
                    randomPoetryList.clear();
                    randomPoetryList.addAll(dataList);
                    randomPoetryAdapter.notifyDataSetChanged();
                }

            }
        });
    }


    public static void actionStart(Context context) {
        Intent intent = new Intent(context, RandomPoetryActivity.class);
        context.startActivity(intent);
    }
}
