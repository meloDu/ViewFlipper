package com.rmtd.melo.viewflipper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    ViewFlipper mViewFlipper;
    GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        TextView textView1 = new TextView(this);
        textView1.setText("今日顺丰成功上市");
        TextView textView2 = new TextView(this);
        textView2.setText("范冰冰与李晨大婚在即");
        TextView textView3 = new TextView(this);
        textView3.setText("跑男换新人迪丽热巴");

        mViewFlipper.addView(textView1);
        mViewFlipper.addView(textView2);
        mViewFlipper.addView(textView3);
        mViewFlipper.setOnTouchListener(this);


        mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (e1.getX() - e2.getX() > 100 && Math.abs(velocityX) > 200) {
                    // Fling 左滑
                    mViewFlipper.showNext();
//                    AnimationSet outAnim = (AnimationSet) AnimationUtils.loadAnimation(
//                            MainActivity.this, R.anim.anim_left_out);
//                    mViewFlipper.startAnimation(outAnim);

                    Toast.makeText(MainActivity.this, "Fling Left", Toast.LENGTH_SHORT).show();
                } else if (e2.getX() - e1.getX() > 100
                        && Math.abs(velocityX) > 200) {
                    // Fling right
                    //先向左滑，
//                    AnimationSet outAnim = (AnimationSet) AnimationUtils.loadAnimation(
//                            MainActivity.this, R.anim.anim_in);
//                    mViewFlipper.startAnimation(outAnim);


                    mViewFlipper.showPrevious();



                    Toast.makeText(MainActivity.this, "Fling Right", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });


    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }


}
