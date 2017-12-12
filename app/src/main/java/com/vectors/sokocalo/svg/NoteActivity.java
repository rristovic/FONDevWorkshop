package com.vectors.sokocalo.svg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class NoteActivity extends AppCompatActivity {

    int number;
    String noteText;
    WriteNote write;
    ReadNote read;
    EditText etNote;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Bundle b = this.getIntent().getExtras();
        number = Integer.parseInt(b.getString(MyAdapter.BUNDLE_NUMBER_KEY));
        noteText = b.getString(MyAdapter.BUNDLE_NOTE_KEY);


         read = new ReadNote(this);
         write = new WriteNote(this);

        etNote = findViewById(R.id.etSingleNoteDisplay);
        etNote.setText(noteText);

        Button bDelete = findViewById(R.id.bDeleteNote);
        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<MyData> notes = read.readNotes();

                notes.remove(number-1);

                write.writeNotes(notes);

                finish();

            }
        });
        Button bSaveNote = findViewById(R.id.bSaveNote);
        bSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<MyData> notes = read.readNotes();
                noteText = etNote.getText().toString();
                notes.get(number).setMyTitle(noteText);

                write.writeNotes(notes);

                finish();

            }
        });


    }
}
