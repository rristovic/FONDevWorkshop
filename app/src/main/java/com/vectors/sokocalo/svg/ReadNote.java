package com.vectors.sokocalo.svg;


import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReadNote implements Serializable{

    Context context;

    public ReadNote(Context context) {
        this.context = context;
    }

    ArrayList<MyData> notes;

    public ArrayList<MyData> deserialize(){
        try {
            File file = new File(context.getFilesDir(), "data.dat");
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            notes = (ArrayList<MyData>)oi.readObject();
          //  notes = (ArrayList<MyData>) oi.readObject();
                oi.close();
                fi.close();
                return notes;


           /* oi.close();
            fi.close();
            return null;*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
