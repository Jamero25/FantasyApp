package com.example.usuario.fantasyapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
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
public class MyAdapterPlayer extends android.support.v7.widget.RecyclerView.Adapter<MyAdapterPlayer.ViewHolder> {
    private ArrayList<Player> players;
    private int itemLayout;



    public MyAdapterPlayer(ArrayList<Player> data, int itemLayout){
        players = data;
        this.itemLayout=itemLayout;

    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener{
        public ImageView image;
        public TextView name;
        public TextView team;
        public TextView valor;
        private ViewGroup mRoot;

        public ViewHolder(View itemView) {

            super(itemView);

            itemView.setOnClickListener(this);
            mRoot = (ViewGroup) itemView.findViewById(R.id.card_view_player);
            image = (ImageView) itemView.findViewById(R.id.imagenPlayer);
            name = (TextView) itemView.findViewById(R.id.txtname);
            team = (TextView) itemView.findViewById(R.id.teamPlayer);
            valor = (TextView) itemView.findViewById(R.id.valoracionPlayer);
        }

        @SuppressLint("NewApi")
        @Override
        public void onClick(View v) {

            //Toast.makeText(v.getContext(), "Jugador", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(v.getContext(), InfoPlayerActivity.class);
            intent.putExtra(InfoPlayerActivity.EXTRA_NAME, name.getText().toString());
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    ((DetailsListPlayer)v.getContext()),
                    new Pair<View, String>(v.findViewById(R.id.imagenPlayer),
                            InfoPlayerActivity.VIEW_NAME_HEADER_IMAGE),
                    new Pair<View, String>(v.findViewById(R.id.txtname),
                            InfoPlayerActivity.VIEW_NAME_HEADER_TITLE));

            ActivityCompat.startActivity( ((DetailsListPlayer)v.getContext()), intent, activityOptionsCompat.toBundle());



        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_cardview,viewGroup, false);
        ViewHolder vh = new ViewHolder(v);


        return  vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Player player = players.get(i);
        viewHolder.name.setText(player.getName());
        viewHolder.team.setText(player.getTeam());
        viewHolder.valor.setText(player.getValor());
        //viewHolder.image.setImageDrawable(Drawable.createFromPath(team.getUrlImagen()));
        int imagen = viewHolder.image.getResources().getIdentifier(player.getUrlImagen(), null, viewHolder.itemView.getContext().getPackageName());
        Drawable img = viewHolder.image.getResources().getDrawable(imagen);
        viewHolder.image.setImageDrawable(img);
    }




    @Override
    public int getItemCount() {
        return players.size();
    }
}
