package com.sinothk.helper.unlock.demo.style2;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.sinothk.helper.unlock.demo.R;
import com.sinothk.helper.unlock.style2.PatternLockView;
import com.sinothk.helper.unlock.style2.listener.PatternLockViewListener;
import com.sinothk.helper.unlock.style2.utils.PatternLockUtils;
import com.sinothk.helper.unlock.style2.utils.ResourceUtils;

import java.util.List;


public class Style2MainActivity extends AppCompatActivity {

    private PatternLockView mPatternLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.style2_activity_main);

        mPatternLockView = (PatternLockView) findViewById(R.id.patter_lock_view);
        mPatternLockView.setDotCount(3);
        mPatternLockView.setDotNormalSize((int) ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_dot_size));
        mPatternLockView.setDotSelectedSize((int) ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_dot_selected_size));
        mPatternLockView.setPathWidth((int) ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_path_width));
        mPatternLockView.setAspectRatioEnabled(true);
        mPatternLockView.setAspectRatio(PatternLockView.AspectRatio.ASPECT_RATIO_HEIGHT_BIAS);
        mPatternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
        mPatternLockView.setDotAnimationDuration(150);
        mPatternLockView.setPathEndAnimationDuration(100);
        mPatternLockView.setCorrectStateColor(ResourceUtils.getColor(this, R.color.white));
        mPatternLockView.setInStealthMode(false);
        mPatternLockView.setTactileFeedbackEnabled(true);
        mPatternLockView.setInputEnabled(true);
        mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {
                Log.d(getClass().getName(), "Pattern drawing started");
            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {
                Log.d(getClass().getName(), "Pattern progress: " +
                        PatternLockUtils.patternToString(mPatternLockView, progressPattern));
            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {
                Log.d(getClass().getName(), "Pattern complete: " + PatternLockUtils.patternToString(mPatternLockView, pattern));

                Toast.makeText(Style2MainActivity.this, "result => " + PatternLockUtils.patternToString(mPatternLockView, pattern), Toast.LENGTH_SHORT).show();
                mPatternLockView.clearPattern();

//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                mPatternLockView.clearPattern();
//                            }
//                        });
//                    }
//                }, 2000);
            }

            @Override
            public void onCleared() {
                Log.d(getClass().getName(), "Pattern has been cleared");
            }
        });

//        RxPatternLockView.patternComplete(mPatternLockView)
//                .subscribe(new Consumer<PatternLockCompleteEvent>() {
//                    @Override
//                    public void accept(PatternLockCompleteEvent patternLockCompleteEvent) throws Exception {
//                        Log.d(getClass().getName(), "Complete: " + patternLockCompleteEvent.getPattern().toString());
//                    }
//                });
//
//        RxPatternLockView.patternChanges(mPatternLockView)
//                .subscribe(new Consumer<PatternLockCompoundEvent>() {
//                    @Override
//                    public void accept(PatternLockCompoundEvent event) throws Exception {
//                        if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_STARTED) {
//                            Log.d(getClass().getName(), "Pattern drawing started");
//                        } else if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_PROGRESS) {
//                            Log.d(getClass().getName(), "Pattern progress: " +
//                                    PatternLockUtils.patternToString(mPatternLockView, event.getPattern()));
//                        } else if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_COMPLETE) {
//                            Log.d(getClass().getName(), "Pattern complete: " +
//                                    PatternLockUtils.patternToString(mPatternLockView, event.getPattern()));
//                        } else if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_CLEARED) {
//                            Log.d(getClass().getName(), "Pattern has been cleared");
//                        }
//                    }
//                });
    }
}
