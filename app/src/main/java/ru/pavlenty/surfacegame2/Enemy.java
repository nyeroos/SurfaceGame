package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Enemy {
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

    public Enemy(Context context, int screenX, int screenY) {
        y =(int) (Math.random()*(screenY+1) +50);
        speed = -7;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        maxY = screenY - bitmap.getHeight();
        maxX = screenX - bitmap.getWidth();
        x = maxX;

        minY = 0;
        boosting = false;


        detectCollision =  new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
    }


    public void update() {

        x -= 8;


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
    public void setY(int my_y){
        y=my_y;
    }

    public int getSpeed() {
        return speed;
    }
}
