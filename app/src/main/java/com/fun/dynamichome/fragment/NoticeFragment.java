package com.fun.dynamichome.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fun.dynamichome.R;

public class NoticeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("DynamicHome", "MineFragment");
        return inflater.inflate(R.layout.fragment_notice, container, false);
    }

}
