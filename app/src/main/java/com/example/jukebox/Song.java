package com.example.jukebox;

public class Song {
    private String songName;
    private String artistName;
    private int songimg;
    private int songRes;
    private int playing=0;
    public Song(String SongName,String ArtistName,int Songimg,int SongRes){
        songName=SongName;
        artistName=ArtistName;
        songimg=Songimg;
        songRes=SongRes;


    }
    public String getSongName(){
        return songName;
    }
    public String getArtistName(){
        return artistName;
    }
    public int getSongImg(){
        return songimg;
    }
    public int getSongRes(){
        return songRes;
    }
    public int ifPlaying(){ return playing;}
    public void changeStatus(int changeTo){playing=changeTo;}
}