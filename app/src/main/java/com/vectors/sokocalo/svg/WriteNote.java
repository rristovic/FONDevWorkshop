package com.vectors.sokocalo.svg;


import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WriteNote implements Serializable {

    Context context;

    public WriteNote(Context context) {
        this.context = context;
    }

    /**
     * Used to save the date we have as notes to be read later
     */
    void serialize(ArrayList<MyData> notes){

        try {
            File file = new File(context.getFilesDir(), "data.dat");
            FileOutputStream fo = new FileOutputStream(file);
            ObjectOutputStream ou = new ObjectOutputStream(fo);
            ou.writeObject(notes);
            ou.close();
            fo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
