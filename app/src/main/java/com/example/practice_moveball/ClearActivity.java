package com.example.practice_moveball;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClearActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear);

        Button button1 = (Button) findViewById(R.id.btn);

        Intent fin = getIntent();
        int game = fin.getExtras().getInt("clear");

        if(game == 1){button1.setBackgroundColor(Color.BLUE);}
        if(game == 2){button1.setBackgroundColor(Color.GREEN);}
        if(game == 3){button1.setBackgroundColor(Color.YELLOW);}
        if(game == 4){button1.setBackgroundColor(Color.RED);}

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fin = getIntent();
                int game = fin.getExtras().getInt("clear");

                Intent intent2 = new Intent(getApplicationContext(), StartActivity.class);
                if(game == 1){intent2.putExtra("save",1);}
                if(game == 2){intent2.putExtra("save",2);}
                if(game == 3){intent2.putExtra("save",3);}
                if(game == 4){intent2.putExtra("save",4);}
                startActivity(intent2);
                finish();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
