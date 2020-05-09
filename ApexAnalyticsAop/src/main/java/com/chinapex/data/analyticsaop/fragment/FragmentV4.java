package com.chinapex.data.analyticsaop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinapex.analytics.sample.R;

/**
 * @author SteelCabbage
 * @date 2018/11/14
 */
public class FragmentV4 extends BaseFragmentV4 {

    private static final String TAG = FragmentV4.class.getSimpleName();

    @Override
    View baseOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_v4, container, false);
    }

    @Override
    protected void baseOnViewCreated(View view, Bundle savedInstanceState) {

    }
}
