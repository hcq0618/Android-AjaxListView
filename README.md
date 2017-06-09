Android-AjaxListView
====================

有局部刷新功能的listview 类似Ajax - include partial refresh feature's listview like ajax


1、一般listview刷新数据都会导致界面全部刷新 
如果遇到需要频繁刷新某一项或者某几项的某个view 例如只加载进度条时 就会导致界面卡顿或者滑动不流畅
这个listview采用局部刷新机制就解决了这个问题

2、支持直接使用AjaxListView或者继承AbsAjaxAdapter 也支持直接使用你自己原有的自定义listview或者listAdapter

3、也可以单独继承并使用AbsAjaxAdapter来使你自己的listAdapter代码更简洁
继承后你的adapter只需要简单的像下面这样写 就可以完成布局：

```java
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
```

4、项目中附带比较详细的demo

## License

MIT License

Copyright (c) 2017 Hcq

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
