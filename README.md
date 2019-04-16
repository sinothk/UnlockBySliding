# UnlockSliding


# 引入
      maven { url 'https://jitpack.io' }
	    implementation 'com.github.sinothk:UnlockBySliding:2.0.0416'
      
# 使用

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#303030"
        android:orientation="vertical">

        <ImageView
            android:id="@+id/profile_image"
            android:layout_width="84dp"
            android:layout_height="84dp"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="10dp"
            android:src="@mipmap/ic_launcher"/>

        <TextView
            android:id="@+id/profile_name"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="36dp"
            android:fontFamily="sans-serif-thin"
            android:gravity="center"
            android:maxLines="1"
            android:text="Welcome"
            android:textColor="@color/white"
            android:textSize="34sp"/>

        <com.sinothk.helper.unlock.style2.PatternLockView
            android:id="@+id/patter_lock_view"
            android:layout_width="280dp"
            android:layout_height="280dp"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="16dp"
            app:aspectRatio="square"
            app:aspectRatioEnabled="true"
            app:dotAnimationDuration="150"
            app:dotCount="3"/>

    </LinearLayout>



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
            }

            @Override
            public void onCleared() {
                Log.d(getClass().getName(), "Pattern has been cleared");
            }
        });
