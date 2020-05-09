package com.chinapex.data.analyticsaop.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinapex.analytics.sample.R;
import com.chinapex.analytics.sample.utils.AppLog;

/**
 * @author SteelCabbage
 * @date 2018/11/14
 */
public class FragmentNoV4Sub extends Fragment {
    private static final String TAG = FragmentNoV4Sub.class.getSimpleName();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        return inflater.inflate(R.layout.fragment_v4_sub, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        AppLog.i(TAG, "Fragment onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        AppLog.i(TAG, "Fragment onPause");
        super.onPause();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        AppLog.i(TAG, "Fragment onHiddenChanged:" + hidden);
        super.onHiddenChanged(hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        AppLog.i(TAG, "Fragment setUserVisibleHint:" + isVisibleToUser);
        super.setUserVisibleHint(isVisibleToUser);
    }

}
