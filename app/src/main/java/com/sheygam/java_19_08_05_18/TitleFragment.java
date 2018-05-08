package com.sheygam.java_19_08_05_18;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TitleFragment extends Fragment {
    private ConstraintLayout root;
    private TextView titleTxt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_title,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        root = view.findViewById(R.id.root);
        titleTxt = view.findViewById(R.id.titleTxt);
    }

    public void changeTitle(String title){
        if(titleTxt != null){
            titleTxt.setText(title);
        }
    }

    public void changeColor(int color){
        if(root != null){
            root.setBackgroundColor(color);
        }
    }
}
