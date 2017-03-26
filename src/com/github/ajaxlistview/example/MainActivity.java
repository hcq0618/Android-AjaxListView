package com.github.ajaxlistview.example;

import cn.seacat.ajaxlistview.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.button1:

			startActivity(new Intent(this, TestAjaxListViewActivity.class));
			break;
		case R.id.button2:
			startActivity(new Intent(this, TestListViewActivity.class));
			break;

		default:
			break;
		}
	}
}
