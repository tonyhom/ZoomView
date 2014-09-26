package com.example.testzoomview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class LinkView extends View {
	Paint paint = new Paint();
	View startView;
	View endView;
	Canvas canvas;

	public LinkView(Context context,View startView,View endView) {
		super(context);
		// TODO Auto-generated constructor stub
		paint.setColor(Color.YELLOW);
		paint.setStrokeWidth(3f);
		this.startView = startView;
		this.endView = endView;
	}

	@SuppressLint("NewApi")
	public void onDraw(Canvas canvas){
		canvas.drawLine(startView.getX()+startView.getWidth(), startView.getY()+startView.getHeight()/2, endView.getX(), endView.getY()+endView.getHeight()/2, paint);
		this.canvas = canvas;
	}
}
