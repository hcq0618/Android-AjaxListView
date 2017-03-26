package com.github.ajaxlistview.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import cn.seacat.ajaxlistview.AjaxListView;
import cn.seacat.ajaxlistview.R;

public class TestAjaxListViewActivity extends Activity implements
		OnClickListener {
	private int position = 0;
	private AjaxListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.list_layout);

		// use AjaxListView
		lv = (AjaxListView) findViewById(R.id.test_list);
		lv.setVisibility(View.VISIBLE);
		
		// use AjaxAdapter
		MyAjaxAdapter adapter = new MyAjaxAdapter(this,
				R.layout.list_item_layout, new int[] { R.id.test_pb,
						R.id.test_tv });
		lv.setAdapter(adapter);
		// or set your ListAdapter
		// lv.setAdapter(yourListAdapter);

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
			lv.refreshItem(position, R.id.test_pb, R.id.test_tv);
			position++;
			break;
		case R.id.test_btn2:
			lv.refreshItems(R.id.test_pb, R.id.test_tv);
			break;

		default:
			break;
		}

	}

}
