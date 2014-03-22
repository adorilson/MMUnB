package br.unb.mobileMedia.util;

import android.os.Build;

public interface MMConstants {

	String TAG = "MMUnB";
	
	String DATA_FORMAT = "yyyyMMddhhmmss";
	
	public final static int SIMPLE_LIST_ITEM_LAYOUT = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
            android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
}
