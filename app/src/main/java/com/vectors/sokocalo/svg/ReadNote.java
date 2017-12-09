package com.vectors.sokocalo.svg;


import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ReadNote{

    Context context;

    public ReadNote(Context context) {
        this.context = context;
    }

    //ArrayList<MyData> notes;
    public ArrayList<MyData> readNotes(){
        ArrayList<MyData> notes = new ArrayList<>();
        ObjectInputStream input;
        String filename = "testFilemost.srl";
        ArrayList<MyData> empty = new ArrayList<>();
        empty.add(new MyData("error",0));

        try {
            input = new ObjectInputStream(new FileInputStream(new File(new File(context.getFilesDir(),"")+File.separator+filename)));
            notes = (ArrayList<MyData>) input.readObject();
            Log.v("serialization","Person a="+notes.get(0).getMyTitle());
            input.close();
            return notes;
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return empty;
    }

    public MyData read(){
        MyData note = new MyData();
        ObjectInputStream input;
        String filename = "testFilemost.srl";

        try {
            input = new ObjectInputStream(new FileInputStream(new File(new File(context.getFilesDir(),"")+File.separator+filename)));
            note = (MyData) input.readObject();
            Log.v("serialization","Person a="+note.getMyTitle());
            input.close();
            return note;
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            return new MyData("error", 0);
    }

}
