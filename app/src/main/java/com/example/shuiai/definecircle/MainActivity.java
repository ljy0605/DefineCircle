package com.example.shuiai.definecircle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CircleView.AddUpdateListener, View.OnClickListener {
    private TextView textView;
    private float progress = 300;
    private Button updateButton;
    private CircleView cycleProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cycleProgressView = (CircleView) findViewById(R.id.progressBar);
        cycleProgressView.setProgressMax(500)
                         .setProgress(progress)
                         .update();
//        cycleProgressView.setColorArray(gradientColorArray);
        cycleProgressView.setAddUpdateListener(this);
        textView = (TextView) findViewById(R.id.text);
        updateButton = (Button) findViewById(R.id.updateButton);
        updateButton.setOnClickListener(this);
    }

    @Override
    public void onAddUpdateListener(float percentage) {
        textView.setText("" + progress * percentage);
    }

    @Override
    public void onClick(View view) {
        cycleProgressView.setProgress(400).update();
    }
}
