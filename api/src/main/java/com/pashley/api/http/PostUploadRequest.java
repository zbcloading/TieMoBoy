package com.pashley.api.http;

import android.graphics.Bitmap;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.pashley.api.listener.VolleyResponseListener;
import com.pashley.api.utils.Bimp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Pashley on 2015/10/10.
 */
public class PostUploadRequest extends Request<String> {
    /**
     * 正确数据的时候回掉用
     */
    private VolleyResponseListener mListener ;

    /*请求 数据通过参数的形式传入*/
    private List<String> mListItem ;

//    private String BOUNDARY = "--------------520-13-14"; //数据分隔线
    private String MULTIPART_FORM_DATA = "multipart/form-data";

    String end = "\r\n";
    String twoHyphens = "--";
    String boundary = "--------boundary";

    public PostUploadRequest(String url, List<String> listItem, VolleyResponseListener listener) {
        super(Method.POST, url, listener);
        this.mListener = listener ;
        setShouldCache(false);
        mListItem = listItem ;
        //设置请求的响应事件，因为文件上传需要较长的时间，所以在这里加大了，设为5秒
        setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

    /**
     * 这里开始解析数据
     * @param response Response from the network
     * @return
     */
    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        try {
            String mString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(mString, HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(String response) {
        mListener.onResponse(response);
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        if (mListItem == null||mListItem.size() == 0){
            return super.getBody() ;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream() ;
        int N = mListItem.size() ;
        String filePath;
        for (int i = 0; i < N ;i++){
            filePath = mListItem.get(i) ;
            int endFileIndex = filePath.lastIndexOf("/");
            String fileName = filePath.substring(endFileIndex + 1);
            // set 头部
            StringBuilder sb = new StringBuilder();

            sb.append(twoHyphens);
            sb.append(boundary);
            sb.append(end);
            sb.append("Content-Disposition: form-data; ");
            sb.append("name=" + "\"" + "img[]" + "\"");
            sb.append(";filename=");
            sb.append("\"" + fileName + "\"");
            sb.append(end);

            sb.append("Content-Type: ");
            sb.append("image/jpeg");
            sb.append(end);
            sb.append(end);
            try {
                bos.write(sb.toString().getBytes("utf-8"));
                /*第五行*/
                bos.write(getVaules(filePath));
                bos.write("\r\n".getBytes("utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        /*结尾行*/
          String endLine =twoHyphens + boundary + end;
        try {
            bos.write(endLine.toString().getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }

    @Override
    public String getBodyContentType() {
        return MULTIPART_FORM_DATA+"; boundary="+boundary;
    }

    public byte[] getVaules(String path){
        Bitmap bitmap= null;
        try {
            bitmap = Bimp.revitionImageSize(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bitmap==null){
            return null;
        }

        return Bitmap2Bytes(bitmap);
    }
    public byte[] Bitmap2Bytes(Bitmap bm) {
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
         return baos.toByteArray();
     }
}
