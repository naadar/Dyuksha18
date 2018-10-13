package com.thedevs.mrkai.dyuksha18;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.materialleanback.MaterialLeanBack;

class EventCardViewHolder extends MaterialLeanBack.ViewHolder {
    TextView textView;
    ImageView imageView;

    public EventCardViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textview);
        imageView = itemView.findViewById(R.id.imageview);

    }


}
