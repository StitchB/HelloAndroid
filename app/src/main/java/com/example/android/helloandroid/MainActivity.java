package com.example.android.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import android.text.Spannable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide action bar
        hideActionBar();

        setContentView(R.layout.activity_main);

        // Remove underlines from links
        TextView website;
        website = findViewById(R.id.website);
        if(website != null) {
            StringUtil.removeUnderlines((Spannable)website.getText());
        }
        TextView facebook;
        facebook = findViewById(R.id.facebook);
        if(facebook != null) {
            StringUtil.removeUnderlines((Spannable)facebook.getText());
        }
        TextView twitter;
        twitter = findViewById(R.id.twitter);
        if(twitter != null) {
            StringUtil.removeUnderlines((Spannable)twitter.getText());
        }

        //Main card view
        CardView cardView = findViewById(R.id.card_view);

        //Card animation
        ObjectAnimator card_y = ObjectAnimator.ofFloat(cardView, View.TRANSLATION_Y, 70);
        card_y.setDuration(2500);
        card_y.setRepeatMode(ValueAnimator.REVERSE);
        card_y.setRepeatCount(ValueAnimator.INFINITE);
        card_y.setInterpolator(new LinearInterpolator());

        //Start animation
        AnimatorSet animationSet = new AnimatorSet();
        animationSet.play(card_y);
        animationSet.start();
    }

    //Hide action bar
    private void hideActionBar()
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}