package net.npaka.stringex;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class StringView extends View {
	
	 Paint mPaint = new Paint ();
	 
	// コンストラクタ
	public StringView(Context context) {
		super(context);
		setBackgroundColor(Color.WHITE);
	}
	
	// 描画
	@Override
	protected void onDraw(Canvas canvas) {
		mPaint.setAntiAlias(true);
		
		// 文字サイズと文字色の指定
		mPaint.setTextSize(24);
		mPaint.setColor(Color.rgb(0,0,0));
		
		// 画面サイズの取得
		canvas.drawText("画面サイズ："+getWidth()+"x"+getHeight(), 0, 60, mPaint);
		
		// 文字幅の取得
		canvas.drawText("文字幅："+(int)mPaint.measureText("A"), 0, 60*2, mPaint);
		
		// アセント・ディセントの取得
		canvas.drawText("アセント："+(int)mPaint.ascent(),0,60*3,mPaint);
		canvas.drawText("ディセント："+(int)mPaint.descent(),0,60*4,mPaint);
		
		// 24ドットの文字列の表示
		mPaint.setTextSize(24);
		mPaint.setColor(Color.rgb(255, 0, 0));
		canvas.drawText("24dot",0,60*5,mPaint);
		
		// 32ドットの文字列の表示
		mPaint.setTextSize(32);
		mPaint.setColor(Color.rgb(0, 255, 0));
		canvas.drawText("32dot",0,60*6,mPaint);
				
		// 48ドットの文字列の表示
		mPaint.setTextSize(48);
		mPaint.setColor(Color.rgb(0, 0, 255));
		canvas.drawText("48dot",0,60*7,mPaint);
		
		
	}
}
