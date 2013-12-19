package com.seven.launcher.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.seven.launcher.R;
import com.seven.launcher.activity.fragment.MenuFragment;

public class YYBaseActivity extends SlidingFragmentActivity {

	protected MenuFragment menuFrag;
	private int mTitleRes;
	public YYBaseActivity(int titleRes) {
		mTitleRes = titleRes;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle(mTitleRes);
		// 设置menu布局,根据模式决定是从左侧还是右侧拉出
		setBehindContentView(R.layout.menu_frame);
		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager()
					.beginTransaction();
			menuFrag = new MenuFragment();
			t.replace(R.id.menu_frame, menuFrag);
			t.commit();
		} else {
			menuFrag = (MenuFragment) this.getSupportFragmentManager()
					.findFragmentById(R.id.menu_frame);
		}

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);// 阴影宽度
		sm.setShadowDrawable(R.drawable.shadow);// 阴影Drawable
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);// 拉开后离边框距离
		sm.setFadeDegree(0.35f);// 颜色渐变比例
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN); // 拉动事件区域 --全屏
		sm.setMode(SlidingMenu.LEFT_RIGHT);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true); // ActionBar返回启用
		//sm.setSlidingEnabled(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
