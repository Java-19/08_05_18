package com.sheygam.java_19_08_05_18;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FormFragment extends Fragment implements View.OnClickListener {
    private EditText inputName, inputEmail, inputPhone,inputAddress;
    private Button okBtn;
    private Callback callback;

    public void setFormListener(Callback callback){
        this.callback = callback;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputEmail = view.findViewById(R.id.inputEmail);
        inputName = view.findViewById(R.id.inputName);
        inputPhone = view.findViewById(R.id.inputPhone);
        inputAddress = view.findViewById(R.id.inputAddress);
        okBtn = view.findViewById(R.id.okBtn);
        okBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.okBtn){
            Bundle args = new Bundle();
            args.putString("NAME",inputName.getText().toString());
            args.putString("EMAIL",inputEmail.getText().toString());
            args.putString("PHONE",inputPhone.getText().toString());
            args.putString("ADDRESS",inputAddress.getText().toString());
            setArguments(args);
            if(callback!=null){
                callback.saveForm();
            }
        }
    }

    interface Callback{
        void saveForm();
    }
}
