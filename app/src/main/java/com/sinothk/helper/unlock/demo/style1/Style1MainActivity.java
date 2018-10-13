package com.sinothk.helper.unlock.demo.style1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sinothk.helper.unlock.demo.R;

public class Style1MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lock9_activity_main_style1);
    }

    public void onBtnNormalClick(View view) {
        startActivity(new Intent(this, NormalActivity.class));
    }

    public void onBtnLStyleClick(View view) {
        startActivity(new Intent(this, LStyleActivity.class));
    }
}
