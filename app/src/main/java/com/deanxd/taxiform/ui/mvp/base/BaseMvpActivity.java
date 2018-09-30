package com.deanxd.taxiform.ui.mvp.base;

import android.support.v7.app.AppCompatActivity;

import com.deanxd.taxiform.ui.mvp.IView;

/**
 * MVP activity基类
 *
 * @author Dean
 */
public class BaseMvpActivity extends AppCompatActivity implements IView {

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToastMsg(String message) {

    }
}
