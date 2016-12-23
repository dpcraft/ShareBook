package cn.dpcraft.sharebook;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends Activity implements BottomNavigationBar.OnTabSelectedListener{
    int lastSelectedPosition = 0;
    private BottomNavigationBar bottomNavigationBar;
    //private String TAG = BottomNavigationBarDemoActivity.class.getSimpleName();
    private FindFragment findFragment;
    private OutFragment outFragment;
    private RequestFragment requestFragment;
    private UserFragment userFragment;
    private int status =0;
    private static final int STOPSPLASH = 0;
    private static final long SPLASHTIME = 1000;
    private Animation animationGone,myAnimationAlpha;
    private LinearLayout splash;

    private Handler splashHandler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case  STOPSPLASH:
                    if(status == 0)
                    {
                        splash.startAnimation(animationGone);
                        splash.setVisibility(View.GONE);
                        break;
                    }
                    sendEmptyMessageDelayed(STOPSPLASH,SPLASHTIME);
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //hintKbOne();
        setContentView(R.layout.activity_main);
        findFragment = new FindFragment();
        outFragment = new OutFragment();
        requestFragment = new RequestFragment();
        userFragment = new UserFragment();
        assignViews();
        animationGone = AnimationUtils.loadAnimation(this,R.anim.alpha_gone);
        myAnimationAlpha = AnimationUtils.loadAnimation(this,R.anim.alpha_appear);
        splash = (LinearLayout) findViewById(R.id.splash_screen);
        splash.startAnimation(myAnimationAlpha);
        Message msg = new Message();
        msg.what = STOPSPLASH;
        splashHandler.sendMessageDelayed(msg,SPLASHTIME);

    }
    private void assignViews(){
        bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_menu_find,"找书").setActiveColor(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.ic_menu_out_off,"出书").setActiveColor(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_menu_req_on,"求书").setActiveColor(R.color.red))
                .addItem(new BottomNavigationItem(R.drawable.ic_menu_user_on,"我的").setActiveColor(R.color.white))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }
    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        findFragment = new FindFragment();
        transaction.replace(R.id.tabs, findFragment);
        transaction.commit();
        }
    @Override
    public void onTabSelected(int position){
        FragmentManager fm = this.getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        switch (position){
            case 0:
                transaction.replace(R.id.tabs,findFragment);
                break;
            case 1:
                transaction.replace(R.id.tabs,outFragment);
                break;
            case 2:
                transaction.replace(R.id.tabs,requestFragment);
                break;
            case 3:
                transaction.replace(R.id.tabs,userFragment);
            default:
                break;
        }
        transaction.commit();
    }
    @Override
    public void onTabUnselected(int position){}
    @Override
    public void onTabReselected(int position){}
  /*  @Override
    protected void onResume(){
        super.onResume();
        hintKbOne();
    }*/
    //关闭软键盘
    private void hintKbOne() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        // 得到InputMethodManager的实例
        if (imm.isActive()) {
            // 如果开启
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}
