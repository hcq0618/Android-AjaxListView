package cn.seacat.ajaxlistview;

/*author changqiang 
 email  hcq0618@163.com */
import android.util.SparseArray;
import android.view.View;

public class AjaxViewHolder implements IAjaxViewHolder {
	private View contentView;
	private SparseArray<View> bindViews = new SparseArray<View>();

	public AjaxViewHolder(View contentView) {
		this.contentView = contentView;
	}

	public void bindChildView(int id) {
		View tv = contentView.findViewById(id);
		bindViews.put(id, tv);
	}

	@Override
	public View getChildView(int id) {
		// TODO Auto-generated method stub
		return bindViews.get(id);
	}

	public void bindTag() {
		contentView.setTag(this);
	}

	public void setBindViews(SparseArray<View> bindViews) {
		this.bindViews = bindViews;
	}

}
