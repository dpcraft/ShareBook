package cn.dpcraft.sharebook;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by DPC on 2016/12/10.
 */
public class UserSubToolbar extends LinearLayout {
    public UserSubToolbar(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.include_user_sub_toolbar,this);
        Button buttonTitileBack = (Button)findViewById(R.id.tool_bar_button_back);
        buttonTitileBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });
    }
}
