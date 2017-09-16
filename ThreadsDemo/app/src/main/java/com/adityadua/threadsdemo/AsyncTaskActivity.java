package com.adityadua.threadsdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by AdityaDua on 16/09/17.
 */

public class AsyncTaskActivity extends Activity {

    private ImageView imageView,imageView3,imageView4,imageView5;
    private ProgressBar progressBar;
    Button loadBtn,checkBtn;
    Bitmap tmp,tmp2,tmp3,tmp4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        imageView = (ImageView)findViewById(R.id.imageView2);
        imageView3 = (ImageView)findViewById(R.id.imageView3);
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        imageView5 = (ImageView)findViewById(R.id.imageView5);

        loadBtn = (Button)findViewById(R.id.button4);
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadIconTask().execute(R.drawable.acadgild_logo,
                        R.drawable.image_android,R.drawable.image_ed,R.drawable.image_news);
            }
        });
        checkBtn = (Button)findViewById(R.id.button5);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AsyncTaskActivity.this, "I am working as Usual", Toast.LENGTH_SHORT).show();
            }
        });

    }

    class LoadIconTask extends AsyncTask<Integer,Integer,Bitmap>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(Integer... params) {
            try {
                tmp = BitmapFactory.decodeResource(getResources(),params[0]);
                Thread.sleep(2000);
                publishProgress(20);

                tmp2 = BitmapFactory.decodeResource(getResources(),params[1]);
                Thread.sleep(2000);
                publishProgress(40);

                tmp3 = BitmapFactory.decodeResource(getResources(),params[2]);
                Thread.sleep(2000);
                publishProgress(60);

                tmp4 = BitmapFactory.decodeResource(getResources(),params[3]);
                Thread.sleep(2000);
                publishProgress(80);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            /*for(int i=1;i<=10;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i*10);
            }
*/
            return tmp;
        }
        // Asyn Task will have ::
            // onPreExecute  : UIThread
            //doInBackground : separate Thread
            // onPostExecute : UI Thread


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if(values[0]==20){
                imageView.setImageBitmap(tmp);
            }
            else if(values[0]==40){
                imageView3.setImageBitmap(tmp2);
            }
            else if(values[0]==60){
                imageView4.setImageBitmap(tmp3);

            }
            else if(values[0]==80){
                imageView5.setImageBitmap(tmp4);
            }




            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            progressBar.setVisibility(ProgressBar.INVISIBLE);

        }
    }
}
