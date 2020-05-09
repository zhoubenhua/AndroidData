package com.apex_data_collect.sample;

import android.app.Application;
import android.util.Log;

import com.apex_data_collect.sample.utils.AppLog;
import com.chinapex.android.datacollect.ApexAnalytics;
import com.chinapex.android.datacollect.model.bean.AnalyticsSettings;

/**
 * @author SteelCabbage
 * @date 2018/11/05
 */

public class SampleApp extends Application {

    private static final String TAG = SampleApp.class.getSimpleName();

    private static SampleApp sSampleApp;

    @Override
    public void onCreate() {
        super.onCreate();
        AppLog.i(TAG, "SampleApp start!");
        sSampleApp = this;

        initSDK();

        // 如果必要，可以关闭SDK数据上报
//        ApexAnalytics.getInstance().setShouldReport(false);
    }

    private void initSDK() {
        long time = System.currentTimeMillis();

        // 初始化埋点sdk
        ApexAnalytics.getInstance().init(new AnalyticsSettings.SettingsBuilder(sSampleApp)
                .setUuid("testUuid")
                .setChannelId("豌豆荚")
                .setVisitId("32位随机数")
                .setAppLanguage("简体中文")
                .setInnerPidValidTime(1000 * 60)
                .setLogLevel(Log.VERBOSE)
                .setDelayReportInterval(1000 * 60 * 2)//设置延时上报的时间间隔
                .setCheckInstantErrInterval(1000 * 60)//设置检查即时上报是否存在异常的时间间隔, 默认2分钟
                .setDataExpiredTime(1000 * 60 * 60 * 24 * 7)//设置数据的有效时间
                .setReportMaxNum(5)//设置上报条数
                .setReportListItemMaxNum(5)//设置列表曝光事件, 单条事件的最大条目数
//                .setServerRoot("http://yapi.demo.qunar.com/mock/12081/")
                .setServerRoot("http://52.82.15.229/CDPAnalytics/")//设置上报的服务器地址

                .setHostnameVerifier("yapi.demo.qunar.com")
//                .setServerRoot("http://52.82.15.229/CDPAnalytics/")
                .setHostnameVerifier("52.82.15.229")
//                .setServerRoot("http://nmb59x.natappfree.cc/")
//                .setHostnameVerifier("nmb59x.natappfree.cc")

                .setDebug(true)
//                .setServerRootSdk("http://yapi.demo.qunar.com/mock/12081/")
                .setServerRootSdk("http://52.82.15.229/CDPAnalytics/")//设置sdk自身功能的服务器地址
//                .setServerRootSdk("http://nmb59x.natappfree.cc/")

                .setHostnameVerifierSdk("yapi.demo.qunar.com")
                .build());

        AppLog.d(TAG, "================init ApexAnalytics cost time================:" + (System.currentTimeMillis() - time));
    }

    public static SampleApp getInstance() {
        return sSampleApp;
    }

}