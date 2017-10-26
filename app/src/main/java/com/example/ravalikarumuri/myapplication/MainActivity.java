package com.example.ravalikarumuri.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnvisitor= (Button) findViewById(R.id.visitorentry);
      final ImageView image=(ImageView)findViewById(R.id.imageview);
        btnvisitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,VisitorActivity.class);
                startActivity(intent);
            }
        });
        final Button btnadmin= (Button) findViewById(R.id.adminview);
        btnadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnadmin.setVisibility(View.INVISIBLE);
                btnvisitor.setVisibility(View.INVISIBLE);
                image.setVisibility(View.INVISIBLE);
                final ListView listview = (ListView) findViewById(R.id.listView1);
                DatabaseHandler db=new DatabaseHandler(MainActivity.this);
                ArrayList<Visitor> visitorlst=new ArrayList<Visitor>();
                visitorlst=db.getAllContacts();
                ListViewAdapter listViewAdapter = new ListViewAdapter(MainActivity.this, visitorlst);
                listview.setAdapter(listViewAdapter);

            }

        });
    }

}
