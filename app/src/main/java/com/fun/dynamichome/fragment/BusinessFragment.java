package com.fun.dynamichome.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fun.dynamichome.R;

public class BusinessFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("DynamicHome", "BusinessFragment");
        return inflater.inflate(R.layout.fragment_business, container, false);
    }

}
