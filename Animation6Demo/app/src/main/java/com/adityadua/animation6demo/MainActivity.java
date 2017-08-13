package com.adityadua.animation6demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Button startAnim;
    TextView  text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.tv1);

        startAnim = (Button)findViewById(R.id.start_anim);
        startAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setVisibility(TextView.VISIBLE);
                Animation fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
                text.startAnimation(fadeInAnimation);
                fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Toast.makeText(getApplicationContext(), "Animation Started", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(getApplicationContext(), "Animation Ended", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

    }


}
