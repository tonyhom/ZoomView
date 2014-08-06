package com.example.testzoomview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout.Alignment;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		lp.gravity = Gravity.LEFT | Gravity.TOP;
		
		RelativeLayout tmpRl = new RelativeLayout(this);
        
        TextView tv = new TextView(this);
        tv.setText("Test TextView");
        tv.setGravity(10);;
        tv.setBackgroundColor(Color.BLUE);
        tv.setTextColor(ColorStateList.valueOf(Color.WHITE));
        
		Button bt = new Button(this);
		bt.setText("Test Button");
		
//		ArrayList<View> viewList = new ArrayList<View>();
//		viewList.add(bt);
//		viewList.add(tv);
		tmpRl.addView(tv, new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT));
		tmpRl.addView(bt, new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT));

		ZoomView zv = new ZoomView(this);
		zv.setBackgroundColor(Color.LTGRAY);
		
		zv.addView(tmpRl,lp);
		
//		((ViewGroup) zv).addView(tv, lp);
		
//		((ViewGroup) zv).addView(bt, lp);
//		zv.addChildrenForAccessibility(viewList);

		RelativeLayout rl = (RelativeLayout) findViewById(R.id.ParentLayout);
		rl.addView(zv, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
