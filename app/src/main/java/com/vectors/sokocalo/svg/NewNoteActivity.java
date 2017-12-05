package com.vectors.sokocalo.svg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;


public class NewNoteActivity extends AppCompatActivity implements View.OnClickListener, Serializable{

    WriteNote write;
    ReadNote read;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_note);
        write = new WriteNote(this);
        read = new ReadNote(this);
        Button bAddNote = findViewById(R.id.bAddNote);
        bAddNote.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.bAddNote:
                ArrayList<MyData> currentNotes = new ArrayList<>();
                currentNotes = read.deserialize();

                currentNotes.add(new MyData("Note" , currentNotes.size()));
                write.serialize(currentNotes);
                break;

        }

    }
}
