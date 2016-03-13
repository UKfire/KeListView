## KeListView
一款支持下拉刷新，上拉加载更多的自定义ListView，我将其命名为KeListView
##It looks Cool

![pullToRefresh](http://115.29.113.234:8080/yy/pull.png)

![loadMore](http://115.29.113.234:8080/yy/load.png)

## How To Use
Download ZIP，然后解压，将ylistview包添加到自己的项目中，然后再Project Structure设置你app的dependiences，点击＋号module dependency将ylistview添加进来，接下来就能在项目中使用了。
## Sample
先在xml中声明        

		<com.ytying.ytblog.act.widget.KeListView
	     	android:id="@+id/listview"
	     	android:layout_width="match_parent"
	     	android:layout_height="match_parent"/>


然后在Activity中获取到，跟普通ListView一样设置其Adapter，然后为其设置回调函数，OnRefresh()和OnLoad()，表示下拉刷新和上拉加载更多。
	
		ListView listView = (KeListView)findViewById(R.id.listview);
		
		final Adapter adapter = new Adapter(getActivity(), 	presenter.getList());
	
		//给ListView设置Adapter
	    listview.setAdapter(adapter);
	
	    listview.setOnRefreshListener(new KeListView.RefreshListener() {
	       	//下拉刷新回调函数
	        @Override
	        public void onRefresh() {
	            Handler handler = new Handler();
	            handler.postDelayed(new Runnable() {
	                @Override
	                public void run() {
	                    presenter.runRefresh();
	                    adapter.notifyDataSetChanged();
	                    listview.onRefreshComplete();
	                }
	            }, 2000);
	
	        }
	        
			//上拉加载更多回调函数
	        @Override
	        public void onLoad() {
	            Handler handler = new Handler();
	            handler.postDelayed(new Runnable() {
	                @Override
	                public void run() {
	                    presenter.runLoad();
	                    adapter.notifyDataSetChanged();
	                    listview.onLoadComplete();
	                }
	            }, 2000);
	        }
	    });
	    
详细使用方法，可以看sample包里的例子。
	        	        
## Thanks
感谢开源项目[loading-balls](https://github.com/glomadrian/loading-balls)，我将其作为KeListView的headerView

感谢开源项目[MetaballLoading](https://github.com/dodola/MetaballLoading)，我将其作为KeListView的footerView

##写在最后
二珂女神镇楼

欢迎大家访问我的主页[二可](http://www.ytying.com)

![pullToRefresh](http://115.29.113.234:8080/yy/8.jpg)
