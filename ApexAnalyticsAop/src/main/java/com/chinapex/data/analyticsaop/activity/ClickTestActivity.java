package com.chinapex.data.analyticsaop.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.chinapex.analytics.sample.R;
import com.chinapex.analytics.sample.SampleApp;
import com.chinapex.analytics.sample.adapter.MyExtendableListViewAdapter;
import com.chinapex.analytics.sample.adapter.RvAdapter;
import com.chinapex.analytics.sample.bean.Student;
import com.chinapex.analytics.sample.utils.AppLog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Seven
 * @date : 2018/11/28
 */
public class ClickTestActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, RvAdapter.OnItemClickListener {

    private static final String TAG = ClickTestActivity.class.getSimpleName();

    private ListView mListView;
    private GridView mGridView;
    private ExpandableListView mExpandableListView;
    private RecyclerView mRv;
    private RvAdapter mRvAdapter;
    private ArrayList<Student> mDatas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_test);

        initView();
        initData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.start:
                AppLog.i(TAG, "开始游戏");
                break;
            case R.id.over:
                AppLog.i(TAG, "结束游戏");
                break;
            case R.id.setting1:
                AppLog.i(TAG, "声音設置");
                break;
            case R.id.setting2:
                AppLog.i(TAG, "背景設置");
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_button:
                AppLog.i(TAG, "onClick ImageButton is clicked !!!");
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent instanceof GridView) {
            AppLog.i(TAG, "mGridView item is clicked !!!  position: " + position);
            return;
        }

        if (parent instanceof ListView) {
            AppLog.i(TAG, "mListView item is clicked !!!  position: " + position);
        }
    }

    public void xmlOnClick(View view) {
        switch (view.getId()) {
            case R.id.clickable_text:
                AppLog.i(TAG, "xmlOnClick Text is clicked !!!");
                break;
            case R.id.clickable_image_view:
                AppLog.i(TAG, "xmlOnClick ImageView is clicked !!!");
                break;
            default:
                break;
        }
    }

    private void initView() {
        mListView = findViewById(R.id.list_view);
        mListView.setTag(R.id.apex_data_collect_list_data_path, "item");

        mGridView = findViewById(R.id.grid_view);
        mGridView.setTag(R.id.apex_data_collect_list_data_path, "item#mInfo#nameInner");

        mExpandableListView = findViewById(R.id.expandable_list_view);
        mExpandableListView.setTag(R.id.apex_data_collect_expandable_list_group_data_path, "item");
        mExpandableListView.setTag(R.id.apex_data_collect_expandable_list_child_data_path, "item");

        ImageButton imageButton = findViewById(R.id.image_button);

        imageButton.setOnClickListener(this);
        mGridView.setOnItemClickListener(this);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AppLog.w(TAG, "mListView 的匿名内部类");
            }
        });

        mExpandableListView.setAdapter(new MyExtendableListViewAdapter());
        //设置分组的监听
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                AppLog.i(TAG, "onGroupClick() -> groupPosition: " + groupPosition + " id: " + id);
                return false;
            }
        });
        //设置子项布局监听
        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                AppLog.i(TAG,
                        "onChildClick() -> groupPosition: " + groupPosition + " childPosition" + childPosition + " id: " + id);
                return true;
            }
        });

        //控制他只能打开一个组
        mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int count = new MyExtendableListViewAdapter().getGroupCount();
                for (int i = 0; i < count; i++) {
                    if (i != groupPosition) {
                        mExpandableListView.collapseGroup(i);
                    }
                }
            }
        });

        mExpandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

            }
        });

        mRv = findViewById(R.id.recycler_view);
        mRv.setTag(R.id.apex_data_collect_list_data_path, "item#name");
        mRv.setTag(R.id.apex_data_collect_recycler_data_name, "mDatas");

        mRv.setLayoutManager(new LinearLayoutManager(SampleApp.getInstance(), LinearLayoutManager.VERTICAL, false));

        mDatas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Student student = new Student();
            student.setName("姓名:" + i);
            student.setAge(i);
            mDatas.add(student);
        }

        mRvAdapter = new RvAdapter(mDatas);
        mRvAdapter.setOnItemClickListener(this);
        mRv.setAdapter(mRvAdapter);

        mRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        if (null == mDatas || mDatas.isEmpty()) {
            AppLog.e(TAG, "mDatas is null or empty!");
            return;
        }

        Student student = mDatas.get(position);
    }


    private void initData() {
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list1.add("" + i);
        }

        List<Student> list2 = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Student student = new Student();
            student.setName("Student:" + i);
            student.setAge(i);

            Student.Info info = new Student.Info();
            info.setNameInner("Student Inner:" + i);

            student.setInfo(info);
            list2.add(student);
        }

        mListView.setAdapter(new ArrayAdapter<>(this, R.layout.list_view_item, R.id.list_view_item_text0, list1));
        mGridView.setAdapter(new ArrayAdapter<>(this, R.layout.list_view_item, R.id.list_view_item_text0, list2));

        mExpandableListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_IDLE:
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        break;
                    case SCROLL_STATE_FLING:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_IDLE:
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        break;
                    case SCROLL_STATE_FLING:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });

        mGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_IDLE:
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        break;
                    case SCROLL_STATE_FLING:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }

}
