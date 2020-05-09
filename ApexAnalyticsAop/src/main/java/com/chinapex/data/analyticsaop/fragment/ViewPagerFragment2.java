package com.chinapex.data.analyticsaop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chinapex.analytics.sample.R;
import com.chinapex.analytics.sample.utils.AppLog;

/**
 * @author : Seven
 * @date : 2018/11/28
 */
public class ViewPagerFragment2 extends BaseFragmentV4 implements View.OnClickListener {

    private static final String TAG = ViewPagerFragment2.class.getSimpleName();

    @Override
    View baseOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vp2, container, false);
    }

    @Override
    protected void baseOnViewCreated(View view, Bundle savedInstanceState) {
        initView(view);
    }

    private void initView(View view) {
        Button btVp2 = view.findViewById(R.id.bt_vp2);
        btVp2.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_vp2:
                AppLog.i(TAG, "bt_vp2 is clicked!");
                break;
            default:
                break;
        }
    }
}
