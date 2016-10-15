package com.pashley.mylibrary.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityStackControlUtils
{
	private static List<Activity> activityList = new ArrayList<Activity>();

	public static void remove(Activity activity) {
		activityList.remove(activity);
	}

	public static void add(Activity activity) {
		activityList.add(activity);
	}

	public static void finishProgram() {
		for (Activity activity : activityList) {
			activity.finish();
		}
		android.os.Process.killProcess(android.os.Process.myPid());
	}

	public static void coloseActiviy() {
		for (Activity activity : activityList) {
			activity.finish();
		}
	}

	public static void RemoverObj(Activity obj) {
		for (Activity activity : activityList) {
			if (activity == obj)
				activity.finish();
		}
	}
}
