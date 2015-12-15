package com.wangfq.bottomtabbar;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	private FragmentTabHost mTabHost;
	private LayoutInflater mLayoutInflater;

	private Class<?> mFragmentArray[] = { HomeFragment.class, MsgFragment.class, DiscoverFragment.class, MeFragment.class };

	private int[] mImageArray = { R.drawable.tab_item_home_btn, R.drawable.tab_item_msg_btn, R.drawable.tab_item_discover_btn, R.drawable.tab_item_me_btn };

	private int[] mTextArray = { R.string.home, R.string.msg, R.string.discover, R.string.me };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView() {
		mLayoutInflater = LayoutInflater.from(this);

		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		int count = mFragmentArray.length;
		for (int i = 0; i < count; i++) {
			TabSpec spec = mTabHost.newTabSpec(getString(mTextArray[i]));
			spec.setIndicator(getTabItemView(i));

			mTabHost.addTab(spec, mFragmentArray[i], null);

			// mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab_item_backgound_selector);
			mTabHost.getTabWidget().setDividerDrawable(null);
		}
	}

	private View getTabItemView(int index) {
		View view = mLayoutInflater.inflate(R.layout.tab_item_view, null);

		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageArray[index]);

		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTextArray[index]);

		return view;
	}

}
