package com.moon.beautygirlkotlin.mengmeizi.presenter

import android.content.Context
import android.util.Log
import com.moon.beautygirlkotlin.mengmeizi.view.IGankMeiziView
import com.moon.beautygirlkotlin.network.RetrofitHelper
import com.moon.mvpframework.presenter.BaseMvpPresenter
import com.trello.rxlifecycle.ActivityEvent
import com.trello.rxlifecycle.RxLifecycle.bindUntilEvent
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class GankMeiziPresenter : BaseMvpPresenter<IGankMeiziView>() {

    fun getGankList(context: Context, pageNum: Int , page :Int){

        Log.i("moon", "pageNum = "+pageNum + ",page =  "+ page)


        RetrofitHelper.getGankMeiziApi()
                .getGankMeizi(pageNum, page)
//                .compose(((RxAppCompatActivity)context).<>bindUntilEvent(ActivityEvent.DESTROY))
                .filter({ gankMeiziResult -> !gankMeiziResult.error })
                .map({ gankMeiziResult -> gankMeiziResult.results })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ gankMeiziInfos ->

                    Log.i("moon", "gankmeizi...success...."+gankMeiziInfos.size)

                    mvpView?.showSuccess(gankMeiziInfos)

                }, { throwable ->


                    Log.i("moon", "gankmeizi...error...")

                    mvpView?.showError()

                })

    }

}