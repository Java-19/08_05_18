package com.sheygam.java_19_08_05_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TestFormActivity extends AppCompatActivity implements FormFragment.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_form);
        FormFragment fragment = new FormFragment();
        fragment.setFormListener(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag_container,fragment,"FORM_FRAG")
                .commit();
    }

    @Override
    public void saveForm() {
        FormFragment fragment = (FormFragment) getSupportFragmentManager()
                .findFragmentByTag("FORM_FRAG");
        if(fragment!=null){
            Bundle args = fragment.getArguments();
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtras(args);
            startActivity(intent);
        }
    }
}
