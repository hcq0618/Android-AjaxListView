package com.github.ajaxlistview;

public interface IAjaxController {
	void setRefreshCallback(IAjaxRefreshCallback impl);

	void refreshItem(int pos, int... ids);

	void refreshItems(int... ids);

}
