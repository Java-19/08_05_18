package com.sheygam.java_19_08_05_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ButtonsFragment.ButtonsFragListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            Log.d("MY_TAG", "onCreate: " + extras.getString("NAME"));
        }
        ButtonsFragment fragment = new ButtonsFragment();
        fragment.setListener(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragContainer,fragment)
                .commit();
    }

    @Override
    public void colorOnClicked(int color) {
        TitleFragment fragment = (TitleFragment) getSupportFragmentManager()
                                        .findFragmentById(R.id.titleFragment);
        if(fragment != null){
            fragment.changeColor(color);
        }
    }

    @Override
    public void titleOnClicked(String title) {
        TitleFragment fragment = (TitleFragment) getSupportFragmentManager()
                .findFragmentById(R.id.titleFragment);
        if(fragment != null){
            fragment.changeTitle(title);
        }
    }
}
