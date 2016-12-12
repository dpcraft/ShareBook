package cn.dpcraft.sharebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by DPC on 2016/12/12.
 */
public class RequestUploadActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_upload);
    }
    public static void actionStart(Context context, String data1, String data2){
        Intent intent = new Intent(context,RequestUploadActivity.class);
        intent.putExtra("para1",data1);
        intent.putExtra("para2",data2);
        context.startActivity(intent);
    }
}
