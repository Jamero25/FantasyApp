package com.example.usuario.fantasyapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.widget.Button;

import java.util.ArrayList;


public class BuscadorActivity extends ActionBarActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button btnCountry;
    private Button btnLeague;
    private GridLayoutManager recycleLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);




        /*
        Json local
         */

        final ReadLocalJSON readLocalJSON = new ReadLocalJSON();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerteam);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);


        btnCountry = (Button) findViewById(R.id.btnLeft);
        btnLeague = (Button) findViewById(R.id.btnRigth);

        btnLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.removeAllViews();
                ArrayList<Team> team = null;
                team = readLocalJSON.getTeam(v.getContext(), 1);
                mAdapter = new MyAdapterTeam(team, R.layout.team_cardview);

                recyclerView.setAdapter(mAdapter);
                recyclerView.setVisibility(View.VISIBLE);

                Animation transparente = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_grow_fade_in_from_bottom);
                transparente.setDuration(2000);

                //  transparente.setInterpolator(new BounceInterpolator());
                transparente.setInterpolator(new AnticipateInterpolator());
                recyclerView.startAnimation(transparente);
            }
        });


        btnCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.removeAllViews();
                ArrayList<Team> team = null;
                team = readLocalJSON.getTeam(v.getContext(), 0);
                mAdapter = new MyAdapterTeam(team, R.layout.team_cardview);

                recyclerView.setAdapter(mAdapter);
                recyclerView.setVisibility(View.VISIBLE);

                Animation transparente = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_grow_fade_in_from_bottom);
                transparente.setDuration(2000);

                //  transparente.setInterpolator(new BounceInterpolator());
                transparente.setInterpolator(new AnticipateInterpolator());
                recyclerView.startAnimation(transparente);


            }
        });



       // AnimationSet animationSet = new AnimationSet(true);
       // animationSet.setInterpolator(new BounceInterpolator());
       // animationSet.start();




       // ObjectAnimator animator =  ObjectAnimator.ofFloat(recyclerView, "rotationY", 0.0f, 360f );
       // animator.setDuration(3000);
       // animator.setInterpolator(new BounceInterpolator());
       // animator.start();

        /*
        Esta parte es la normal
         */


    //    recyclerView.setVisibility(View.VISIBLE);

     //    Animation transparente = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_grow_fade_in_from_bottom);
      //   transparente.setDuration(2000);

      //  transparente.setInterpolator(new BounceInterpolator());
      //  transparente.setInterpolator(new AnticipateInterpolator());
       // recyclerView.startAnimation(transparente);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_buscador, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
