package com.chinapex.data.analyticsaop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chinapex.analytics.sample.R;
import com.chinapex.analytics.sample.utils.AppLog;

/**
 * @author SteelCabbage
 * @date 2018/10/17
 */
public class Test3Acticity extends AppCompatActivity {

    private static final String TAG = Test3Acticity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppLog.w(TAG, "Test3Acticity onCreate++++++++++++++++++++++++++++++++++");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3_acticity);

        Intent intent = getIntent();
        int flags = intent.getFlags();
        AppLog.i(TAG, "intent flags:" + flags);
        AppLog.d(TAG, "intent toString():" + intent.toString());
    }
}
