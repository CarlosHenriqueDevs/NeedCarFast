package net.carlos.needcarspeed.game.car.enemy;

import net.carlos.needcarspeed.game.GameView;
import net.carlos.needcarspeed.game.car.Carro;
import net.carlos.needcarspeed.game.car.Direction;

public abstract class Enemy extends Carro
{
   private int maxX;
   private int minX = 0;
   private int maxY;
   private int minY = 0;

   private Carro target;

   public Enemy()
   {
      maxX = GameView.DISPLAY_WIDTH;
      maxY = GameView.DISPLAY_HEIGHT;
   }

   public void setTarget(Carro target)
   {
      this.target = target;
   }

   public Carro getTarget()
   {
      return target;
   }
   
   @Override
   public void update()
   {
      super.update();

      if (coords.x > maxX - texture.getWidth())
      {
	 coords.x = maxX - texture.getWidth();
	 direction = Direction.direcaoInversa(direction);
      }
      else
      if (coords.x < minX)
      {
	 coords.x = minX;
	 direction = Direction.direcaoInversa(direction);
      }

      if (coords.y > maxY)
      {
	 coords.y = maxY;
	 direction = Direction.direcaoInversa(direction);
      }
      else
      if (coords.y < minY)
      {
	 coords.y = minY;
	 direction = Direction.direcaoInversa(direction);
      }
   }

}
