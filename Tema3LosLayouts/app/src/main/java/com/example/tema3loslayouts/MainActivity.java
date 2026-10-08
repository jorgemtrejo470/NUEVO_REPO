package com.example.tema3loslayouts;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.relativelayout);
        //setContentView(R.layout.framelayout);
        setContentView(R.layout.tablelayout);
        //setContentView(R.layout.gridlayout);
        //setContentView(R.layout.gridlayout_calcu);
    }

}