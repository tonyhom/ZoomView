package com.example.testzoomview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout.Alignment;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

	ZoomView zoomView;
	RelativeLayout rl;
	LinkView lv1;
	LinkView lv2;
	
	ViewGroup vg;
	
	float preX,preY;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		lp.gravity = Gravity.LEFT | Gravity.TOP;
		
		final RelativeLayout tmpRl = new RelativeLayout(this);
		
        TextView tv1 = new TextView(this);
        tv1.setText("A: facegreen");
//        tv1.setGravity(10);
        tv1.setBackgroundColor(Color.RED);
        tv1.setTextColor(ColorStateList.valueOf(Color.WHITE));
        
        TextView tv2 = new TextView(this);
        tv2.setText("P: .........");
//        tv2.setGravity(10);
        tv2.setBackgroundColor(Color.BLUE);
        tv2.setTextColor(ColorStateList.valueOf(Color.WHITE));
        
        TextView tv3 = new TextView(this);
        tv3.setText("O: .........");
//        tv2.setGravity(10);
        tv3.setBackgroundColor(Color.GREEN);
        tv3.setTextColor(ColorStateList.valueOf(Color.WHITE));
        
//		Button bt = new Button(this);
//		bt.setText("Test Button");
		
//		ArrayList<View> viewList = new ArrayList<View>();
//		viewList.add(bt);
//		viewList.add(tv);
		
		RelativeLayout.LayoutParams lp_tv1 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp_tv1.setMargins(10, 300, 0, 0);
		
		RelativeLayout.LayoutParams lp_tv2 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp_tv2.setMargins(300, 100, 0, 0);
		
		RelativeLayout.LayoutParams lp_tv3 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp_tv3.setMargins(300, 500, 0, 0);
		
		lv1 = new LinkView(this, tv1, tv2);
		lv1.setBackgroundColor(Color.TRANSPARENT);
		
		lv2 = new LinkView(this, tv1, tv3);
		lv2.setBackgroundColor(Color.TRANSPARENT);
		
		OnClickListener onTextViewClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.setX(v.getX()+100);
//				zoomView.postInvalidate();
				for(int i = 0;i<tmpRl.getChildCount();i++){
					tmpRl.getChildAt(i).invalidate();
				}
//				lv1.postInvalidate();
//				lv2.postInvalidate();
//				tmpRl.invalidate();
//				vg.invalidate();
				
			}
		};
		
//        tv1.setOnClickListener(onTextViewClickListener);
//        tv2.setOnClickListener(onTextViewClickListener);
//        tv3.setOnClickListener(onTextViewClickListener);
//        
        tv1.setOnTouchListener(this.onTextViewOnTouchListener);
        tv2.setOnTouchListener(this.onTextViewOnTouchListener);
        tv3.setOnTouchListener(this.onTextViewOnTouchListener);
		
		tmpRl.addView(tv1, lp_tv1);
		tmpRl.addView(tv2, lp_tv2);
		tmpRl.addView(tv3, lp_tv3);
		tmpRl.addView(lv1);
		tmpRl.addView(lv2);
		
		vg = tmpRl;

		zoomView = new ZoomView(this);
		zoomView.setBackgroundColor(Color.LTGRAY);
		
		zoomView.addView(tmpRl,lp);
		
//		((ViewGroup) zv).addView(tv, lp);
		
//		((ViewGroup) zv).addView(bt, lp);
//		zv.addChildrenForAccessibility(viewList);

		rl = (RelativeLayout) findViewById(R.id.ParentLayout);
		rl.addView(zoomView, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		
		/* Canvas.drawLine	*/
//		Display display = getWindowManager().getDefaultDisplay();
//		Bitmap base_Bitmap = Bitmap.createBitmap(display.getWidth(), display.getHeight(),
//				Bitmap.Config.RGB_565);
//		Paint p = new Paint();
//		p.setColor(Color.YELLOW);
//		p.setStrokeWidth(5f);
//		Canvas canvas = new Canvas(base_Bitmap);
//		canvas.drawLine(170, 380, 320, 135, p);
//		canvas.drawLine(170, 380, 320, 605, p);
//		
//		Drawable drawable = new BitmapDrawable(base_Bitmap);
//		tmpRl.setBackground(drawable);
		
		
    }
    
    private OnClickListener onTextViewClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			v.setX(v.getX()+100);
			zoomView.invalidate();
			rl.invalidate();
		}
	};
	
	private OnTouchListener onTextViewOnTouchListener = new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			float mx = event.getX(); 
			float my = event.getY();
			
			if(event.getAction() == MotionEvent.ACTION_DOWN){
//				v.setX(v.getX()+mx);
//				v.setY(v.getY()+my);
				preX = event.getX();
				preY = event.getY();
				return true;
			}
			else if(event.getAction() == MotionEvent.ACTION_MOVE){
				v.setX(v.getX()+(mx-preX));
				v.setY(v.getY()+(my-preY));
				return true;
			}
			else if(event.getAction() == MotionEvent.ACTION_UP){
				v.invalidate();
				for(int i = 0;i<vg.getChildCount();i++){
					vg.getChildAt(i).invalidate();
				}
				return true;
			}
			
			return false;
		}
	};
	
	final Handler Hedit = new Handler();
	Runnable mHedit = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	};


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
