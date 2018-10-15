package com.thedevs.mrkai.dyuksha18;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.materialleanback.MaterialLeanBack;

import java.util.HashMap;


public class Events extends Fragment {

    MaterialLeanBack workshops;
    HashMap<Integer, String> titles = new HashMap<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_events, container, false);
        workshops = view.findViewById(R.id.materialLeanBack);
        Customizer(workshops);

        titles.put(0, "Workshop");
        titles.put(1, "Informal");
        titles.put(2, "Cultural");
        titles.put(3, "Online");

        workshops.setAdapter(new EventAdapter(10, titles.size(), titles, R.layout.event_cell));
        workshops.setOnItemClickListener(new MaterialLeanBack.OnItemClickListener() {
            @Override
            public void onTitleClicked(int row, String text) {

            }

            @Override
            public void onItemClicked(int row, int column) {
                Toast.makeText(getContext(), "" + row, Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void Customizer(MaterialLeanBack materialLeanBack) {
        materialLeanBack.setCustomizer(new MaterialLeanBack.Customizer() {

            @Override
            public void customizeTitle(TextView textView) {
                textView.setAllCaps(true);
                textView.setTypeface(null, Typeface.BOLD);
                textView.setPadding(10, 0, 10, 0);
                textView.setGravity(Gravity.LEFT);
                textView.setTextSize(20);
                textView.setTextColor(Color.GRAY);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(50, 0, 10, 50);
                textView.setLayoutParams(params);
//                textView.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "font/roboto_condensed_bold.xml"));
            }
        });
    }
}
