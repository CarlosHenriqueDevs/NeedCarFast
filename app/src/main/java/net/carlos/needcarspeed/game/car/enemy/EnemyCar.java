package net.carlos.needcarspeed.game.car.enemy;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import net.carlos.needcarspeed.R;
import net.carlos.needcarspeed.game.GameView;
import net.carlos.needcarspeed.game.car.Carro;
import static net.carlos.needcarspeed.game.car.Direction.*;
import android.graphics.Rect;
import net.carlos.needcarspeed.game.util.Vector2;

public class EnemyCar extends Enemy
{
   public EnemyCar()
   {
      speed = 3;
      hitBox = new Rect();
      coords = new Vector2(200, 200);
      texture = BitmapFactory.decodeResource(GameView.GAME_CONTEXT.getResources(), R.drawable.car2_left);
      direction = LEFT;
   }
   
   @Override
   public void draw(Canvas c)
   {
      c.drawBitmap(texture, coords.x, coords.y, null);
   }

   @Override
   public boolean isColisao(Carro car)
   {
      return hitBox.intersect(car.hitBox);
   }

   @Override
   public void update()
   {
      super.update();
      
      Resources res = GameView.GAME_CONTEXT.getResources();
      
      switch (direction)
      {
	 case LEFT:
	    texture = BitmapFactory.decodeResource(res, R.drawable.car2_left);
	    break;
	 case RIGHT:
	    texture = BitmapFactory.decodeResource(res, R.drawable.car2_right);
	    break;
	 case TOP:
	    texture = BitmapFactory.decodeResource(res, R.drawable.car2_top);
	    break;
	 case BOTTOM:
	    texture = BitmapFactory.decodeResource(res, R.drawable.car2_bottom);
	    break;
      }
   }
   
}
