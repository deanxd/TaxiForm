package com.deanxd.taxiform.ui.mvp;

/**
 * Created by think on 2018/9/24.
 */

public interface IPresenter<V extends IView> {

    void attach(V view);

    void detach();
}
