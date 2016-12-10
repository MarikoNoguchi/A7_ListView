package edu.mnstate.cw3967me.a7_listview;

/*
set name and picture of the president on each widget
Mariko Nogchi
10/21/2016
 */

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by marikonoguchi on 10/19/16.
 */
public class CustomAdapter extends ArrayAdapter<PresData> {
    final Context context = getContext();
    PackageManager packageManager;
    LayoutInflater inflater;
    ArrayList<PresData> presObjects;    //array of PresData objects

    public CustomAdapter(Context context, int textViewResourceId, ArrayList<PresData> presObjects) {
        super(context, textViewResourceId, presObjects);
        inflater = LayoutInflater.from(context);
        packageManager = context.getPackageManager();
        this.presObjects = presObjects;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.pres_list, null);
        TextView name = (TextView) view.findViewById(R.id.presName);
        ImageView pic = (ImageView) view.findViewById(R.id.presPic);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);

        name.setText(presObjects.get(i).getPresName());
        pic.setImageResource(presObjects.get(i).getPresPic());

        name.setId(presObjects.get(i).getPresId());
        pic.setId(presObjects.get(i).getPresId());
        linearLayout.setId(presObjects.get(i).getPresId());

        ButtonListener buttonListener = new ButtonListener(context);
        name.setOnClickListener(buttonListener);
        pic.setOnClickListener(buttonListener);
        linearLayout.setOnClickListener(buttonListener);

        return view;
    }
}

class ButtonListener implements View.OnClickListener {
    final Context context;

    ButtonListener(Context context) {
        this.context = context;
    }

    //if the user chose menu a item
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.obama:
                Toast.makeText(context, "Obama was chosen", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bush:
                Toast.makeText(context, "Bush was chosen", Toast.LENGTH_SHORT).show();
                break;
            case R.id.clinton:
                Toast.makeText(context, "Clinton was chosen", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
