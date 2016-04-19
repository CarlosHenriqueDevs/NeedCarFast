package net.carlos.needcarspeed;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import net.carlos.needcarspeed.game.GameView;
import net.carlos.needcarspeed.game.car.Direction;
import net.carlos.needcarspeed.game.car.Player;
import android.view.WindowManager;

public class MainActivity extends Activity implements OnTouchListener
{
   private GameView game;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      
      getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
      getActionBar().hide();

      Display display = getWindowManager().getDefaultDisplay();
      Point p = new Point();
      display.getSize(p);

      game = new GameView(this, p.x, p.y);

      LinearLayout ll = (LinearLayout) findViewById(R.id.gameLinearLayout);
      ll.addView(game);
      
      ImageButton left = (ImageButton) findViewById(R.id.move_left);
      ImageButton right = (ImageButton) findViewById(R.id.move_right);
      ImageButton top = (ImageButton) findViewById(R.id.move_top);
      ImageButton bottom = (ImageButton) findViewById(R.id.move_bottom);
      
      left.setOnTouchListener(this);
      right.setOnTouchListener(this);
      top.setOnTouchListener(this);
      bottom.setOnTouchListener(this);
   }

   @Override
   public boolean onTouch(View p1, MotionEvent p2)
   {
      Player p = game.getPlayer();

      switch (p1.getId())
      {
         case R.id.move_bottom:
	    p.direction = Direction.BOTTOM;
	    break;
	 case R.id.move_left:
	    p.direction = Direction.LEFT;
	    break;
	 case R.id.move_right:
	    p.direction = Direction.RIGHT;
	    break;
	 case R.id.move_top:
	    p.direction = Direction.TOP;
	    break;
      }

      return false;
   }

   @Override
   protected void onDestroy()
   {
      super.onDestroy();

      game.destroy();
   }

}
