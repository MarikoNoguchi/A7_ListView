package edu.mnstate.cw3967me.a7_listview;

import android.support.v7.app.AppCompatActivity;

/*
show a list of presidents of the United States
Mariko Noguchi
10/21/2016
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    ListView presList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] presNames = getResources().getStringArray(R.array.presNames);
        int[] presPic = {R.drawable.obama, R.drawable.bush, R.drawable.clinton};

        ArrayList<PresData> presObjects = new ArrayList<PresData>();
        for (int i = 0; i < presNames.length; i++) {
            //create PresData object
            PresData item = new PresData();
            item.setPresName(presNames[i]);
            item.setPresPic(presPic[i]);
            switch (i) {
                case 0:
                    item.setPresId(R.id.obama);
                    break;
                case 1:
                    item.setPresId(R.id.bush);
                    break;
                case 2:
                    item.setPresId(R.id.clinton);
                    break;
            }
            presObjects.add(item);
        }

        presList = (ListView) findViewById(R.id.presList);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), 0, presObjects);
        presList.setAdapter(customAdapter);

    }
}
