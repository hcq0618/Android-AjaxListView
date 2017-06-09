package com.github.ajaxlistview;

/*author changqiang 
 email  hcq0618@163.com */

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AjaxListView extends ListView implements IAjaxController {

    private AjaxListViewController controller;

    public AjaxListView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        init();
    }

    public AjaxListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        init();
    }

    public AjaxListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        init();
    }

    private void init() {
        controller = new AjaxListViewController(this);
    }

    public void setAdapter(AbsAjaxAdapter adapter) {
        // TODO Auto-generated method stub
        controller.setRefreshCallback(adapter);
        super.setAdapter(adapter);
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        // TODO Auto-generated method stub
        if (adapter instanceof IAjaxRefreshCallback)
            controller.setRefreshCallback((IAjaxRefreshCallback) adapter);
        super.setAdapter(adapter);
    }

    @Override
    public void setRefreshCallback(IAjaxRefreshCallback impl) {
        // TODO Auto-generated method stub
        controller.setRefreshCallback(impl);
    }

    @Override
    public void refreshItem(int pos, int... ids) {
        // TODO Auto-generated method stub
        controller.refreshItem(pos, ids);
    }

    @Override
    public void refreshItems(int... ids) {
        // TODO Auto-generated method stub
        controller.refreshItems(ids);
    }

}
