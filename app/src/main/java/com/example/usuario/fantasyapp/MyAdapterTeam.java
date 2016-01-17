package com.example.usuario.fantasyapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Usuario on 24/04/2015.
 */
public class MyAdapterTeam extends android.support.v7.widget.RecyclerView.Adapter<MyAdapterTeam.ViewHolder> {
        private ArrayList<Team> teams;
        private int itemLayout;



    public MyAdapterTeam(ArrayList<Team> data, int itemLayout){
        teams = data;
        this.itemLayout=itemLayout;

    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener{
        public ImageView image;
        public TextView name;
        private ViewGroup mRoot;

        public ViewHolder(View itemView) {

            super(itemView);

            itemView.setOnClickListener(this);
            mRoot = (ViewGroup) itemView.findViewById(R.id.card_view_team);
            image = (ImageView) itemView.findViewById(R.id.imagenteam);
            name = (TextView) itemView.findViewById(R.id.txtteam);


        }

        @SuppressLint("NewApi")
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(v.getContext(), DetailsListPlayer.class);
            Bundle b = new Bundle();
            b.putString("nombre", name.getText().toString());
            intent.putExtras(b);
            v.getContext().startActivity(intent);

        }

        private void startVisibility(ViewGroup mRoot) {
            mRoot.setVisibility(View.INVISIBLE);
        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.team_cardview,viewGroup, false);
        ViewHolder vh = new ViewHolder(v);


        return  vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Team team = teams.get(i);
        viewHolder.name.setText(team.getNameTeam());
        //viewHolder.image.setImageDrawable(Drawable.createFromPath(team.getUrlImagen()));
        int imagen = viewHolder.image.getResources().getIdentifier(team.getUrlImagen(), null, viewHolder.itemView.getContext().getPackageName());
        Drawable img = viewHolder.image.getResources().getDrawable(imagen);
        viewHolder.image.setImageDrawable(img);

     /*   switch (team.getId()){
            case 1:
                viewHolder.image.setImageResource(R.drawable.barcelona);
                break;
            case 2:
                viewHolder.image.setImageResource(R.drawable.real);
                break;
        }
        */
        setTransition(viewHolder.itemView, i, team);

    }

    private void setTransition(View itemView, int i, Team team) {
        //Animation animation = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.abc_fade_in);
        //animation.setDuration(1000);
        //itemView.setAnimation(animation);

       // ObjectAnimator animator = ObjectAnimator.ofFloat(itemView, "translationY", 300, 0);
       // animator.start();

    }


    @Override
    public int getItemCount() {
        return teams.size();
    }
}
