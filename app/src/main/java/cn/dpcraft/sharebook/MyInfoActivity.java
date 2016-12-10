package cn.dpcraft.sharebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by DPC on 2016/12/10.
 */
public class MyInfoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        TextView textView = (TextView)findViewById(R.id.tv_tool_bar_title);
        textView.setText("个人信息");
    }
    public static void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context,MyInfoActivity.class);
        intent.putExtra("para1",data1);
        intent.putExtra("para2",data2);
        context.startActivity(intent);
    }
}
