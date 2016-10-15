package com.pashley.mylibrary.utils;


import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * 屏幕工具类
 * 
 * @author Jeff
 * @date 2014-8-31
 * @version 1.0
 */
public class DisplayUtils {

	private static DisplayUtils instance;
	private Activity mActivity;
	private DisplayUtils(Activity mActivity){
		this.mActivity=mActivity;
	}
	public static DisplayUtils getInstance(Activity mActivity){
		if(instance==null){
			instance=new DisplayUtils(mActivity);
		}
		return instance;
	}

	public final static int getWindowWidth(Activity mActivity) {
		DisplayMetrics dm = new DisplayMetrics();
		mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.widthPixels;
	}

	public final static int getWindowHeight(Activity mActivity) {
		DisplayMetrics dm = new DisplayMetrics();
		mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.heightPixels;
	}
}
