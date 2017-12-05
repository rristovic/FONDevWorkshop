package com.vectors.sokocalo.svg;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteNote {

    /**
     * Used to save the date we have as notes to be read later
     */
    void serialize(List<MyData> notes){

        try {
            FileOutputStream fo = new FileOutputStream("res\\data.dat");
            ObjectOutputStream ou = new ObjectOutputStream(fo);
            ou.writeObject(notes);
            ou.close();
            fo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
