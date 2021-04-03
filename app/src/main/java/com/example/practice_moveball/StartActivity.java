package com.example.practice_moveball;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button button1 = (Button) findViewById(R.id.btn01);
        Button button2 = (Button) findViewById(R.id.btn02);
        Button button3 = (Button) findViewById(R.id.btn03);
        Button button4 = (Button) findViewById(R.id.btn04);

        /*
        Intent intent2 = getIntent();
        int game = intent2.getExtras().getInt("save");

        if(game == 1){button1.setBackgroundColor(Color.BLUE);}
        if(game == 2){button2.setBackgroundColor(Color.BLUE);}
        if(game == 3){button3.setBackgroundColor(Color.BLUE);}
        if(game == 4){button4.setBackgroundColor(Color.BLUE);}
        */

        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("type",1);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("type",2);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("type",3);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("type",4);
                startActivity(intent);
            }
        });
    }
}
