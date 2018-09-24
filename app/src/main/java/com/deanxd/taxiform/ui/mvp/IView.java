package com.deanxd.taxiform.ui.mvp;

/**
 * Created by think on 2018/9/24.
 */

public interface IView {

    void showLoading();

    void hideLoading();

    void showToastMsg(String message);
}
