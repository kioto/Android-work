package net.npaka.stringex;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.Menu;

// 文字列の描画
public class StringEx extends Activity {

	// アクティビティ起動時に呼ばれる
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		setContentView(R.layout.activity_string_ex);
		setContentView(new StringView(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.string_ex, menu);
		return true;
	}

}
