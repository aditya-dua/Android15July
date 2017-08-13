package com.adityadua.animacti7demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 06/08/17.
 */

public class ThirdActivity extends Activity implements Animation.AnimationListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirs);
        TextView tv = (TextView)findViewById(R.id.textView3);
        tv.setVisibility(TextView.VISIBLE);
        Animation fadeInExample= AnimationUtils.loadAnimation(this,R.anim.fadein);
        tv.setAnimation(fadeInExample);
    }

    /*@Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }*/

    @Override
    public void onAnimationStart(Animation animation) {
       Toast.makeText(this, "Animation Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(this, "Animiation Ended", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
