package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Friend {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 0;
    private boolean boosting;
    private final int GRAVITY = -4;
    private int maxY;
    private int minY;
    private int maxX;

    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 12;

    private Rect detectCollision;

    public Friend(Context context, int screenX, int screenY) {

        y =(int) (Math.random()*(screenY+1) +50);
        speed = -7;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.friend);
        maxY = screenY - bitmap.getHeight();
        maxX = screenX - bitmap.getWidth();
        x=maxX;
        minY = 0;

        boosting = false;


        detectCollision =  new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
    }
//
//    public void setBoosting() {
//        boosting = true;
//    }

//    public void stopBoosting() {
//        boosting = false;
//    }

    public void update() {


        x -= 5;

        if (y < minY) {
            y = minY;
            speed *= -1;
        }
        if (y > maxY) {
            y = maxY;
            speed *=-1;
        }


        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom = y + bitmap.getHeight();

    }


    public Rect getDetectCollision() {
        return detectCollision;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }
}

