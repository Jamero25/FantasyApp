package com.example.usuario.fantasyapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;

import java.util.ArrayList;


public class DetailsListPlayer extends ActionBarActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_list_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerPlayer);
        GridLayoutManager recycleLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);


       // recyclerView.setLayoutManager(recycleLayoutManager);
        final ReadLocalJSON readLocalJSON = new ReadLocalJSON();


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");

        Bundle bundle = this.getIntent().getExtras();
        String name = bundle.getString("nombre");

        if(name != null){
        recyclerView.removeAllViews();
            ArrayList<Player> player = null;
            player = readLocalJSON.getPlayer(this, name);
            mAdapter = new MyAdapterPlayer(player, R.layout.player_cardview);
            recyclerView.setAdapter(mAdapter);
            recyclerView.setVisibility(View.VISIBLE);

            Animation transparente = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_grow_fade_in_from_bottom);
            transparente.setDuration(2000);

            //  transparente.setInterpolator(new BounceInterpolator());
            transparente.setInterpolator(new AnticipateInterpolator());
            recyclerView.startAnimation(transparente);




        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details_list_player, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == android.R.id.home){

        }

        return super.onOptionsItemSelected(item);
    }
}
