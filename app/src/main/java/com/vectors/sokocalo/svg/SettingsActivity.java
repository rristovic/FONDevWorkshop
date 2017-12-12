package com.vectors.sokocalo.svg;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{


    public static final String KEY_SHARED_PREFS_TYPE = "Shared prefferences key";
    public static final int FIRST_TYPE = 1;
    public static final int SECOND_TYPE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        Button bSelectNoteType1 = findViewById(R.id.bSelectNoteType1);
        Button bSelectNoteType2 = findViewById(R.id.bSelectNoteType2);
        bSelectNoteType1.setOnClickListener(this);
        bSelectNoteType2.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        switch(view.getId()){

            case R.id.bSelectNoteType1:

                editor.putInt(KEY_SHARED_PREFS_TYPE, FIRST_TYPE);
                editor.apply();
                break;
            case R.id.bSelectNoteType2:

                editor.putInt(KEY_SHARED_PREFS_TYPE, SECOND_TYPE);
                editor.apply();

                break;
        }
    }
}
