package net.carlos.needcarspeed.game.car;

import android.graphics.Bitmap;
import android.graphics.Rect;
import net.carlos.needcarspeed.game.util.Vector2;

public abstract class Carro implements Updateable
{
   public Vector2 coords;
   public int speed = 2;
   public int direction = 0;
   public Bitmap texture;
   public Rect hitBox;

   public Carro()
   {
      
   }

   @Override
   public void update()
   {
      hitBox.left = coords.x;
      hitBox.right = coords.x + texture.getWidth();
      hitBox.top = coords.y;
      hitBox.bottom = coords.y + texture.getHeight();

      switch (direction)
      {
	 case Direction.LEFT:
	    coords.x -= speed;
	    break;
	 case Direction.RIGHT:
	    coords.x += speed;
	    break;
	 case Direction.TOP:
	    coords.y -= speed;
	    break;
	 case Direction.BOTTOM:
	    coords.y += speed;
	    break;
      }
   }

}
