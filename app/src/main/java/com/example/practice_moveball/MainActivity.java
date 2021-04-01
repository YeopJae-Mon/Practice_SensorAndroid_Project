package com.example.practice_moveball;

import android.app.Activity;
import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    //가로 1080px 세로 2094px
    SensorManager sensorManager;
    int accelerometerSensor;
    float xAxis, yAxis, zAxis;

    TextView textView;

    MyView view;

    int screenWidth, screenHeight;
    int cx, cy, r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        cx = screenWidth / 2;
        cy = screenHeight;

        r = (int) (screenHeight * 0.02);

        view = new MyView(this);
        setContentView(view);

        view.setBackgroundColor(Color.WHITE);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometerSensor = Sensor.TYPE_ACCELEROMETER;
        sensorManager.registerListener(sensorEventListener,
                sensorManager.getDefaultSensor(accelerometerSensor),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected class MyView extends View {
        public MyView(Context context) { super(context); }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();

            Intent intent = getIntent();
            int game = intent.getExtras().getInt("type");

            paint.setColor(Color.BLACK);
            canvas.drawCircle(cx, cy, r, paint);

            paint.setColor(Color.RED);
            if(game == 2){canvas.drawRect(150, 200, 250, 300, paint);}
            if(game == 3){canvas.drawRect(150, 200, 250, 300, paint);}
            if(game == 4){canvas.drawRect(150, 200, 250, 300, paint);}

        }

    }

    @Override
    public void onPause() {
        sensorManager.unregisterListener(sensorEventListener);
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(sensorEventListener,
                sensorManager.getDefaultSensor(accelerometerSensor),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    final SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                xAxis = event.values[0];
                yAxis = event.values[1];
                zAxis = event.values[2];

                cx = cx - ((int) xAxis * 4);
                cy = cy + ((int) yAxis * 4);

                if (cx <= 4)
                { cx = 4; view.invalidate(); }
                else if (cx >= screenWidth - 4)
                { cx = screenWidth - 4; view.invalidate(); }
                else if (cy >= screenHeight - 4)
                { cy = screenHeight - 4; view.invalidate(); }
                //여기서 부터 난이도별 결과확인
                else if (cy <= 4)
                {
                    Intent intent = new Intent(getApplicationContext(), ClearActivity.class);
                    startActivity(intent);
                    finish();
                }
                else { view.invalidate(); }
            }
        }
        @Override
        public void onAccuracyChanged (Sensor sensor,int accuracy) {

        }
    };
}