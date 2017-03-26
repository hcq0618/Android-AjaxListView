package com.github.ajaxlistview;

import com.github.ajaxlistview.AjaxListViewController.IAjaxRefreshCallback;

public interface IAjaxController {
	void setRefreshCallback(IAjaxRefreshCallback impl);

	void refreshItem(int pos, int... ids);

	void refreshItems(int... ids);

}
