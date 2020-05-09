package com.chinapex.data.analyticsaop.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.chinapex.analytics.sample.R;
import com.chinapex.analytics.sample.adapter.ViewPagerAdapter;
import com.chinapex.analytics.sample.fragment.FragmentFactory;
import com.chinapex.analytics.sample.utils.AppLog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SteelCabbage
 * @date 2018/10/17
 */
public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = FragmentActivity.class.getSimpleName();
    private ViewPager mViewPager;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private boolean init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);

        //test v4
        //initFragment();

        initFragmentNoV4();
        initView();
        initData();
    }

    private void initData() {
        mFragmentList.add(FragmentFactory.getFragment("ViewPagerFragment1"));
        mFragmentList.add(FragmentFactory.getFragment("ViewPagerFragment2"));
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), mFragmentList));
    }

    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.second_fl, FragmentFactory.getFragment("FragmentV4"), "FragmentV4");
        fragmentTransaction.commit();
    }

    private void initFragmentNoV4() {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.second_fl, FragmentFactory.getFragmentNoV4("FragmentNoV4"), "FragmentNoV4");
        fragmentTransaction.commit();
    }

    private void initFragmentNoV4Sub() {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.second_fl, FragmentFactory.getFragmentNoV4Sub("FragmentNoV4Sub"), "FragmentNoV4Sub");
        fragmentTransaction.commit();
    }

    private void initView() {
        Button btShow1 = findViewById(R.id.bt_show1);
        Button btHide1 = findViewById(R.id.bt_hide1);
        mViewPager = findViewById(R.id.view_pager);

        btShow1.setOnClickListener(this);
        btHide1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_show1:
//                AppLog.i(TAG, "bt_show1 clicked=======showFragmentV4");
//                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                BaseFragmentV4 fragment = FragmentFactory.getFragment("FragmentV4");
//                if (!fragment.isAdded()) {
//                    fragmentTransaction.add(R.id.second_fl, fragment, "FragmentV4");
//                }
//                fragmentTransaction.show(fragment).commit();

                AppLog.i(TAG, "bt_show1 clicked=======showFragmentNoV4,hideFragmentNoV4Sub");
                android.app.FragmentTransaction ftNoV4 = getFragmentManager().beginTransaction();
                android.app.Fragment fragmentNoV4 = FragmentFactory.getFragmentNoV4("FragmentNoV4");
                if (!fragmentNoV4.isAdded()) {
                    ftNoV4.add(R.id.second_fl, fragmentNoV4, "FragmentNoV4");
                }
                ftNoV4.show(fragmentNoV4).commit();

                android.app.FragmentTransaction ftSub = getFragmentManager().beginTransaction();
                ftSub.hide(FragmentFactory.getFragmentNoV4Sub("FragmentNoV4Sub"));
                ftSub.commit();
                break;
            case R.id.bt_hide1:
//                AppLog.i(TAG, "bt_hide1 clicked=======hideFragmentV4");
//                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction2.hide(FragmentFactory.getFragment("FragmentV4"));
//                fragmentTransaction2.commit();
                if (init) {
                    AppLog.i(TAG, "bt_hide1 clicked=======hideFragmentNoV4,show FragmentNoV4Sub ");
                    android.app.FragmentTransaction noV4Sub = getFragmentManager().beginTransaction();
                    android.app.Fragment fragNoV4Sub = FragmentFactory.getFragmentNoV4Sub("FragmentNoV4Sub");
                    if (!fragNoV4Sub.isAdded()) {
                        noV4Sub.add(R.id.second_fl, fragNoV4Sub, "FragmentNoV4Sub");
                    }
                    noV4Sub.show(fragNoV4Sub).commit();
                } else {
                    initFragmentNoV4Sub();
                    init = true;
                }

                android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.hide(FragmentFactory.getFragmentNoV4("FragmentNoV4"));
                ft.commit();
                break;
            default:
                break;
        }
    }
}
