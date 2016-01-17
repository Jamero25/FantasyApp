package com.example.usuario.fantasyapp;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;


public class Activity2 extends ActionBarActivity {




    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.containtRadius);

        if(Build.VERSION.SDK_INT>=21){
           // Explode slide = new Explode();
           // slide.setDuration(1000);
            TransitionInflater inflater = TransitionInflater.from(this);
            Transition transition = inflater.inflateTransition(R.transition.transition_a);
            getWindow().setSharedElementEnterTransition(transition);

        }
        getWindow().getSharedElementEnterTransition().addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {

               // Animation transparente = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_fade_in);
               // transparente.reset();
               // textView.startAnimation(transparente);

                /*
                CircularReveal
                 */
                int cx = (frameLayout.getLeft() + frameLayout.getRight()) /2;
                int cy = (frameLayout.getTop() + frameLayout.getBottom()) /2;
                int finalRadius = Math.max(frameLayout.getWidth(), frameLayout.getHeight());
              //  int cx = 500;
               // int cy = 120;
               // int finalRadius = 600;
                Animator anim = ViewAnimationUtils.createCircularReveal(frameLayout, cx, cy, 0, finalRadius);
                frameLayout.setVisibility(View.VISIBLE);
               // anim.setDuration(1000);
                anim.start();




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





    }

    public void portero (View v){
        Intent intent = new Intent(this, BuscadorActivity.class);
        startActivity(intent);
       // Toast.makeText(getApplicationContext(), "Portero", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
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
