package net.npaka.surfaceviewex;
import android.content.res.Resources;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

// サーフェイスビューの利用
public class SurfaceViewView extends SurfaceView
	implements SurfaceHolder.Callback, Runnable {
	private SurfaceHolder	holder;	// サーフェイスホルダー
	private Thread			thread;	// スレッド
	
	private Bitmap			image;	// イメージ
	private int				px=0;	// X座標
	private int				py=0;	// Y座標
	private int				vx=10;	// X速度
	private int				vy=10;	// Y速度

	// コンストラクタ
	public SurfaceViewView(Context context) {
		super(context);
		
		// 画像の読み込み
		Resources r = getResources();
		image = BitmapFactory.decodeResource(r, R.drawable.sample);
		
		// サーフェイスホルダーの生成
		holder = getHolder();
		holder.addCallback(this);
		holder.setFixedSize(480,  762);
	}
	
	// サーフェイスの生成
	public void surfaceCreated(SurfaceHolder holder) {
		// スレッドの開始
		thread = new Thread(this);
		thread.start();
	}
	
	// サーフェイスの変更
	public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
	}
	
	// サーフェイスの破棄
	public void surfaceDestroyed(SurfaceHolder holder) {
		thread = null;
	}
	
	// スレッドの処理
	public void run() {
		Canvas canvas;
		while(thread != null) {
			// ダブルバッファリング
			canvas = holder.lockCanvas();
			canvas.drawColor(Color.WHITE);
			canvas.drawBitmap(image,  px-40,  py-40, null);;
			holder.unlockCanvasAndPost(canvas);
			
			// 移動
			if (px < 0 || getWidth() < px) vx = -vx;
			if (py < 0 || getHeight() < py) vy = -vy;
			px += vx;
			py += vy;
			
			// スリープ
			try {
				Thread.sleep(50);
			} catch (Exception e) {
			}
		}
	}
}

