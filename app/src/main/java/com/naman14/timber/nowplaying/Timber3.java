/*
 * Copyright (C) 2015 Naman Dwivedi
 *
 * Licensed under the GNU General Public License v3
 *
 * This is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 */

package com.naman14.timber.nowplaying;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naman14.timber.MusicPlayer;
import com.naman14.timber.R;

public class Timber3 extends BaseNowplayingFragment {

    private TextView songtitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_timber3, container, false);
        songtitle = (TextView) rootView.findViewById(R.id.song_title);

        setMusicStateListener();
        setSongDetails(rootView);

        initGestures(rootView.findViewById(R.id.album_art));

        return rootView;
    }

    @Override
    public void updateSongDetails(){
        super.updateSongDetails();
        if(MusicPlayer.getTrackName().length() <= 23){
            songtitle.setTextSize(25);
        }
        else if(MusicPlayer.getTrackName().length() >= 30){
            songtitle.setTextSize(18);
        }
        else{
            songtitle.setTextSize(18 + (MusicPlayer.getTrackName().length() - 24));
        }
    }

}
