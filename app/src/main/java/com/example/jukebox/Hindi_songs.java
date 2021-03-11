package com.example.jukebox;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Hindi_songs extends AppCompatActivity {
    public MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindi_songs);
        final ArrayList<Song> SongList=new ArrayList<Song>();
        SongList.add(new Song("Silhoutte", "From Naruto",R.drawable.silhoute,R.raw.anime_silhoute));
        SongList.add(new Song("BlueBird", "From Naruto",R.drawable.bluebird,R.raw.anime_bluebird));
        SongList.add(new Song("Kanashimi",  "From Naruto",R.drawable.kanashimi,R.raw.anime_kanashimi));
        SongList.add(new Song("Heros come back",  "From Naruto",R.drawable.heroscomeback,R.raw.anime_heroscomeback));
        SongList.add(new Song("Sign",  "From Naruto",R.drawable.sign,R.raw.anime_sign));
        SongList.add(new Song("Unravel", "From Tokyo Ghoul",R.drawable.tokyoghoul,R.raw.anime_tokyoghoul));
        SongList.add(new Song("Imagination", "From Haikyuu",R.drawable.haikyuu,R.raw.anime_haikyuu));
        SongList.add(new Song("Gurenge", "From Demon Slayer",R.drawable.gurenge,R.raw.anime_gurenge));
        SongList.add(new Song("Chozetsu Dynamic", "From DBS",R.drawable.dbs1,R.raw.anime_dbs1));
        SongList.add(new Song("Limit Break", "From DBS",R.drawable.dbs2,R.raw.anime_dbs2));
        SongList.add(new Song("Odd Future", "From Boku No Hero Academia",R.drawable.oddfuture,R.raw.anime_oddfuture));
        SongAdapter adapter=new SongAdapter(this,SongList);
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song nowPlaying=SongList.get(position);
                if(mediaPlayer!=null){mediaPlayer.stop();}
                mediaPlayer=MediaPlayer.create(Hindi_songs.this,nowPlaying.getSongRes());
                if(nowPlaying.ifPlaying()==0){
                    for(int i=0;i<SongList.size();i++){
                            SongList.get(i).changeStatus(0);
                    }
                    nowPlaying.changeStatus(1);
                    mediaPlayer.start();
                }
                else {
                    nowPlaying.changeStatus(0);
                    mediaPlayer.pause();
                }
            }
        });
    }
}