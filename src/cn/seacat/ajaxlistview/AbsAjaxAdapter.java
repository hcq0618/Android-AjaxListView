package cn.seacat.ajaxlistview;

/*author changqiang 
 email  hcq0618@163.com */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import cn.seacat.ajaxlistview.AjaxListViewController.IAjaxRefreshCallback;

public abstract class AbsAjaxAdapter extends BaseAdapter implements
		IAjaxRefreshCallback {

	protected int[] bindIds;
	protected int layoutId;
	protected Context context;

	public AbsAjaxAdapter(Context context, int layoutId, int... ids) {
		this.context = context;
		this.layoutId = layoutId;
		this.bindIds = ids;
	}

	public void setLayoutId(int layoutId) {
		this.layoutId = layoutId;
	}

	public void setBindIds(int... bindIds) {
		this.bindIds = bindIds;
	}

	@Override
	public View getView(int position, View contentView, ViewGroup parent) {
		// TODO Auto-generated method stub
		AjaxViewHolder holder = null;
		if (contentView == null) {
			contentView = LayoutInflater.from(context).inflate(layoutId, null);
			holder = new AjaxViewHolder(contentView);
			holder.bindTag();
			if (bindIds != null) {
				for (int id : bindIds) {
					holder.bindChildView(id);
					setupView(id, holder.getChildView(id), position,
							contentView, parent);
				}
			}
			return contentView;
		}

		holder = (AjaxViewHolder) contentView.getTag();

		for (int id : bindIds) {
			setupView(id, holder.getChildView(id), position, contentView,
					parent);
		}
		return contentView;
	}

	public abstract void setupView(int id, View v, int position,
			View contentView, ViewGroup parent);
}
