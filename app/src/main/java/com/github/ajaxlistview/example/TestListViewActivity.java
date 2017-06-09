package com.github.ajaxlistview.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.github.ajaxlistview.AjaxListViewController;
import com.github.ajaxlistview.R;


public class TestListViewActivity extends Activity implements OnClickListener {
	private int position = 0;
	private AjaxListViewController controller;
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.list_layout);

		// use your listview
		lv = (ListView) findViewById(R.id.test_your_list);
		controller = new AjaxListViewController(lv);
		lv.setVisibility(View.VISIBLE);
		
		// use your listAdapter
		MyAdapter adapter = new MyAdapter(this);
		lv.setAdapter(adapter);
		controller.setRefreshCallback(adapter);

		findViewById(R.id.test_btn1).setOnClickListener(this);
		findViewById(R.id.test_btn2).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.test_btn1:
			int firstPos = lv.getFirstVisiblePosition();
			int lastPos = lv.getLastVisiblePosition();
			System.out.println(firstPos);
			System.out.println(lastPos);
			// set position for test data
			if (position > lastPos || position < firstPos)
				position = firstPos;
			System.out.println(position);
			controller.refreshItem(position, R.id.test_pb, R.id.test_tv);
			position++;
			break;
		case R.id.test_btn2:
			controller.refreshItems(R.id.test_pb, R.id.test_tv);
			break;

		default:
			break;
		}

	}
}
