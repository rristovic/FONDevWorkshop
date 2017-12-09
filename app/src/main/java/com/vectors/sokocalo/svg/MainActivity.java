package com.vectors.sokocalo.svg;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity implements View.OnClickListener{

    ArrayList<MyData> myDataList;
    ReadNote read;
    WriteNote write;
    String [] noteContent = {"FIRST", "SECOND","THIRD", "FOURTH"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        // ****************************** End app code *********************** \\

            //initial note
            myDataList = new ArrayList<>();
            read = new ReadNote(this);
            write = new WriteNote(this);

           // write.write();
            write.writeNotes();
           // myDataList = read.read();

           // myDataList.add(new MyData("Initial Note", 1));
           // write.serialize(myDataList);
           // myDataList = read.deserialize();
            // if we do not have any notes create the initial note
            /*if(read.deserialize() == null) {
                myDataList.add(new MyData("Initial Note", 1));
            }

            MyAdapter myAdapter=new
                    MyAdapter( this,
                    R.layout.mylayout,
                    myDataList);
            ListView myList =
                    getListView();
            myList.setAdapter(myAdapter);*/

          //  System.out.print(myDataList.get(0).myTitle);

           // write.serialize(myDataList);


        // ********************** Adapter *********************** \\

        //android default adapter
        /*ArrayAdapter<String> myAdapter=new
                ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                noteContent);
        ListView myList=getListView();
        myList.setAdapter(myAdapter);

        //custom adapter with predefined data
        myDataList = new ArrayList<>();
        myDataList.add( new MyData("item1",10));
        myDataList.add(new MyData("item2",20));
        myDataList.add(  new MyData("item3",30));
        MyAdapter myAdapter=new
                MyAdapter( this,
                R.layout.mylayout,
                myDataList);
        ListView myList =
               getListView();
        myList.setAdapter(myAdapter);*/

        Button bNewNote = findViewById(R.id.bNewNote);
        // TODO alternativa od this
        bNewNote.setOnClickListener(this);

        // events when clicking an item
       /*AdapterView.OnItemClickListener mMessageClickedHandler =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView parent,
                                            View v,
                                            int position,
                                            long id) {
                        ((TextView)v).setText("selected");
                    }
                };

        myList.setOnItemClickListener(
                mMessageClickedHandler);*/

        //n ************************ notifikacije Pormena Podataka *********************** \\
        noteContent[0]="newdata";

       /* ArrayAdapter myAdapt=
                (ArrayAdapter) myList.getAdapter();
        myAdapt.notifyDataSetChanged();
*/
        // **************** Array List ***************** \\
        /*ArrayList<String> myArrayList=
                new ArrayList<String>();

        ArrayAdapter<String> myAdapter=
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        myArrayList);
        myAdapt.add("new data");*/


        /*As long as you are using an ArrayList you are safe to use all of the adapter data modifying methods:
add(item)
addAll(item1,item2,item3...)
clear() //remove all data
insert(item,position)
remove(item)
You can also make use of
getCount() //get number of elements
getItem(position) // get item
getItemId(position) //get item id
and
getPosition(item)*/
    }

    private void init() {



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case  R.id.bNewNote:
                ArrayList<MyData> notes = read.readNotes();
               // MyData data = read.read();
                Button button = findViewById(R.id.bNewNote);
               // button.setText(data.getMyTitle());
                button.setText(notes.get(0).getMyTitle());
                //TextView test = findViewById(R.id.test);
               // test.setText(data.myTitle);
               // Intent intentNewNote = new Intent(this, NewNoteActivity.class);
               // startActivity(intentNewNote);
                break;
            //about us dugme izbrisati nakon dodavanja list view-a
            /*case R.id.bAboutUs:

                Intent intentAboutUs = new Intent(this, AboutUsActivity.class);
                startActivity(intentAboutUs);
                break;*/

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menuAboutUs:
                Intent intentAboutUs = new Intent(this, AboutUsActivity.class);
                startActivity(intentAboutUs);
                break;
            case R.id.menuSettings:
                Intent intentSettings = new Intent(this, SettingsActivity.class);
                startActivity(intentSettings);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }


}
