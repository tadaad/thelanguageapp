package com.tadinnovativeminds.aad.thelanguageapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.myViewholder> {

    Context mcontext;
    List<item> mdata;

    public adapter(Context mcontext, List<item> mdata) {
        this.mcontext = mcontext;
        this.mdata = mdata;
    }

    @Override
    public myViewholder onCreateViewHolder(ViewGroup viewGroup, int viewtype) {

        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View v = inflater.inflate(R.layout.jm, viewGroup, false);


        return new myViewholder(v);


    }

    @Override
    public void onBindViewHolder(final myViewholder myViewholder, int i) {

        myViewholder.background_img.setImageResource(mdata.get(i).getBackground());
        //myViewholder.profile_photo.setImageResource(mdata.get(i).getProfilePhoto());
        //myViewholder.tv_title.setText(mdata.get(i).getProfileName());
        //myViewholder.tv_nbfollowers.setText(mdata.get(i).getNbFollower()+ "$ Needed");

        myViewholder.background_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, quiz.class);
                mcontext.startActivity(intent);
                //intent.putExtra("iamge_url",)
            }
        });


    }

    @Override
    public int getItemCount() {


        return mdata.size();
    }

    public class myViewholder extends RecyclerView.ViewHolder {

        ImageView profile_photo, background_img;
        TextView tv_title, tv_nbfollowers;
        Button der;


        public myViewholder(View itemView) {
            super(itemView);

            //profile_photo= itemView.findViewById(R.id.profileimage);
            background_img = itemView.findViewById(R.id.cardbackground);
            //tv_title=itemView.findViewById(R.id.textView2);
            //tv_nbfollowers=itemView.findViewById(R.id.textView6);
            // der=itemView.findViewById(R.id.btn_tad);
//tad.setOnClickListener();
            // tad.setOnClickListener(this);

        }


    }
}
