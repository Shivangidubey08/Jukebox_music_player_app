package com.example.jukebox;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Context context, ArrayList<Song> SongList) {
        super(context, 0, SongList);
    }

        @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Song currentSong = getItem(position);

        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_name_text_view);
        songNameTextView.setText(currentSong.getSongName());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.artist_name_text_view);
        defaultTextView.setText(currentSong.getArtistName());

        ImageView Songimg=(ImageView) listItemView.findViewById(R.id.songimg);
        Songimg.setImageResource(currentSong.getSongImg());
        return listItemView;
    }
}
