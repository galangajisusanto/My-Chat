package com.galang.mychat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.google.gson.Gson;
import com.galang.mychat.SharedPreference;
import com.rengwuxian.materialedittext.MaterialEditText;

public class TambahActivity extends AppCompatActivity {

    List<orang> chatfix = new ArrayList<orang>();

    MaterialEditText namaku;
    MaterialEditText chatku;
    Calendar c1= Calendar.getInstance();
    SimpleDateFormat sdf1=new SimpleDateFormat("d/M/yyy");
    String waktu;
    String nama;
    String chating;
    Integer foto=R.drawable.foto;

    private SharedPreference sharedPreference;
    Activity context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        namaku=(MaterialEditText) findViewById(R.id.edtnama);
        chatku=(MaterialEditText) findViewById(R.id.edtchat);
        sharedPreference=new SharedPreference();
        chatfix=sharedPreference.getValue(context);

    }


    public void isidata(Integer foto, String nama, String chat, String tangal )
    {
        chatfix.add(new orang(foto,nama,chat,tangal));
    }

    public void kirimPesan(View view) {

        waktu=sdf1.format(c1.getTime()).toString();
        nama=namaku.getText().toString();
        chating=chatku.getText().toString();
        isidata(foto,nama,chating,waktu);
        sharedPreference.clearSharedPrefence(context);
        sharedPreference.removeSharedPrefence(context);
        sharedPreference.save(context,chatfix);
        Intent intent=new Intent(TambahActivity.this,MainActivity.class);

        startActivity(intent);
    }

}
