package com.luan.myapp.ui_session_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> sections = new ArrayList<String>();
    HashMap<String,ArrayList<ModelUser>> users = new HashMap<>();
    //ArrayList<ModelSection> users = new ArrayList<>();
    void _generateData(){
        //code bai expandable listview
       sections.add("A");
       sections.add("B");
       sections.add("C");
       sections.add("D");
       sections.add("E");

       ArrayList<ModelUser> usersGroupA = new ArrayList<>();
       for (int i = 0 ; i < 5 ; i ++){
            //section object
            ModelUser user = new ModelUser();
            user.setName("Nguyen Van A "+i);
            user.setAddress("Address A "+i);
            usersGroupA.add(user);
       }

       users.put("A",usersGroupA);

       ArrayList<ModelUser> usersGroupB = new ArrayList<>();
        for (int i = 0 ; i < 5 ; i ++){
            //section object
            ModelUser user = new ModelUser();
            user.setName("Nguyen Van B "+i);
            user.setAddress("Address B "+i);
            usersGroupB.add(user);
        }
        users.put("B",usersGroupB);


        ArrayList<ModelUser> usersGroupC = new ArrayList<>();
        for (int i = 0 ; i < 5 ; i ++){
            //section object
            ModelUser user = new ModelUser();
            user.setName("Nguyen Van C "+i);
            user.setAddress("Address C "+i);
            usersGroupC.add(user);
        }
        users.put("C",usersGroupC);

        ArrayList<ModelUser> usersGroupD= new ArrayList<>();
        for (int i = 0 ; i < 5 ; i ++){
            //section object
            ModelUser user = new ModelUser();
            user.setName("Nguyen Van D "+i);
            user.setAddress("Address D "+i);
            usersGroupD.add(user);
        }
        users.put("D",usersGroupD);

        ArrayList<ModelUser> usersGroupE= new ArrayList<>();
        for (int i = 0 ; i < 5 ; i ++){
            //section object
            ModelUser user = new ModelUser();
            user.setName("Nguyen Van E "+i);
            user.setAddress("Address E "+i);
            usersGroupE.add(user);
        }
        users.put("E",usersGroupE);

        //code bai section listview
        /*for (int i = 0 ; i < 50 ; i ++){
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
       }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this._generateData();
        setContentView(R.layout.activity_main);
        /*ListView lstView = (ListView)findViewById(R.id.lstView);
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(MainActivity.this,users);
        lstView.setAdapter(myBaseAdapter);*/

       // ExpandableListView lsView = (ExpandableListView)findViewById(R.id.expdListView);
      //  MyExpandAdapter myExpandAdapter = new MyExpandAdapter(MainActivity.this,sections,users);
       // lsView.setAdapter(myExpandAdapter);

    }
}
