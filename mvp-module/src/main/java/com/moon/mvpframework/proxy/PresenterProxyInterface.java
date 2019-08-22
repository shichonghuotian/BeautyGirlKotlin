package com.moon.mvpframework.proxy;


import com.moon.mvpframework.factory.PresenterMvpFactory;
import com.moon.mvpframework.presenter.BaseMvpPresenter;
import com.moon.mvpframework.view.BaseMvpView;

/**
 * @author  jiangtao.liang
 * @date  On 2018/4/8 14:12
 * @des  代理接口
 */
public interface PresenterProxyInterface<V extends BaseMvpView,P extends BaseMvpPresenter<V>> {


    /**
     * 设置创建Presenter的工厂
     * @param presenterFactory PresenterFactory类型
     */
    void setPresenterFactory(PresenterMvpFactory<V,P> presenterFactory);

    /**
     * 获取Presenter的工厂类
     * @return 返回PresenterMvpFactory类型
     */
    PresenterMvpFactory<V,P> getPresenterFactory();


    /**
     * 获取创建的Presenter
     * @return 指定类型的Presenter
     */
    P getMvpPresenter();


}
