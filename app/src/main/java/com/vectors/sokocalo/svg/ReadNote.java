package com.vectors.sokocalo.svg;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadNote {



    public List<MyData> deserialize(){
        try {
            FileInputStream fi = new FileInputStream("res\\data.dat");
            ObjectInputStream oi = new ObjectInputStream(fi);
            List<MyData> notes = (ArrayList<MyData>)oi.readObject();

            oi.close();
            fi.close();
            return notes;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
