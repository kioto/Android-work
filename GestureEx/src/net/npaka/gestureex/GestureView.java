package net.npaka.gestureex;
import java.util.ArrayList;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// ジェスチャーイベントの処理
public class GestureView extends View implements
	GestureDetector.OnGestureListener,
	GestureDetector.OnDoubleTapListener {
	private ArrayList<String> info;
	private GestureDetector gestureDetector;
	private Paint paint = new Paint();

	// コンストラクタ
	public GestureView(Context context) {
		super(context);
		setBackgroundColor(Color.WHITE);
		
		// 情報の生成
		info = new ArrayList<String>();
		info.add("GestureEx");
		
		// ジェスチャーディテクターの生成
		gestureDetector = new GestureDetector(context, this);
		
		// フォーカス指定
		setFocusable(true);
	}
	
	// 描画時に呼ばれる
	@Override
	protected void onDraw(Canvas canvas) {
		// 描画オブジェクトの生成
		paint.setAntiAlias(true);;
		paint.setTextSize(32);
		
		// 情報の描画
		for (int i=0; i<info.size(); i++) {
			canvas.drawText((String)info.get(i),  0,  24+26*i,  paint);
		}
	}
	
	// 情報の追加
	private void addInfo(String str) {
		info.add(0, str);
		while(info.size() > 30) info.remove(info.size()-1);
		invalidate();
	}
	
	// タッチ時に呼ばれる
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// ジェスチャーディテクターの設置
		gestureDetector.onTouchEvent(event);
		return true;
	}
	
	// ダウン時に呼ばれる
	public boolean onDown(MotionEvent e) {
		addInfo("Down");
		return true;
	}
	
	// プレス時に呼ばれる
	public void onShowPress(MotionEvent e) {
		addInfo("ShowPress");
	}
	
	// アップ時に呼ばれる
	public boolean onSingleTapUp(MotionEvent e) {
		addInfo("Up");
		return false;
	}
	
	// 長押し時に呼ばれる
	public void onLongPress(MotionEvent e) {
		addInfo("LongPress");
	}
	
	// フリック時に呼ばれる
	public boolean onFling(MotionEvent e0, MotionEvent e1,
							float velocityX, float velocityY) {
		addInfo("Fling("+(int)velocityX+","+(int)velocityY);
		return false;
	}
	
	// スクロール時に呼ばれる
	public boolean onScroll(MotionEvent e0, MotionEvent e1,
							float distanceX, float distanceY) {
		addInfo("Scroll("+(int)distanceX+","+(int)distanceY+")");
		return false;
	}
	
	// シングルタップ時に呼ばれる
	public boolean onSingleTapConfirmed(MotionEvent e) {
		addInfo("SingleTap");
		return false;
	}
	
	// ダブルタップ時に呼ばれる
	public boolean onDoubleTap(MotionEvent e) {
		addInfo("DoubleTap");
		return false;
	}
	
	// ダウブルタップイベント発生時に呼ばれる
	public boolean onDoubleTapEvent(MotionEvent e) {
		addInfo("DouibleTapEvent");
		return false;
	}
}
