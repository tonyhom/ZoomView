package com.example.testzoomview;

import java.util.Vector;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class ASOP extends TextView{

	ASOP Parent = null;
	Vector<ASOP> Sons;
	
	// ASOP 的設定項
	int ASOPType;
	String id;
	String aid;
	boolean can_del=true;
	boolean can_change=true;
	boolean can_show=true;
	boolean is_shrink=false;
	boolean is_select=false;
	
	// 暫存項
	float pre_x,pre_y;
	
	public ASOP(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.ASOPType = 0;
		Sons = new Vector<ASOP>();
//		this.setOnTouchListener(this.onTouchListener);
	}
	
	public ASOP(Context context, int type){
		super(context);
		this.ASOPType = type;
		Sons = new Vector<ASOP>();
	}
	
	public void setParent(ASOP p){
		this.Parent = p;
	}
	
//	public OnTouchListener onTouchListener = new OnTouchListener() {
//		
//		@Override
//		public boolean onTouch(View v, MotionEvent event) {
//			// TODO Auto-generated method stub			
//			float mx = event.getX(); 
//			float my = event.getY();
//			
//			if(event.getAction() == MotionEvent.ACTION_DOWN){
////				v.setX(v.getX()+mx);
////				v.setY(v.getY()+my);
//				pre_X = event.getX();
//				pre_Y = event.getY();
//				return true;
//			}
//			else if(event.getAction() == MotionEvent.ACTION_MOVE){
//				v.setX(v.getX()+(mx-pre_X));
//				v.setY(v.getY()+(my-pre_Y));
//				return true;
//			}
//			else if(event.getAction() == MotionEvent.ACTION_UP){
//				v.invalidate();
//				for(int i = 0;i<vg.getChildCount();i++){
//					vg.getChildAt(i).invalidate();
//				}
//				return true;
//			}
//			
//			return false;
//		}
//	};
	
//	@Override
//	@SuppressLint("ClickableViewAccessibility")
//	public boolean onTouchEvent(MotionEvent event){
//		return false;
//	}
}
