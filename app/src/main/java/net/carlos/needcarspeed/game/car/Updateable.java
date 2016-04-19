package net.carlos.needcarspeed.game.car;

import android.graphics.Canvas;

public interface Updateable
{
   public void draw(Canvas c);
   public void update();
   public boolean isColisao(Carro car);
}
