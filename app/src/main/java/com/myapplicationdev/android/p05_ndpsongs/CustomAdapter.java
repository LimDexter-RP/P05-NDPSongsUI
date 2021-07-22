package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

    public class CustomAdapter extends ArrayAdapter {
        Context parent_context;
        int layout_id;
        ArrayList<Song> songList;

        public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
            super (context, resource, objects);

            parent_context = context;
            layout_id = resource;
            songList = objects;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            // Obtain the LayoutInflater object
            LayoutInflater inflater = (LayoutInflater)
                    parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // "Inflate" the View for each row
            View rowView = inflater.inflate(layout_id, parent, false);

            // Obtain the UI components and do the necessary binding
            TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
            TextView tvYear = rowView.findViewById(R.id.textViewYear);
            TextView tvRating = rowView.findViewById(R.id.textViewRating);
            TextView tvArtist = rowView.findViewById(R.id.textViewArtist);

            // Obtain the Android Version information based on the position
            Song currentVersion = songList.get(position);

            // Set values to the TextView to display the corresponding information
            tvTitle.setText(currentVersion.getTitle());
            tvYear.setText(currentVersion.getYearReleased() + "  ");
            tvRating.setText(currentVersion.toString());
            tvArtist.setText(currentVersion.getSingers());

            return rowView;

        }}


