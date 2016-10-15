package com.pashley.api.listener;

import com.android.volley.Response;

/**
 * Created by Pashley on 2016/10/7.
 */

public interface VolleyResponseListener<T> extends Response.ErrorListener,Response.Listener<T> {
}
