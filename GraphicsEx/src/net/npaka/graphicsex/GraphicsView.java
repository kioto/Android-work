package net.npaka.graphicsex;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

// 図形の描画
public class GraphicsView extends View {

	// オブジェクトの生成
	Paint mPaint = new Paint();
	Path mPath = new Path();
	Rect mRect1 = new Rect(10+0,100+0,10+80,100+80);
	Rect mRect2 = new Rect(110+0,100+0,110+80,100+80);
	RectF mRectF1 = new RectF(10+0,200+0,10+80,200+80);
	RectF mRectF2 = new RectF(110+0,200+0,110+80,200+80);

	// コンストラクタ
	public GraphicsView(Context context) {
		super(context);
		setBackgroundColor(Color.WHITE);
	}
	
	// 描画
	protected void onDraw(Canvas canvas) {
		mPaint.setAntiAlias(true);
		
		// ラインの描画
		mPaint.setStrokeWidth(1);
		mPaint.setColor(Color.argb(255, 255, 0, 0));
		canvas.drawLine(50,10,50,10+80,mPaint);
		
		// パスの描画
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.argb(255,255,0,0));
		mPath.moveTo(110+ 0,10+ 0);
		mPath.lineTo(110+60,10+10);
		mPath.lineTo(110+20,10+40);
		mPath.lineTo(110+80,10+50);
		mPath.lineTo(110+ 0,10+80);
		canvas.drawPath(mPath,mPaint);
		
		// 四角形の描画
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.argb(255,0,0,255));
		canvas.drawRect(mRect1, mPaint);
		
		// 四角形の塗り潰し
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setColor(Color.argb(255,0,0,255));
		canvas.drawRect(mRect2, mPaint);
		
		// 角丸矩形の描画
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.argb(255,0,255,0));
		canvas.drawRoundRect(mRectF1, 20,20,mPaint);
		
		// 角丸矩形の塗り潰し
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setColor(Color.argb(255,0,255,0));
		canvas.drawRoundRect(mRectF2, 20,20,mPaint);
		
		// 円の描画
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.argb(255,255,255,0));
		canvas.drawCircle(50,340,40,mPaint);
		
		// 円の塗り潰し
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setColor(Color.argb(255,255,255,0));
		canvas.drawCircle(150,340,40,mPaint);
	}
}
