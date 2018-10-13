package com.sinothk.helper.unlock.demo.style1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sinothk.helper.unlock.demo.R;
import com.sinothk.helper.unlock.style1.Unlock9View;

public class NormalActivity extends AppCompatActivity {

    Unlock9View lock9View;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lock9_activity_normal);


        lock9View = this.findViewById(R.id.lock_9_view);

        lock9View.setGestureCallback(new Unlock9View.GestureCallback() {

            @Override
            public void onNodeConnected(@NonNull int[] numbers) {
                ToastUtils.with(NormalActivity.this).show("+ " + numbers[numbers.length - 1]);
            }

            @Override
            public void onGestureFinished(@NonNull int[] numbers) {
                StringBuilder builder = new StringBuilder();
                for (int number : numbers) {
                    builder.append(number);
                }
                ToastUtils.with(NormalActivity.this).show("= " + builder.toString());
            }

        });
    }

}
