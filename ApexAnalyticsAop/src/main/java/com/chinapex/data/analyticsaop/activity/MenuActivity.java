package com.chinapex.data.analyticsaop.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.chinapex.analytics.sample.R;
import com.chinapex.analytics.sample.utils.AppLog;

public class MenuActivity extends Activity {

    private static final String TAG = MenuActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_play:
                AppLog.i(TAG, "menu_play is selected");
                break;
            case R.id.menu_eat:
                AppLog.i(TAG, "menu_eat is selected");
                break;
            case R.id.menu_sleep:
                AppLog.i(TAG, "menu_sleep is selected");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
