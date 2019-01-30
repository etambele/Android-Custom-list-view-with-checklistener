package com.ambell.customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    ListView myListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String [] items = new String[]{"Apple", "Orange", "Pinapple", "Grape"};

        ListAdapter myAdapter = new CustomAdapter(this, items);
        myListview = findViewById(R.id.thislist);
        myListview.setAdapter(myAdapter);

        myListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String i = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int pos = myListview.getPositionForView(buttonView);
        String foodname = String.valueOf(myListview.getItemAtPosition(pos));
        Toast.makeText(this, ""+pos + " "+foodname, Toast.LENGTH_SHORT).show();

    }
}
