package com.vectors.sokocalo.svg;


import java.io.Serializable;

public class MyData implements Serializable{

   // public String myTitle;
   // public int myNum;
    private String myTitle;
    private int myNum;
    public MyData(){
        super();
    }

    public MyData(String myTitle, int myNum) {
        super();
        this.myTitle = myTitle;
        this.myNum = myNum;
    }


    public String getMyTitle() {
        return myTitle;
    }

    public void setMyTitle(String myTitle) {
        this.myTitle = myTitle;
    }

    public int getMyNum() {
        return myNum;
    }

    public void setMyNum(int myNum) {
        this.myNum = myNum;
    }
}
