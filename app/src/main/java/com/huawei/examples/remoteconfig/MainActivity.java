package com.huawei.examples.remoteconfig;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String themeName = intent.getStringExtra(SplashActivity.EXTRA_MESSAGE);
        if (themeName.equals("Red")) {
            setTheme(R.style.AppTheme1);
        }
        if (themeName.equals("Green")) {
           setTheme(R.style.AppTheme2);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.text);
        textView.setText(getString(R.string.currenttheme) +" "+ themeName);
    }
}









