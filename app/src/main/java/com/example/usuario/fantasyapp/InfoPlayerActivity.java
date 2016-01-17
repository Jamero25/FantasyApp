package com.example.usuario.fantasyapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class InfoPlayerActivity extends ActionBarActivity {

    public static  final String EXTRA_NAME = "name";


    // View name of the header image. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_IMAGE = "detail:header:image";

    // View name of the header title. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";

    private ImageView mHeaderImagenView;
    private TextView mHeaderTitle;
    private TextView mInformationPlayer;
    private String namePlayer;
    private Button buttonSelectable;
    private ArrayList<DetailsPlayer> detailsPlayers;
    final ReadLocalJSON readLocalJSON = new ReadLocalJSON();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_player);

        mHeaderImagenView = (ImageView) findViewById(R.id.imagenPlayer1);
        mHeaderTitle = (TextView) findViewById(R.id.namePlayer1);
        mInformationPlayer = (TextView) findViewById(R.id.informationPlayer);
        buttonSelectable = (Button) findViewById(R.id.buttonselectable);
        buttonSelectable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity2.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                v.getContext().startActivity(intent);
                finish();

            }
        });
        ViewCompat.setTransitionName(mHeaderImagenView, VIEW_NAME_HEADER_IMAGE);
        ViewCompat.setTransitionName(mHeaderTitle, VIEW_NAME_HEADER_TITLE);
        namePlayer = getIntent().getStringExtra(EXTRA_NAME);
        switch (namePlayer){
            case "Daniel Hernández":
                namePlayer = "Daniel";
            break;

        }

        if(namePlayer != null)
        {
        detailsPlayers = readLocalJSON.getInformationPlayer(this, namePlayer);
        }

        if(detailsPlayers.size() !=0){
            loadItem();
        }



    }

    private void loadItem() {

        DetailsPlayer detailsPlayer = detailsPlayers.get(0);
        mHeaderTitle.setText(detailsPlayer.getName());


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && addTransitionListener()){

            int imagen = getResources().getIdentifier(detailsPlayer.getUrlImagen(), null, getPackageName());
            Drawable img = getResources().getDrawable(imagen);
            mHeaderImagenView.setImageDrawable(img);
            mInformationPlayer.setText(detailsPlayer.getDescription());
        }


    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private boolean addTransitionListener() {
        TransitionInflater inflater = TransitionInflater.from(this);
        Transition transition = inflater.inflateTransition(R.transition.transition_details);
        getWindow().setSharedElementEnterTransition(transition);
        if(transition!= null){

            transition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {

                }

                @Override
                public void onTransitionEnd(Transition transition) {
                    loadFullSizeImage();
                    transition.removeListener(this);
                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });

            return true;
        }
        return false;
    }

    private void loadFullSizeImage() {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info_player, menu);
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
