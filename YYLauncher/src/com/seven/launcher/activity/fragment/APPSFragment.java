package com.seven.launcher.activity.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import ca.laplanete.mobile.pageddragdropgrid.OnPageChangedListener;
import ca.laplanete.mobile.pageddragdropgrid.PagedDragDropGrid;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.seven.launcher.R;
import com.seven.launcher.activity.YYMainActivity;

public class APPSFragment extends Fragment implements OnClickListener{

	 private String CURRENT_PAGE_KEY = "CURRENT_PAGE_KEY"; 
	 private PagedDragDropGrid gridview;
	 private  YYMainActivity main ;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.apps_fragme, null);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
	   gridview = (PagedDragDropGrid) getActivity().findViewById(R.id.gridview);	
		
		AppsPagedDragDropGridAdapter adapter = new AppsPagedDragDropGridAdapter(getActivity(), gridview);
	
        gridview.setAdapter(adapter);
		gridview.setClickListener(this);

		gridview.setBackgroundColor(Color.LTGRAY);	
		 main = (YYMainActivity) getActivity();
			final int size = adapter.pageCount()-1;
		gridview.setOnPageChangedListener(new OnPageChangedListener() {            
            @Override
            public void onPageChanged(PagedDragDropGrid sender, int newPageNumber) {
            	if(0==newPageNumber){
            		main.getSlidingMenu().setMode(SlidingMenu.LEFT);
					main.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
            	}else if(size==newPageNumber){
            		main.getSlidingMenu().setMode(SlidingMenu.LEFT_RIGHT);
					main.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
            	}else{
            		 
            		main.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
            	}
            	
                Toast.makeText(getActivity(), "Page changed to page " + newPageNumber, Toast.LENGTH_SHORT).show();                
            }
        });
		main.getSlidingMenu().setMode(SlidingMenu.LEFT);
	}

	@Override
	public void onClick(View arg0) {
		 Toast.makeText(getActivity(), "Clicked View", Toast.LENGTH_SHORT).show();
		
	}
}
