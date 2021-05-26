package com.example.myapplication;

import androidx.annotation.NonNull;

import androidx.constraintlayout.widget.ConstraintLayout;


import android.annotation.SuppressLint;
import android.content.Context;

import android.util.Log;

import android.view.MotionEvent;

import android.view.View;
import android.widget.ImageView;

import static com.example.myapplication.MainActivity.check1;


@SuppressLint({"AppCompatCustomView", "ViewConstructor"})
public class MyCustomImage extends ImageView {
    private float mScaleFactor = 1.0f;
    ImageView image;
    float z = 90;
    ImageView deleteImage;
    ImageView turnImage;
    ImageView plus, minus;

    @SuppressLint("ClickableViewAccessibility")
    public MyCustomImage(@NonNull Context context, int imageId, ConstraintLayout layout) {
        super(context);
        final float[] dX = new float[1];
        final float[] dY = new float[1];
        deleteImage = new ImageView(context);
        deleteImage.setImageResource(R.drawable.x);
        plus = new ImageView(context);
        plus.setImageResource(R.drawable.plus);
        minus = new ImageView(context);
        minus.setImageResource(R.drawable.minus);
        turnImage = new ImageView(context);
        turnImage.setImageResource(R.drawable.rotate);
        image = new ImageView(context);
        image.setImageResource(imageId);
        deleteImage.setOnClickListener(v -> {
            if (!check1) {
                layout.removeView(image);
                layout.removeView(plus);
                layout.removeView(minus);
                layout.removeView(deleteImage);
                layout.removeView(turnImage);
            }

        });
        turnImage.setOnClickListener(view -> {
            if (!check1) {

                image.setRotation(z);
                z += 90;
                if (z > 270)
                    z = 0;
            }
        });
        plus.setOnClickListener(v -> {
            if (!check1) {

                mScaleFactor += 0.05f;
                System.out.println(mScaleFactor);
                if (mScaleFactor >= 2f)
                    mScaleFactor = 1.95f;
                image.setScaleX(mScaleFactor);
                image.setScaleY(mScaleFactor);
            }
        });
        minus.setOnClickListener(v -> {
            if (!check1) {

                System.out.println(mScaleFactor);
                mScaleFactor -= 0.05;
                if (mScaleFactor <= 0.3f)
                    mScaleFactor = 0.3f;
                image.setScaleX(mScaleFactor);
                image.setScaleY(mScaleFactor);
            }
        });

        image.setOnTouchListener((v, event) -> {
            if (!check1) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX[0] = v.getX() - event.getRawX();
                        dY[0] = v.getY() - event.getRawY();

                    case MotionEvent.ACTION_MOVE:
                        v.animate()
                                .x(event.getRawX() + dX[0])
                                .y(event.getRawY() + dY[0])
                                .setDuration(0)
                                .start();
                        deleteImage.animate()
                                .x(event.getRawX() + dX[0])
                                .y(event.getRawY() + dY[0])
                                .setDuration(0)
                                .start();
                        turnImage.animate()
                                .x(event.getRawX() + dX[0])
                                .y(event.getRawY() + dY[0])
                                .setDuration(0)
                                .start();
                        plus.animate()
                                .x(event.getRawX() + dX[0])
                                .y(event.getRawY() + dY[0])
                                .setDuration(0)
                                .start();
                        minus.animate()
                                .x(event.getRawX() + dX[0])
                                .y(event.getRawY() + dY[0])
                                .setDuration(0)
                                .start();
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    default:
                        return false;
                }

                deleteImage.setX(image.getX() + image.getWidth() / 2 - 95f * mScaleFactor);
                deleteImage.setY(image.getY() + image.getHeight() / 2 - 95f * mScaleFactor);
                turnImage.setX(image.getX() + image.getWidth() / 2 + 62f * mScaleFactor);
                turnImage.setY(image.getY() + image.getHeight() / 2 - 95f * mScaleFactor);
                plus.setX(image.getX() + image.getWidth() / 2 + 59f * mScaleFactor);
                plus.setY(image.getY() + image.getHeight() / 2 + 59f * mScaleFactor);
                minus.setX(image.getX() + image.getWidth() / 2 - 95f * mScaleFactor);
                minus.setY(image.getY() + image.getHeight() / 2 + 65f * mScaleFactor);
            }
            return true;
        });
        layout.addView(image);
        layout.addView(deleteImage);
        layout.addView(turnImage);
        layout.addView(plus);
        layout.addView(minus);
    }
}