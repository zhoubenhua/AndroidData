package com.chinapex.data.analyticsaop.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.chinapex.analytics.sample.R;
import com.chinapex.analytics.sample.bean.TestTracker;
import com.chinapex.analytics.sample.utils.AppLog;
import com.chinapex.analytics.sample.utils.GsonUtils;
import com.chinapex.android.datacollect.ApexAnalytics;
import com.chinapex.android.datacollect.model.bean.ApexLocation;
import com.chinapex.android.datacollect.model.bean.TrackEvent;

import java.util.HashMap;

/**
 * @author SteelCabbage
 * @date 2018/10/17
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_PERMISSION = 201;
    private EditText mEtInputInnerPid;
    private EditText mEtInputVisitId;
    private EditText mEtInputAppLanguage;
    private Button mBtCustomClickMethod;
    private Button mBtCustomClickMethod2;
    private RelativeLayout mRlCustomClick3;
    private ScrollView mSvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        checkPermission();
    }

    private void initView() {
        Button btToTestActivity = findViewById(R.id.bt_2_test_activity);
        btToTestActivity.setOnClickListener(this);

        Button btTest = findViewById(R.id.bt_test);
        btTest.setOnClickListener(this);

        Button bt2fragment = findViewById(R.id.bt_2fragment);
        bt2fragment.setOnClickListener(this);

        Button bt2rvList = findViewById(R.id.bt_2rv_list);
        bt2rvList.setOnClickListener(this);

        Button btDelay = findViewById(R.id.bt_delay);
        btDelay.setOnClickListener(this);

        Button btInstant = findViewById(R.id.bt_instant);
        btInstant.setOnClickListener(this);

        Button btSignIn = findViewById(R.id.bt_signIn);
        btSignIn.setOnClickListener(this);

        Button bt2menuActivity = findViewById(R.id.bt_2_menu_activity);
        bt2menuActivity.setOnClickListener(this);

        Button btSignOut = findViewById(R.id.bt_signOut);
        btSignOut.setOnClickListener(this);

        Button btnClick = findViewById(R.id.bt_click_test);
        btnClick.setOnClickListener(this);

        Button btSetLocaction = findViewById(R.id.bt_setLocaction);
        btSetLocaction.setOnClickListener(this);

        mEtInputInnerPid = findViewById(R.id.et_input_inner_pid);

        Button btSetInnerPid = findViewById(R.id.bt_set_inner_pid);
        btSetInnerPid.setOnClickListener(this);

        mEtInputVisitId = findViewById(R.id.et_input_visit_id);

        Button btSetSessionId = findViewById(R.id.bt_set_session_id);
        btSetSessionId.setOnClickListener(this);

        mEtInputAppLanguage = findViewById(R.id.et_input_app_language);

        Button btSetAppLanguage = findViewById(R.id.bt_set_app_language);
        btSetAppLanguage.setOnClickListener(this);

        mBtCustomClickMethod = findViewById(R.id.bt_custom_click_method);

        mBtCustomClickMethod2 = findViewById(R.id.bt_custom_click_method2);

        mRlCustomClick3 = findViewById(R.id.rl_custom_click3);

        mSvMain = findViewById(R.id.sv_main);

        TextView tvTest6 = findViewById(R.id.tv_test6);
        tvTest6.setOnClickListener(this);
    }

    public void eat(View view) {
        AppLog.i(TAG, "eat() -> btCustomClickMethod is clicked!");
        mRlCustomClick3.setVisibility(View.GONE);
    }

    public void play(View view) {
        AppLog.i(TAG, "play() -> btCustomClickMethod2 is clicked!");
        mRlCustomClick3.setVisibility(View.VISIBLE);
    }

    public void reClick(View view) {
        AppLog.i(TAG, "reClick() -> btCustomClickMethod2 is clicked!");
        TextView textView = new TextView(this);
        textView.setText("哈哈哈哈");
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        mRlCustomClick3.addView(textView);
        AppLog.i(TAG, "reClick() -> textView isShown:" + textView.isShown());

        mRlCustomClick3.removeView(textView);
        AppLog.i(TAG, "reClick() -> after remove textView isShown:" + textView.isShown());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_2_test_activity:
                startActivity(new Intent(MainActivity.this, TestActivity.class));
                break;
            case R.id.bt_test:
                AppLog.i(TAG, "原有逻辑执行 ====== bt_test被点击了");
                break;
            case R.id.bt_2fragment:
                AppLog.i(TAG, "原有逻辑执行 ====== 跳转到FragmentActivity");
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_2rv_list:
                AppLog.i(TAG, "原有逻辑执行 ====== 跳转到ListRvActivity");
                Intent intent2 = new Intent(MainActivity.this, ListRvActivity.class);
                startActivity(intent2);
                break;
            case R.id.bt_delay:
                TestTracker testTracker = new TestTracker();
                testTracker.setDate("2018.12.12");
                testTracker.setName("张三");
                testTracker.setAge("18");
                testTracker.setWork("study");

                AppLog.d(TAG, "testTracker:" + GsonUtils.toJsonStr(testTracker));
                ApexAnalytics.getInstance().track(new TrackEvent.EventBuilder()
                        .setMode(0)
                        .setLabel("testTracker")
                        .setValue(GsonUtils.toJsonStr(testTracker))
                        .build());
                break;
            case R.id.bt_instant:
                HashMap<String, String> map = new HashMap<>();
                map.put("lala1", "lala11");
                map.put("lala2", "lala22");
                map.put("lala3", "lala33");
                map.put("lala4", "lala44");
                map.put("lala5", "lala55");

                AppLog.d(TAG, "custom map:" + GsonUtils.toJsonStr(map));
                ApexAnalytics.getInstance().track(new TrackEvent.EventBuilder()
                        .setMode(1)
                        .setLabel("customLabel")
                        .setValue(GsonUtils.toJsonStr(map))
                        .build());
                break;
            case R.id.bt_signIn:
                ApexAnalytics.getInstance().signIn("userId登入啦");
                break;
            case R.id.bt_signOut:
                ApexAnalytics.getInstance().signOut();
                break;
            case R.id.bt_click_test:
                startActivity(new Intent(this, ClickTestActivity.class));
                break;
            case R.id.bt_setLocaction:
                ApexAnalytics.getInstance().setApexLocation(new ApexLocation.LocationBuilder()
                        .setLongitude(11.22)
                        .setLatitude(55.66)
                        .setCountry("中国" + System.currentTimeMillis())
                        .setProvince("上海" + System.currentTimeMillis())
                        .setCity("上海市" + System.currentTimeMillis())
                        .setDistrict("浦东新区")
                        .build());
                break;
            case R.id.bt_set_inner_pid:
                String innerPid = mEtInputInnerPid.getText().toString().trim();
                ApexAnalytics.getInstance().setInnerPid(innerPid);
                break;
            case R.id.bt_set_session_id:
                String visitId = mEtInputVisitId.getText().toString().trim();
                ApexAnalytics.getInstance().setVisitId(visitId);
                break;
            case R.id.bt_set_app_language:
                String appLanguage = mEtInputAppLanguage.getText().toString().trim();
                ApexAnalytics.getInstance().setAppLanguage(appLanguage);
                break;
            case R.id.tv_test6:
                AppLog.i(TAG, "tv_test6 is clicked!");
                break;
            case R.id.bt_2_menu_activity:
                Intent intentMenuActivity = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intentMenuActivity);
                break;
            default:
                break;
        }
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE
                                , Manifest.permission.ACCESS_FINE_LOCATION
                                , Manifest.permission.ACCESS_COARSE_LOCATION
                                , Manifest.permission.WRITE_EXTERNAL_STORAGE
                                , Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_PERMISSION);
            }
        }
    }

}
