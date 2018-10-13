package com.sinothk.helper.unlock.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sinothk.helper.unlock.demo.style1.Style1MainActivity;

public class UnlockDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unlock_demo_activity_main);
    }

    public void onStyle1(View view) {
        startActivity(new Intent(this, Style1MainActivity.class));
    }
}
