package com.seven.launcher.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.seven.launcher.R;
import com.seven.launcher.activity.fragment.APPSFragment;
import com.seven.launcher.activity.fragment.MenuFragment;
import com.seven.launcher.activity.fragment.SampleListFragment;

public class YYMainActivity extends YYBaseActivity{

	private Fragment mContent;
	public YYMainActivity() {
		super(R.string.app_name);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);	
		if (savedInstanceState != null)
			mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
		if (mContent == null)
			mContent = new APPSFragment();	
		
		
		setContentView(R.layout.content_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, mContent)
		.commit();
		
		getSlidingMenu().setSecondaryMenu(R.layout.menu_frame_two);
		getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadowright);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame_two, new SampleListFragment())
		.commit();
		
		 
		
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getSupportFragmentManager().putFragment(outState, "mContent", mContent);
	}
	
	public void switchContent(Fragment fragment) {
		mContent = fragment;
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, fragment)
		.commit();
		getSlidingMenu().showContent();
	}
	
}
