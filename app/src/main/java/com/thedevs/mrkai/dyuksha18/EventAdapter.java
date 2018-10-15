package com.thedevs.mrkai.dyuksha18;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialleanback.MaterialLeanBack;

import java.util.HashMap;

public class EventAdapter extends MaterialLeanBack.Adapter<EventCardViewHolder> {


    private int cell_count;
    private HashMap<Integer, String> title_for_row;
    @LayoutRes
    private
    int layout_id;
    private int line_count;

    public EventAdapter(int cell_count, int line_count, HashMap<Integer, String> title_for_row, @LayoutRes int layout_id) {
        this.cell_count = cell_count;
        this.line_count = line_count;
        this.title_for_row = title_for_row;
        this.layout_id = layout_id;
    }


    @Override
    public int getCellsCount(int row) {
        return cell_count;
    }

    @Override
    public int getLineCount() {
        return line_count;
    }

    @Override
    public EventCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int row) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout_id, viewGroup, false);
        return new EventCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventCardViewHolder viewHolder, int i) {
//        i represents the element in the line
        viewHolder.textView.setText("test " + getLineCount());

    }

    @Override
    public String getTitleForRow(int row) {
        return title_for_row.get(row);
    }


}
