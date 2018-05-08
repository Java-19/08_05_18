package com.sheygam.java_19_08_05_18;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class ButtonsFragment extends Fragment implements View.OnClickListener {

    private String[] titles = {
            "Title 1",
            "Title 2",
            "Title 3",
            "Title 4",
            "Title 5",
            "Title 6",
            "Title 7",
            "Title 8",
            "Title 9"
    };

    private Button genTitleBtn, genColorBtn;
    private ButtonsFragListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buttons, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        genColorBtn = view.findViewById(R.id.genColorBtn);
        genTitleBtn = view.findViewById(R.id.genTitleBtn);
        genTitleBtn.setOnClickListener(this);
        genColorBtn.setOnClickListener(this);
    }

    public void setListener(ButtonsFragListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.genColorBtn){
            Random rnd = new Random();
            int color = Color.rgb(rnd.nextInt(256),
                    rnd.nextInt(256),
                    rnd.nextInt(256));
            if(listener != null){
                listener.colorOnClicked(color);
            }
        }else if(v.getId() == R.id.genTitleBtn){
            Random rnd = new Random();
            int pos = rnd.nextInt(titles.length);
            if(listener != null){
                listener.titleOnClicked(titles[pos]);
            }
        }
    }

    interface ButtonsFragListener{
        void colorOnClicked(int color);
        void titleOnClicked(String title);
    }
}
