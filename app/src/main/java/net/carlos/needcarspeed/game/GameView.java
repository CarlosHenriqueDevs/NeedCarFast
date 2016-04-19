package net.carlos.needcarspeed.game;

import android.content.Context;
import android.view.SurfaceView;
import android.graphics.Canvas;
import android.graphics.Color;
import net.carlos.needcarspeed.game.car.Player;
import android.graphics.Paint;
import net.carlos.needcarspeed.game.car.enemy.EnemyCar;

public class GameView extends SurfaceView implements Runnable
{
   private Thread gameThread;
   private boolean running = true;
   private Canvas canvas;
   private Player player;
   public static EnemyCar enemy;

   public static Context GAME_CONTEXT;
   public static int DISPLAY_WIDTH;
   public static int DISPLAY_HEIGHT;

   public GameView(Context ctx, int screenX, int screenY)
   {
      super(ctx);

      GameView.GAME_CONTEXT = ctx;
      GameView.DISPLAY_WIDTH = screenX;
      GameView.DISPLAY_HEIGHT = screenY;

      this.player = new Player();
      this.enemy = new EnemyCar();
      this.gameThread = new Thread(this);
      this.gameThread.start();
   }

   public void draw()
   {
      if (getHolder().getSurface().isValid())
      {
	 canvas = getHolder().lockCanvas();

	 canvas.drawColor(Color.WHITE);
	 player.draw(canvas);
	 enemy.draw(canvas);

	 getHolder().unlockCanvasAndPost(canvas);
      }
   }

   public void update()
   {
      player.update();
      enemy.update();
   }

   public void control()
   {
      try
      {
	 gameThread.sleep(20);
      }
      catch (InterruptedException e)
      {}
   }

   public void destroy()
   {
      try
      {
	 running = false;
	 gameThread.join();
      }
      catch (InterruptedException e)
      {}
   }

   @Override
   public void run()
   {
      while (running)
      {
	 draw();
	 update();
	 control();
      }
   }

   public Player getPlayer()
   {
      return player;
   }

   private void debugMode()
   {
      Paint p = new Paint();
      p.setColor(Color.BLUE);

      canvas.drawRect(player.hitBox, p);
   }
}
