package com.thedevs.mrkai.dyuksha18;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialleanback.MaterialLeanBack;
import com.google.firebase.firestore.FirebaseFirestore;

public class EventAdapter extends MaterialLeanBack.Adapter<EventCardViewHolder> {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    int cell_count;
    String title_for_row;
    @LayoutRes
    int layout_id;

    public EventAdapter(int cell_count, String title_for_row, @LayoutRes int layout_id) {
        this.cell_count = cell_count;
        this.title_for_row = title_for_row;
        this.layout_id = layout_id;
    }


    @Override
    public int getCellsCount(int row) {
        return cell_count;
    }

    @Override
    public int getLineCount() {
        return 1;
    }

    @Override
    public EventCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int row) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout_id, viewGroup, false);
        return new EventCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventCardViewHolder viewHolder, int i) {
//        i represents the element in the line
        viewHolder.textView.setText("test " + i);
    }

    @Override
    public String getTitleForRow(int row) {
        return title_for_row;
    }


}
