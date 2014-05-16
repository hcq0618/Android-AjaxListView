Android-AjaxListView
====================

有局部刷新功能的listview 类似Ajax include partial refresh feature's listview like ajax


1、一般listview刷新数据都会导致界面全部刷新 
如果遇到需要频繁刷新某一项或者某几项的某个view 例如只加载进度条时 就会导致界面卡顿或者滑动不流畅
这个listview采用局部刷新机制就解决了这个问题

2、支持直接使用AjaxListView或者继承AbsAjaxAdapter 也支持直接使用你自己原有的自定义listview或者listAdapter

3、也可以单独继承并使用AbsAjaxAdapter来使你自己的listAdapter代码更简洁
继承后你的adapter只需要简单的像下面这样写 就可以完成布局：

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
	
4、项目中附带比较详细的demo
