package com.github.ajaxlistview.example;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ajaxlistview.AbsAjaxAdapter;
import com.github.ajaxlistview.AjaxRefreshType;
import com.github.ajaxlistview.R;


public class MyAjaxAdapter extends AbsAjaxAdapter {

	private SparseIntArray progresses = new SparseIntArray();// for test data

	public MyAjaxAdapter(Context context, int layoutId, int[] ids) {
		super(context, layoutId, ids);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onItemRefresh(AjaxRefreshType type, int position, int id, View v) {
		// TODO Auto-generated method stub
		int progress = progresses.get(position) + 10;

		switch (id) {
		case R.id.test_tv:
			TextView tv = (TextView) v;
			tv.setText("test progress is " + progress + " and position is "
					+ position);
			break;
		case R.id.test_pb:
			ProgressBar pb = (ProgressBar) v;
			progress = progress > pb.getMax() ? pb.getMax() : progress;
			pb.setProgress(progress);
			if (type == AjaxRefreshType.REFRESH_ONE_ITEM)
				Toast.makeText(
						context,
						"Refresh progressbar at position " + position
								+ " and progress is " + progress,
						Toast.LENGTH_LONG).show();
			break;

		default:
			break;
		}
		progresses.put(position, progress);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setupView(int id, View v, int position, View contentView,
			ViewGroup parent) {
		// TODO Auto-generated method stub
		int progress = progresses.get(position) == 0 ? position : progresses
				.get(position);
		switch (id) {
		case R.id.test_tv:
			TextView tv = (TextView) v;
			tv.setText("test progress is " + progress + " and position is "
					+ position);
			break;
		case R.id.test_pb:
			ProgressBar pb = (ProgressBar) v;
			pb.setProgress(progress);
			break;

		default:
			break;
		}
		progresses.put(position, progress);
	}
}
