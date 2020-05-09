package com.chinapex.data.analyticsaop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chinapex.analytics.sample.R;
import com.chinapex.analytics.sample.utils.AppLog;

/**
 * @author SteelCabbage
 * @date 2019/01/25
 */
public class TestActivity extends Activity implements View.OnClickListener {

    private static final String TAG = TestActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initView();
    }

    private void initView() {
        Button button =findViewById(R.id.bt_test_activity);
        button.setOnClickListener(this);

        Button btGoto3activity =findViewById(R.id.bt_goto_3_activity);
        btGoto3activity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_test_activity:
                AppLog.i(TAG, "bt_test_activity has been clicked!");
                break;
            case R.id.bt_goto_3_activity:
                AppLog.i(TAG, "bt_goto_3_activity has been clicked!");
                Intent intent = new Intent(TestActivity.this, Test3Acticity.class);
                startActivity(intent);
                TestActivity.this.finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        AppLog.w(TAG, "TestActivity onDestroy=================================");
        super.onDestroy();
    }
}
