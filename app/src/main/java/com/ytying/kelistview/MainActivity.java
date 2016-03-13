package com.ytying.kelistview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ytying.ylistview.KeListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    KeListView listview;

    List<Integer> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (KeListView) findViewById(R.id.listview);

        initList();
        final TodayAdapter adapter = new TodayAdapter(MainActivity.this, list);
        listview.setAdapter(adapter);
        listview.setOnRefreshListener(new KeListView.RefreshListener() {
            @Override
            public void onRefresh() {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runRefresh();
                        adapter.notifyDataSetChanged();
                        listview.onRefreshComplete();
                    }
                }, 3000);

            }

            @Override
            public void onLoad() {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runLoad();
                        adapter.notifyDataSetChanged();
                        listview.onLoadComplete();
                    }
                }, 3000);
            }
        });
    }


    public void runRefresh() {
        list.add(0, 100);
        list.add(0, 101);
        list.add(0, 102);
    }

    public void runLoad() {
        list.add(999);
        list.add(998);
        list.add(997);
    }

    public void initList() {
        for (int i = 0; i < 10; i++) {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
        }
    }
}
