package cn.seacat.ajaxlistview.example;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.seacat.ajaxlistview.AjaxListViewController.AjaxRefreshType;
import cn.seacat.ajaxlistview.AjaxListViewController.IAjaxRefreshCallback;
import cn.seacat.ajaxlistview.IAjaxViewHolder;
import cn.seacat.ajaxlistview.R;

public class MyAdapter extends BaseAdapter implements IAjaxRefreshCallback {
	private SparseIntArray progresses = new SparseIntArray();// for test data
	private Context cx;

	public MyAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.cx = context;
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
	public View getView(int position, View contentView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (contentView == null) {
			holder = new ViewHolder();
			contentView = LayoutInflater.from(cx).inflate(
					R.layout.list_item_layout, null);
			holder.tv = (TextView) contentView.findViewById(R.id.test_tv);
			holder.pb = (ProgressBar) contentView.findViewById(R.id.test_pb);
			contentView.setTag(holder);
		} else {
			holder = (ViewHolder) contentView.getTag();
		}

		int progress = progresses.get(position) == 0 ? position : progresses
				.get(position);
		holder.tv.setText("test progress is " + progress + " and position is "
				+ position);
		holder.pb.setProgress(progress);
		progresses.put(position, progress);

		return contentView;
	}

	// your can implements IAjaxViewHolder like this or not
	// but recommend implements it
	private class ViewHolder implements IAjaxViewHolder {
		TextView tv;
		ProgressBar pb;

		@Override
		public View getChildView(int id) {
			// TODO Auto-generated method stub

			switch (id) {
			case R.id.test_tv:
				return tv;
			case R.id.test_pb:
				return pb;

			default:
				break;
			}

			return null;
		}
	}

	@Override
	public void onItemRefresh(AjaxRefreshType type, int position, int id, View v) {
		// TODO Auto-generated method stub
		System.out.println("onItemRefresh");
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
						cx,
						"Refresh progressbar at position " + position
								+ " and progress is " + progress,
						Toast.LENGTH_LONG).show();
			break;

		default:
			break;
		}
		progresses.put(position, progress);
	}

}
