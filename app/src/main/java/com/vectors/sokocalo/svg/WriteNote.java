package com.vectors.sokocalo.svg;


import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WriteNote  {

    Context context;

    public WriteNote(Context context) {
        this.context = context;
    }

    public void writeNotes(){
         ArrayList<MyData> notes = new ArrayList<>();
         notes.add(new MyData("test", 1));
         notes.add(new MyData("test2", 2));
        String filename = "testFilemost.srl";
        ObjectOutput out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(new File(context.getFilesDir(),"")+File.separator+filename));
            out.writeObject(notes);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(){
       // ArrayList<MyData> notes = new ArrayList<>();
       // notes.add(new MyData("test", 1));
        MyData note = new MyData("NOTE",2);
        String filename = "testFilemost.srl";
        ObjectOutput out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(new File(context.getFilesDir(),"")+File.separator+filename));
            out.writeObject(note);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
