package com.jivosite.supportapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends Activity{

    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView logo = (ImageView) findViewById(R.id.logo);

        if (Locale.getDefault().getLanguage().indexOf("ru") >= 0){
            logo.setImageResource(R.drawable.jivosite_logo);
        }else {
            logo.setImageResource(R.drawable.jivochat_logo);
        }

        final TextView begin_chat = (TextView) findViewById(R.id.begin_chat);
        begin_chat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent myIntent = new Intent(activity, JivoActivity.class);
                startActivity(myIntent);
            }
        });

        final TextView with_sdk = (TextView) findViewById(R.id.with_sdk);
        with_sdk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jivosite.ru/sdk"));
                startActivity(browserIntent);
            }
        });

    }

}
