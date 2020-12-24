package com.onedream.androidxdemo.framework.http.base;

import androidx.lifecycle.ViewModel;

import com.onedream.androidxdemo.framework.utils.system.LogHelper;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author jdallen
 * @since 2020/12/24
 * 基于Rx的ViewModel封装,控制订阅的生命周期
 * unsubscribe() 这个方法很重要，
 * 因为在 subscribe() 之后， Observable 会持有 Subscriber 的引用，
 * 这个引用如果不能及时被释放，将有内存泄露的风险。
 */
public class BaseRxViewModel extends ViewModel {

    protected CompositeSubscription mCompositeSubscription;

    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    protected void unSubscribe() {
        printLog("跟着死亡,不再请求网络");
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        unSubscribe();
    }

    protected void printLog(String content) {
        LogHelper.e("ATU", content);
    }
}
