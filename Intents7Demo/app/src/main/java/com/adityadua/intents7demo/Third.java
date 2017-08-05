package com.adityadua.intents7demo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 05/08/17.
 */

public class Third extends Activity {
    Button camera,gallery;
    ImageView image;
    private final int CAMERA_REQUEST=100;
    private final int GALLERY_IMAGE=105;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.third_activity);

        Intent i = getIntent();
        TextView tv = (TextView)findViewById(R.id.textView3);
        String userName = i.getStringExtra("userName");
        tv.setText("Good Morning "+userName+"!,");
        camera = (Button)findViewById(R.id.button3);
        image = (ImageView)findViewById(R.id.imageView);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, CAMERA_REQUEST);
                }
            }
        });
        gallery = (Button)findViewById(R.id.button4);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, GALLERY_IMAGE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQUEST ){
            if(resultCode == RESULT_OK){

                Bundle extraBundle = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extraBundle.get("data");
                image.setImageBitmap(imageBitmap);
            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "The operation was cancelled", Toast.LENGTH_SHORT).show();
            }

        }else if(requestCode == GALLERY_IMAGE){
            if(resultCode == RESULT_OK){
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                image.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Couldnot get image from Gallery", Toast.LENGTH_SHORT).show();

            }

        }
    }
}
