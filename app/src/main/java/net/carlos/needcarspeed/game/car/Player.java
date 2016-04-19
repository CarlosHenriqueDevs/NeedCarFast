package net.carlos.needcarspeed.game.car;

import android.graphics.Canvas;
import net.carlos.needcarspeed.game.util.Vector2;
import android.graphics.BitmapFactory;
import net.carlos.needcarspeed.game.GameView;
import net.carlos.needcarspeed.R;
import static net.carlos.needcarspeed.game.car.Direction.*;
import android.graphics.Bitmap;
import android.content.res.Resources;
import android.graphics.Rect;

public class Player extends Carro
{
   public Player()
   {
      super();
      
      hitBox = new Rect();
      coords = new Vector2(300, 300);
      speed = 7;
      direction = LEFT;
      texture = BitmapFactory.decodeResource(GameView.GAME_CONTEXT.getResources(), R.drawable.car_left);
   }
   
   @Override
   public void draw(Canvas c)
   {
      c.drawBitmap(texture, coords.x, coords.y, null);
   }

   @Override
   public void update()
   {
      super.update();
      
      if (isColisao(GameView.enemy))
      {
	 switch (direction)
	 {
	    case LEFT:
	       coords.x += 3;
	       speed /= 2;
	       GameView.enemy.coords.x -= speed * 2;
	       break;
	    case RIGHT:
	       coords.x -= 3;
	       speed /= 2;
	       GameView.enemy.coords.x += speed * 2;
	       break;
	    case TOP:
	       coords.y += 3;
	       speed /= 2;
	       GameView.enemy.coords.y -= speed * 2;
	       break;
	    case BOTTOM:
	       coords.y -= 3;
	       speed /= 2;
	       GameView.enemy.coords.y += speed * 2;
	       break;
	 }
	 
      }
      else
         speed = 7;
      
      Resources res = GameView.GAME_CONTEXT.getResources();
      
      switch (direction)
      {
	 case LEFT:
	    texture = BitmapFactory.decodeResource(res, R.drawable.car_left);
	    break;
	 case RIGHT:
	    texture = BitmapFactory.decodeResource(res, R.drawable.car_right);
	    break;
	 case TOP:
	    texture = BitmapFactory.decodeResource(res, R.drawable.car_top);
	    break;
	 case BOTTOM:
	    texture = BitmapFactory.decodeResource(res, R.drawable.car_bottom);
	    break;
      }
   }

   @Override
   public boolean isColisao(Carro car)
   {
      return hitBox.intersect(car.hitBox);
   }
   
}
