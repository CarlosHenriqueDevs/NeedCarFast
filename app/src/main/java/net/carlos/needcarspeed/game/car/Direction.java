package net.carlos.needcarspeed.game.car;

public class Direction
{
   public static final int LEFT = 0;
   public static final int RIGHT = 1;
   public static final int TOP = 2;
   public static final int BOTTOM = 3;

   public static int direcaoInversa(int direction)
   {
      switch (direction)
      {
	 case LEFT:
	    return RIGHT;
	 case RIGHT:
	    return LEFT;
	 case TOP:
	    return BOTTOM;
	 case BOTTOM:
	    return TOP;
      }

      return 0;
   }
}
