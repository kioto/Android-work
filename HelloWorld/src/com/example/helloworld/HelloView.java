package com.example.helloworld;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

// HelloWorld
public class HelloView extends View {
	// コンストラクタ
	public HelloView(Context context) {
		super(context);
		setBackgroundColor(Color.WHITE);
	}
	
	// 描画
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawText("Hellow World!!", 0, 12, new Paint());
	}
}
