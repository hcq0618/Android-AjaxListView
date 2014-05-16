package cn.seacat.ajaxlistview;

/*author changqiang 
 email  hcq0618@163.com */
import android.view.View;
import android.widget.ListView;

public class AjaxListViewController implements IAjaxController {
	private IAjaxRefreshCallback impl;
	private ListView lv;

	public static enum AjaxRefreshType {
		REFRESH_ONE_ITEM, REFRESH_LIST_ITEMS
	}

	public AjaxListViewController(ListView lv) {
		this.lv = lv;
	}

	@Override
	public void setRefreshCallback(IAjaxRefreshCallback impl) {
		this.impl = impl;
	}

	@Override
	public void refreshItem(int pos, int... ids) {
		if (impl == null || lv == null || lv.getAdapter() == null
				|| ids == null || ids.length == 0)
			return;
		int firstPos = lv.getFirstVisiblePosition();
		int lastPos = lv.getLastVisiblePosition();
		if (pos < firstPos || pos > lastPos)
			return;

		View contentView = lv.getChildAt(pos - firstPos);
		if (contentView != null) {
			refresh(AjaxRefreshType.REFRESH_ONE_ITEM, contentView, pos, ids);
		}
	}

	@Override
	public void refreshItems(int... ids) {
		if (impl == null || lv == null || lv.getAdapter() == null
				|| ids == null || ids.length == 0)
			return;
		int firstPos = lv.getFirstVisiblePosition();
		int lastPos = lv.getLastVisiblePosition();

		for (int i = firstPos; i <= lastPos; i++) {
			View contentView = lv.getChildAt(i - firstPos);
			refresh(AjaxRefreshType.REFRESH_LIST_ITEMS, contentView, i, ids);
		}
	}

	private void refresh(AjaxRefreshType type, View contentView, int position,
			int... ids) {
		if (contentView != null) {
			Object tag = contentView.getTag();
			if (tag != null) {
				if (tag instanceof IAjaxViewHolder) {
					IAjaxViewHolder holder = (IAjaxViewHolder) tag;
					for (int id : ids) {
						impl.onItemRefresh(type, position, id,
								holder.getChildView(id));
					}
					return;
				}
			}
			for (int id : ids) {
				impl.onItemRefresh(type, position, id,
						contentView.findViewById(id));
			}
		}
	}

	public static interface IAjaxRefreshCallback {

		public void onItemRefresh(AjaxRefreshType type, int position, int id,
				View v);
	}

}
