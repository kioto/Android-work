package net.npaka.checkboxex;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

// チェックボックスとラジオボタンとスピナー
public class CheckBoxEx extends Activity
	implements View.OnClickListener {
	private final static String BR = System.getProperty("line.separator");
	private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
	
	private CheckBox   checkBox;	// チェックボックス
	private RadioGroup radioGroup;	// ラジオグループ
	private Spinner    spinner;		// スピナー
	private Button     button;		// ボタン
	
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
		
		// チェックボックスの生成
		checkBox = new CheckBox(this);
		checkBox.setText("チェックボックス");
		checkBox.setTextColor(Color.rgb(0,0,0));
		checkBox.setChecked(true);
		checkBox.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
		layout.addView(checkBox);
		
		// ラジオボタン0の生成
		RadioButton radio0 = new RadioButton(this);
		radio0.setId(0);
		radio0.setText("ラジオボタン0");
		radio0.setTextColor(Color.rgb(0,0,0));
		
		// ラジオボタン1の生成
		RadioButton radio1 = new RadioButton(this);
		radio1.setId(1);
		radio1.setText("ラジオボタン1");
		radio1.setTextColor(Color.rgb(0, 0, 0));
		
		// ラジオグループの生成
		radioGroup = new RadioGroup(this);
		radioGroup.addView(radio0);
		radioGroup.addView(radio1);
		radioGroup.check(0);
		radioGroup.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
		layout.addView(radioGroup);
		
		// スピナーの生成
		ArrayAdapter<String> adapter = new ArrayAdapter<String> (
				this, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item);
		String[] strs = {"赤", "青", "黄"};
		for(int i=0; i<strs.length; i++) adapter.add(strs[i]);
		spinner = new Spinner(this);
		spinner.setAdapter(adapter);;
		spinner.setSelection(0);
		spinner.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
		layout.addView(spinner);
		
		// ボタンの生成
		button = new Button(this);
		button.setText("結果表示");
		button.setOnClickListener(this);
		button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
		layout.addView(button);
	}
	
	// ボタンクリック時に呼ばれる
	public void onClick(View v) {
		// チェックボックスとラジオボタンとスピナーの状態取得
		showDialog(this, "",
				"チェックボックス>" + checkBox.isChecked() + BR +
				"ラジオボタン>" + radioGroup.getCheckedRadioButtonId() + BR +
				"スピナー>" + spinner.getSelectedItem());
	}
	
	// ダイアログの表示
	private static void showDialog(Context context, String title, String text) {
		AlertDialog.Builder ad = new AlertDialog.Builder(context);
		ad.setTitle(title);
		ad.setMessage(text);
		ad.setPositiveButton("OK", null);
		ad.show();
	}
}
