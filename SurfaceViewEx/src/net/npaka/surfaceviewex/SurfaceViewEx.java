package net.npaka.surfaceviewex;
import android.app.Activity;
import android.os.Bundle;
import android.graphics.PixelFormat;
import android.view.Window;

// サーフェイスビューの利用
public class SurfaceViewEx extends Activity {
	// アクティビティ起動時に呼ばれる
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFormat(PixelFormat.TRANSLUCENT);
		setContentView(new SurfaceViewView(this));
	}
}
