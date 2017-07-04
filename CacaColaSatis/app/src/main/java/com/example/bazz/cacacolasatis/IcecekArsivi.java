package com.example.bazz.cacacolasatis;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class IcecekArsivi extends AppCompatActivity {
    SQLiteDatabase db =null;
    ListView listArsiv ;
    public ArrayList <String> myArrayList = new ArrayList <String> ();
    ListAdapter myListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icecek_arsivi);
        listArsiv = (ListView)findViewById(R.id.ListArsiv);
        ArrayList <String> dbArray = myArrayListDatabase();
        ListAdapter myListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,dbArray);
        listArsiv.setAdapter(myListAdapter);
    }

    public ArrayList <String> myArrayListDatabase(){
        db=openOrCreateDatabase("ICECEKHESAPLAMA",MODE_PRIVATE,null);
        String selectQuery="Select * from Icecek";
        Cursor c = db.rawQuery(selectQuery,null);
        c.moveToFirst();
        String dbString="";

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("drinkname"))!=null){
                dbString+=c.getString(c.getColumnIndex("drinkname"));
                dbString+="\n";
                String drinkname=c.getString(c.getColumnIndex("drinkname"));
                String drinkdate=c.getString(c.getColumnIndex("drinkdate"));


                myArrayList.add(drinkdate+" "+drinkname);
            }
            c.moveToNext();
        }
        db.close();
        return myArrayList;

    }

}
