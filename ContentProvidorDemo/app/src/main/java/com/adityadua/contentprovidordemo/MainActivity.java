package com.adityadua.contentprovidordemo;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    SMSContentObserver contentObserver;
    TextView tv_number,tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_number = (TextView)findViewById(R.id.textView2);
        tv_message = (TextView) findViewById(R.id.textView3);

        contentObserver = new SMSContentObserver(this,handler);

        Uri uri = Uri.parse("context://sms");

        getContentResolver().registerContentObserver(uri,true,contentObserver);


    }
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {

            switch(msg.what){
                case 1: String str = (String) msg.obj;
                    tv_message.setText(str);

                    String s=str.substring(str.indexOf("Message"),str.length());

                    String otp = extractDigits(s);
                    tv_number.setText(otp);


                    break;

                default: break;
            }
        }
    };

    public static String extractDigits(final String in) {

        final Pattern p = Pattern.compile( "(\\d{6})" );
        final Matcher m = p.matcher( in );
        if ( m.find() ) {
            return m.group( 0 );
        }
        return "";
    }

}
