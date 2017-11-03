package com.galang.mychat;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

class orang{

    int foto;
    String nama,chat,tanggal;
    public orang(int foto, String nama, String chat, String tanggal)
    {
        this.nama=nama;
        this.chat=chat;
        this.tanggal=tanggal;
        this.foto=foto;
    }

    public int getfoto()
    {
        return foto;
    }

    public String getnama()
    {
        return nama;
    }

    public String getchat()
    {
        return chat;
    }

    public String gettanggal()
    {
        return tanggal;
    }
};


public class MainActivity extends AppCompatActivity {

    List<orang> chatfix = new ArrayList<orang>();
    private SharedPreference sharedPreference;
    Activity context=this;
    //deklarasi variabel reyclerview
   RecyclerView r1;
    myOwnAdapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1=(RecyclerView)findViewById(R.id.recycler_view);

        sharedPreference=new SharedPreference();
        chatfix=sharedPreference.getValue(context);
/*
        for (int a=0;a<chatfix.size();a++)
        {
            Toast.makeText(this,chatfix.get(a).getnama().toString()+chatfix.get(a).getchat().toString()+chatfix.get(a).gettanggal().toString()+chatfix.get(a).getfoto(),Toast.LENGTH_LONG).show();

        }

*/      ad=new myOwnAdapter(this,chatfix);
       r1.setAdapter(ad);
       r1.setLayoutManager(new LinearLayoutManager(this));



    }


    public void tambahPesan(View view) {

        sharedPreference.clearSharedPrefence(this);
        sharedPreference.removeSharedPrefence(this);
        sharedPreference.save(this,chatfix);
        Intent intent=new Intent(MainActivity.this,TambahActivity.class);
        startActivity(intent);


    }
}
