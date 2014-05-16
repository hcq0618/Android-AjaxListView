package cn.seacat.ajaxlistview;

import cn.seacat.ajaxlistview.AjaxListViewController.IAjaxRefreshCallback;

public interface IAjaxController {
	void setRefreshCallback(IAjaxRefreshCallback impl);

	void refreshItem(int pos, int... ids);

	void refreshItems(int... ids);

}
