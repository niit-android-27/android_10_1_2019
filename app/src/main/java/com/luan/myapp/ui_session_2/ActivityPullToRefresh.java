package com.luan.myapp.ui_session_2;

import android.preference.SwitchPreference;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivityPullToRefresh extends AppCompatActivity {
    ArrayList<ModelSection> users = new ArrayList<>();
    void _generateData(){
        //code bai section listview
        for (int i = 0 ; i < 50 ; i ++){
          if(i%10 ==0){
              //section object
              ModelSection section = new ModelSection();
              section.setSection(true);
              section.setTitle("SECTION "+ i);
              users.add(section);
          }else{
              //child item object
              ModelUser user = new ModelUser();
              user.setName("Name at "+i);
              user.setAddress("Address at "+i);
              users.add(user);
          }
       }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this._generateData();
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.lstView);
        final MyBaseAdapter myBaseAdapter = new MyBaseAdapter(ActivityPullToRefresh.this,users);
        listView.setAdapter(myBaseAdapter);
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //cap nha du lieu moi
                ActivityPullToRefresh.this._generateData();
                myBaseAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }
}
