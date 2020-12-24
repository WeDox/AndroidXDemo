package com.onedream.androidxdemo.framework.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * Fragment基类
 */
public abstract class BaseFragment extends BaseLazyLoadFragment {
    private static final String TAG = BaseFragment.class.getName();
    private View rootView;
    protected FragmentActivity mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getContentViewId(), container, false);
            this.mContext = getActivity();
            bind(rootView);
            initData();
            initEvent();
            isViewPrepare = true;//懒加载的标记，视图是否已加载
            lazyLoad();
        }
        //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }



    /**
     * 获取布局id抽象方法
     *
     * @return 布局文件资源id
     */
    protected abstract int getContentViewId();

    /**
     * 为dataBinding服务
     *
     * @param view 布局文件对象
     */
    protected abstract void bind(View view);

    //初始化数据操作
    public abstract void initData();

    //初始化监听事件操作
    public abstract void initEvent();

    //

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
