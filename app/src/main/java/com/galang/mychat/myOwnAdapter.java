package com.galang.mychat;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Galang on 10/29/2017.
 */



public class myOwnAdapter extends RecyclerView.Adapter<myOwnAdapter.myOwnHolder> {

    List<orang> chatfix = new ArrayList<orang>();
    Context ctx;


    public myOwnAdapter(Context ct, List<orang> list)
    {   ctx=ct;
        chatfix=list;
    }

    @Override
    public myOwnHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myInnflator= LayoutInflater.from(ctx);
        View myOwnView=myInnflator.inflate(R.layout.my_row,parent,false);
        return new myOwnHolder(myOwnView);
    }

    @Override
    public void onBindViewHolder(myOwnHolder holder, int position) {

        holder.t1.setText(chatfix.get(position).getnama());
        holder.t2.setText(chatfix.get(position).getchat());
        holder.t3.setText(chatfix.get(position).gettanggal());
        holder.myImage.setImageResource(chatfix.get(position).getfoto());


    }




    @Override
    public int getItemCount() {
        return chatfix.size();
    }

    public class myOwnHolder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3;
        ImageView myImage;
        public myOwnHolder(View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.mynama);
            t2=(TextView)itemView.findViewById(R.id.mypesan);
            t3=(TextView)itemView.findViewById(R.id.mytanggal);
            myImage=(ImageView)itemView.findViewById(R.id.myImage);
        }
    }
}
