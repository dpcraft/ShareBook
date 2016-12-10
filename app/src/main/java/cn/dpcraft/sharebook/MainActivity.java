package cn.dpcraft.sharebook;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        assignViews();

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
        findFragment = new FindFragment();
        outFragment = new OutFragment();
        userFragment = new UserFragment();
        switch (position){
            case 0:
                transaction.replace(R.id.tabs,findFragment);
                break;
            case 1:
                transaction.replace(R.id.tabs,outFragment);
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
}
