package com.pashley.api.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.pashley.api.http.PostUploadRequest;
import com.pashley.api.http.RequestManager;
import com.pashley.api.listener.ResponseListener;
import com.pashley.api.listener.VolleyResponseListener;
import com.pashley.model.AppInfo;
import com.pashley.model.Page;
import com.pashley.model.RequestResult;
import com.pashley.mylibrary.constant.ErrorEvent;
import com.pashley.mylibrary.utils.StringUtils;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Pashley on 2016/10/7.
 */

public class HttpRequest {
    protected static final String TAG = "HttpRequest";
    private static HttpRequest instance;
    private Context context;
    private static AppInfo appInfo;
    public static final int SOCKET_TIMEOUT_MS = 10 * 1000;
    private HttpRequest(Context context) {
        this.context = context;
    }
    public static HttpRequest getInstance(Context context) {
        if (instance == null) {
            RequestManager.init(context);
            instance = new HttpRequest(context);
        }
        return instance;
    }

    public void initialize(Context context) {
        getInstance(context);
    }
    public AppInfo getAppInfo() {
        if (appInfo == null) {
            appInfo = new AppInfo();
            try {
                PackageManager manager = context.getPackageManager();
                PackageInfo info = manager.getPackageInfo(context.getPackageName(),
                        PackageManager.GET_CONFIGURATIONS | PackageManager.GET_META_DATA);
//                Object channel = info.applicationInfo.metaData.get("UMENG_CHANNEL");
//                if (channel != null) {
//                    appInfo.setChannel(channel.toString());
//                }
                appInfo.setOsInfo(Build.VERSION.RELEASE);
                appInfo.setAppId("1");
                appInfo.setVersionCode(info.versionCode);
                appInfo.setVersionName(info.versionName);
                appInfo.setPlatform(1);
                initUrl();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return appInfo;
    }

    private void initUrl() {
        getAppInfo().setServerIp("http://apis.yhiker.com");
        getAppInfo().setApiPath("http://121.41.101.63:8088/dmtm-api-1.0");
        getAppInfo().setH5Path("http://goeasy.yhiker.com");
        getAppInfo().setOpsPath("http://igoeasyops.yhiker.com");
    }
    public void post(String baseUrl, Map<String, Object> params, ResponseListener listener) {
        AppInfo appInfo = getAppInfo();
        String url = getAppInfo().getApiPath() + "/" + baseUrl;
        request(Request.Method.POST, url, baseUrl, false, params, listener);
    }
    public void get(String baseUrl, Map<String, Object> params, ResponseListener listener) {
        String url = getAppInfo().getApiPath() + "/" + baseUrl;
        request(Request.Method.GET, url, baseUrl, false, params, listener);
    }
    public void post(String baseUrl, boolean isGetCache, Map<String, Object> params, ResponseListener listener) {
        String url = getAppInfo().getApiPath() + "/" + baseUrl;
        request(Request.Method.POST, url, baseUrl, isGetCache, params, listener);
    }
    public void get(String baseUrl, boolean isGetCache, Map<String, Object> params, ResponseListener listener) {
        String url = getAppInfo().getApiPath() + "/" + baseUrl;
        request(Request.Method.GET, url, baseUrl, isGetCache, params, listener);
    }
    public void postUpload(String baseUrl, List<String> list, ResponseListener responseHandler) {
        String url = getAppInfo().getOpsPath() + "/" + baseUrl;
        requestUpload(url, list, responseHandler);
    }

    private void request(int method, String url, final String baseUrl, final boolean isCache,
                         final Map<String, Object> params, final ResponseListener listener) {
        Log.d(TAG, "HttpRequest: " + url);
        StringRequest request = new StringRequest(method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String responseBody) {
                parseResult(responseBody, listener);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse( VolleyError error) {
                Log.e(TAG, "[HttpRequest] " + error.toString());
                if (isCache) {
                    try {
                        String responseBody = getCache(baseUrl);
                        parseResult(responseBody, listener);
                    } catch (Exception e) {
                        e.printStackTrace();
                        listener.onFailure(ErrorEvent.SERVER_ERROR, error);
                    }
                } else {
                    listener.onFailure(ErrorEvent.SERVER_ERROR, error);
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // 在这里设置需要post的参数
//                params.put("APP_ID", getAppInfo().getAppId());
                params.put("version", getAppInfo().getVersionName());
//                params.put("versionCode", getAppInfo().getVersionCode());
                params.put("platform", getAppInfo().getPlatform());
//                params.put("channel", getAppInfo().getChannel());
//                params.put("package", "com.pashley.damo");
                Map<String, String> _params = new HashMap<>();
                Set<String> keys=params.keySet();
                if(keys!=null) {
                    Iterator<String> iterator = keys.iterator();
                    while(iterator.hasNext( )) {
                        String key = iterator.next();
                        if(params.get(key)!=null) {
                            String value = params.get(key).toString();
                            _params.put(key, value);
                        }
                    }
                }
                Log.i(TAG, "[HttpRequest] " + String.valueOf(_params));
                return _params;
            }
        };
        request.setTag(url);
        request.setRetryPolicy(new DefaultRetryPolicy(
                SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestManager.getRequestQueue().add(request);
    }

    private void requestUpload(String url, List<String> list, final ResponseListener responseHandler) {
        PostUploadRequest request = new PostUploadRequest(url, list, new VolleyResponseListener<String>() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
                responseHandler.onFailure(ErrorEvent.SERVER_ERROR, error);
            }

            @Override
            public void onResponse(String responseBody) {
                parseResult(responseBody, responseHandler);
            }
        });
        RequestManager.getRequestQueue().add(request);
    };

    /**
     * 根据接口名称获取对应缓存数据
     *
     * @param baseUrl
     * @return
     * @throws UnsupportedEncodingException
     */
    protected String getCache(String baseUrl) throws UnsupportedEncodingException {
        String url = Request.Method.POST + ":" + getAppInfo().getApiPath() + "/" + baseUrl;
        Cache cache = RequestManager.getRequestQueue().getCache();
        Cache.Entry entry = cache.get(url);
        String data = null;
        if (entry != null) {
            data = new String(entry.data, "Utf-8");
        }
        return data;
    }
    private void parseResult(String responseBody, ResponseListener listener) {
        try {
            Log.i(TAG, "[HttpRequest] " + responseBody);
            RequestResult result = new RequestResult();
            if (!StringUtils.isBlank(responseBody)) {
                JSONObject response = new JSONObject(responseBody);
                if (!response.isNull("code")) {
                    int code = response.getInt("code");
                    result.setCode(response.getInt("code"));
                    result.setSuccess(code == 0);
                    result.setResult(response.isNull("result") ? null : response.get("result"));
                } else if (!response.isNull("status")) {
                    result.setStatus(response.getInt("status"));
                    result.setSuccess(response.getInt("status") == 1);
                    result.setResult(response.isNull("data") ? null : response.get("data"));
                }
                result.setMsg(response.isNull("msg") ? null : response.getString("msg"));

                //判断是否有分页数据
                if (!response.isNull("page")) {
                    JSONObject jsonObjectPage = response.getJSONObject("page");
                    Page page = new Page();
                    page.setNow(jsonObjectPage.getString("now"));
                    page.setPageNo(jsonObjectPage.getInt("pageNo"));
                    page.setPageSize(jsonObjectPage.getInt("pageSize"));
                    page.setTotalCount(jsonObjectPage.getInt("totalCount"));
                    page.setTotalPage(jsonObjectPage.getInt("totalPage"));
                    result.setPage(page);
                }
            }
            listener.onSuccess(result);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "[HttpRequest] " + e.toString());
            listener.onFailure(ErrorEvent.SERVER_DATA_EXCEPTION, e);
        }
    }
}
