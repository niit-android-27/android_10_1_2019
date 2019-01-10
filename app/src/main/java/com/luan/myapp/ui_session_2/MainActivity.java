package com.luan.myapp.ui_session_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ModelSection> users = new ArrayList<>();
    void _generateData(){
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
        ListView lstView = (ListView)findViewById(R.id.lstView);
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(MainActivity.this,users);
        lstView.setAdapter(myBaseAdapter);
    }
}
