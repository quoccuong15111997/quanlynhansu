package com.nqc.quanlynhanvien;

import android.app.Application;

import com.nqc.sharepreference.ManagerSharePreference;

public class MyAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ManagerSharePreference.init(this);
    }
}
