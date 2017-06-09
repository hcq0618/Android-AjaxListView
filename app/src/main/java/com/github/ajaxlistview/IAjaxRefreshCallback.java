package com.github.ajaxlistview;

import android.view.View;

/**
 * Created by huangchangqiang on 2017/6/9.
 */
public interface IAjaxRefreshCallback {

    void onItemRefresh(AjaxRefreshType type, int position, int id,
                       View v);
}
