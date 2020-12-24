package com.onedream.androidxdemo.common.vm.random_poetry;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.onedream.androidxdemo.common.bean.random_poetry.RandomPoetryBean;
import com.onedream.androidxdemo.framework.http.base.BaseRxViewModel;
import com.onedream.androidxdemo.framework.http.custome.BodyOut;
import com.onedream.androidxdemo.framework.http.custome.MovieApi;
import com.onedream.androidxdemo.framework.utils.json_parse.JacksonUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author jdallen
 * @since 2020/12/24
 */
public class RandomPoetryViewModel extends BaseRxViewModel {
    private MutableLiveData<Integer> pageNumLiveData = new MutableLiveData<>();
    //
    public LiveData<List<RandomPoetryBean>> resultListDataLiveData = Transformations.switchMap(pageNumLiveData, new Function<Integer, LiveData<List<RandomPoetryBean>>>() {
        @Override
        public LiveData<List<RandomPoetryBean>> apply(Integer pageNum) {
            return createApiLiveData(pageNum);
        }
    });


    public void getListDataByPageNum(int pageNum) {
        //请求第10页
        pageNumLiveData.setValue(pageNum);
    }


    private LiveData<List<RandomPoetryBean>> createApiLiveData(int pageNum) {
        printLog("开始请求网络12第" + pageNum + "页");
        final MediatorLiveData<List<RandomPoetryBean>> mediatorLiveData = new MediatorLiveData<>();
        Subscription rxSubscription = MovieApi.getInstance().sendRandomPoetry()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BodyOut>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        printLog("请求网络失败" + e.toString());
                    }

                    @Override
                    public void onNext(BodyOut bodyOut) {
                        printLog("请求网络成功");
                        if (bodyOut.isSuccess()) {
                            List<RandomPoetryBean> dataList = new ArrayList<>();
                            List<RandomPoetryBean> apiDataList = JacksonUtils.parseObjectList(bodyOut.getData(), RandomPoetryBean.class);
                            if (null != apiDataList && apiDataList.size() > 0) {
                                dataList.addAll(apiDataList);
                            }
                            mediatorLiveData.setValue(dataList);
                        } else {
                            printLog("请求网络成功,但接口返回错误信息：" + bodyOut.getApiMsg());
                        }
                    }
                });
        addSubscribe(rxSubscription);//防止泄露
        return mediatorLiveData;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        printLog("MyViewModel我跟着生命周期死了");
    }
}
