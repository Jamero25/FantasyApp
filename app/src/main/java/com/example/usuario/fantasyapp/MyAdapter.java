package com.example.usuario.fantasyapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Usuario on 24/04/2015.
 */
public class MyAdapter extends android.support.v7.widget.RecyclerView.Adapter<MyAdapter.ViewHolder> {



    public static class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener{
        public ImageView image;
        public TextView name;
        public TextView description;
        private ViewGroup mRoot;

        public ViewHolder(View itemView) {

            super(itemView);

            itemView.setOnClickListener(this);
            mRoot = (ViewGroup) itemView.findViewById(R.id.card_view);
            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.description);
        }

        @SuppressLint("NewApi")
        @Override
        public void onClick(View v) {
        v.setTransitionName("prueba");
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation((android.app.Activity) v.getContext(),v, v.getTransitionName());
       v.getContext().startActivity(new Intent(v.getContext(), Activity2.class), compat.toBundle());

       //     Explode fade = new Explode();
        //    fade.setDuration(2000);
         //   TransitionManager.beginDelayedTransition(mRoot, fade);
          // Toast.makeText(v.getContext(), "CLICK", Toast.LENGTH_SHORT).show();
            startVisibility(mRoot);


        }

        private void startVisibility(ViewGroup mRoot) {
            mRoot.setVisibility(View.INVISIBLE);
        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view,viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return  vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.name.setText("Generar");
        viewHolder.description.setText("Equipo");
    }



    @Override
    public int getItemCount() {
        return 1;
    }
}
