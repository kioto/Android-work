package net.npaka.buttonex;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class ButtonEx extends Activity implements
	View.OnClickListener {
	private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
	private EditText editText ;
	
	// アクティビティ起動時に呼ばれる
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		// レイアウトの生成
		LinearLayout layout = new LinearLayout(this);
		layout.setBackgroundColor(Color.rgb(255, 255, 255));
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);
		
		// ボタンの生成
		layout.addView(makeButton("ダイアログを表示", "0"));
		layout.addView(makeButton("Yes/Noダイアログの表示", "1"));
		layout.addView(makeButton("テキストダイアログの表示", "2"));
		layout.addView(makeButton(res2bmp(this,R.drawable.sample), "3"));
	}

	// ボタンの生成
	private Button makeButton(String text, String tag) {
		Button button = new Button(this);
		button.setText(text);
		button.setTag(tag);
		button.setOnClickListener(this);	// ボタンクリックイベントの処理
		button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
		return button;
	}
	
	// イメージボタンの生成
	private ImageButton makeButton(Bitmap bmp, String tag) {
		Bitmap pressed = filｔeringBmp(bmp, Color.LTGRAY, PorterDuff.Mode.MULTIPLY);
		ImageButton button = new ImageButton(this);
		button.setTag(tag);
		button.setOnClickListener(this);
		StateListDrawable drawables = new StateListDrawable();
		int statePressed = android.R.attr.state_pressed;
		drawables.addState(new int[] {statePressed}, new BitmapDrawable(pressed));
		drawables.addState(new int[] {            }, new BitmapDrawable(bmp));
		button.setBackgroundDrawable(drawables);
		button.setLayoutParams(new LinearLayout.LayoutParams(
				bmp.getWidth(), bmp.getHeight()));
		return button;
	}
	
	// ビットマップのフィルタリング
	private static Bitmap filｔeringBmp(Bitmap bmp, int color, PorterDuff.Mode mode) {
		int w = bmp.getWidth();
		int h = bmp.getHeight();
		Bitmap result = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		BitmapDrawable bd = new BitmapDrawable(bmp);
		bd.setBounds(0, 0, w, h);
		bd.setColorFilter(color, mode);
		Canvas c = new Canvas(result);
		bd.draw(c);;
		return result;
	}
	
	// リソース→ビットマップ
	public static Bitmap res2bmp(Context context, int resID) {
		return BitmapFactory.decodeResource(
				context.getResources(), resID);
	}
	
	// ダイアログの表示
	private static void showDialog(Context context, String title, String text) {
		AlertDialog.Builder ad = new AlertDialog.Builder(context);
		ad.setTitle(title);
		ad.setMessage(text);
		ad.setPositiveButton("OK", null);
		ad.show();
	}
	
	// Yes/Noダイアログの表示
	private static void showYesNoDialog(Context context,
			String title, String text, DialogInterface.OnClickListener listener) {
		AlertDialog.Builder ad = new AlertDialog.Builder(context);
		ad.setTitle(title);
		ad.setMessage(text);
		ad.setPositiveButton("Yes",  listener);
		ad.setNegativeButton("No", listener);
		ad.show();
	}
	
	// テキストダイアログの表示
	private static void showTextDialog(Context context,
			String title, EditText editText,
			DialogInterface.OnClickListener listener) {
		AlertDialog.Builder ad = new AlertDialog.Builder(context);
		ad.setTitle(title);
		ad.setView(editText);
		ad.setPositiveButton("OK",  listener);
		ad.show();
	}
	
	// ボタンクリック時に呼ばれる
	public void onClick(View view) {
		int tag = Integer.parseInt((String)view.getTag());
		if (tag == 0) {
			showDialog(this, "ダイアログ", "ボタンを押した");
		} else if (tag == 1) {
			showYesNoDialog(this, "Yes/Noダイアログ", "Yes/Noを選択",
					new DialogInterface.OnClickListener() {
					// クリック時に呼ばれる
					public void onClick(DialogInterface dialog, int which) {
						if (which == DialogInterface.BUTTON_POSITIVE){
							showDialog(ButtonEx.this, "", "YES");
						} else if (which == DialogInterface.BUTTON_NEGATIVE){
							showDialog(ButtonEx.this, "", "NO");
						}
					}
			});
		} else if (tag == 2) {
			editText = new EditText(this);
			showTextDialog(this, "テキストダイアログ", editText,
					new DialogInterface.OnClickListener() {
					// クリック時に呼ばれる
					public void onClick(DialogInterface dialog, int which) {
						showDialog(ButtonEx.this, "", editText.getText().toString());
					}
			});
		} else if(tag == 3) {
			showDialog(this, "", "イメージボタンを押した　");
		}
	}
}
