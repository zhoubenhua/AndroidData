package com.chinapex.data.analyticsaop.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.chinapex.analytics.sample.R;
import com.chinapex.analytics.sample.adapter.MyExtendableListViewAdapter;
import com.chinapex.analytics.sample.utils.AppLog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SteelCabbage
 * @date 2018/11/14
 */
public class FragmentNoV4 extends Fragment implements View.OnClickListener {
    private static final String TAG = FragmentNoV4.class.getSimpleName();
    private ListView mLvFrag;
    private ExpandableListView mExpandableListView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        return inflater.inflate(R.layout.fragment_v4, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btFrag = view.findViewById(R.id.bt_frag);
        btFrag.setOnClickListener(this);

        Button btFrag2 = view.findViewById(R.id.bt_frag2);
        btFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppLog.i(TAG, "FragmentNoV4 bt_frag2 匿名内部类点击");
            }
        });

        mLvFrag = view.findViewById(R.id.lv_frag);
        mLvFrag.setTag(R.id.apex_data_collect_list_data_path, "item");
        mLvFrag.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AppLog.w(TAG, "mListView 的匿名内部类");
            }
        });

        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list1.add("" + i);
        }

        mLvFrag.setAdapter(new ArrayAdapter<>(this.getActivity(), R.layout.list_view_item, R.id.list_view_item_text0, list1));

        mLvFrag.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        mExpandableListView = view.findViewById(R.id.elv_frag);
        mExpandableListView.setTag(R.id.apex_data_collect_expandable_list_group_data_path, "item");
        mExpandableListView.setTag(R.id.apex_data_collect_expandable_list_child_data_path, "item");
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

            boolean isFirst = true;

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (!isFirst) {
                    AppLog.d(TAG, "mExpandableListView   !  isFirst:");
                }
            }
        });
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_frag:
                AppLog.i(TAG, "FragmentNoV4 bt_frag clicked");
                AppLog.i(TAG, "FragmentNoV4 bt_frag getCanonicalName" + v.getContext().getClass().getCanonicalName());
                break;
            default:
                break;
        }
    }
}
