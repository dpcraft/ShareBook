package cn.dpcraft.sharebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchActivity extends Activity {

    private DrawerLayout filtrationDrawerLayout;
    private ListView listView; // 声明列表视图对象
    private Spinner dealTypeSpinner = null;
    private Spinner orderSpinner = null;
    ArrayAdapter<String> dealTypeAdapter = null;
    ArrayAdapter<String> orderAdapter = null;
    LinearLayout linSpinner;

    private String[] dealType = new String[]{"全部","仅出售","仅出租"};
    private String[][] order = new String[][]{{"综合","价格从低到高","价格从高到低","成色优先"},
            {"综合","价格从低到高","价格从高到低","成色优先"},
            {"综合","日期从长到短","日期从短到长","成色优先"}};


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setSpinner();
        initFiltrationDrawer();
        filtrationDrawerLayout = (DrawerLayout) findViewById(R.id.search_drawer_layout);
        filtrationDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        filtrationDrawerLayout.setScrimColor(0x00000000);
        // filtrationDrawerLayout.setAlpha(alpha);
        Button buttonFiltration = (Button) findViewById(R.id.button_filtration_spin);

        EditText etSearch = (EditText)findViewById(R.id.et_search);
        Button buttonSearch = (Button)findViewById(R.id.button_search);
        Button buttonBack = (Button)findViewById(R.id.button_back) ;
        linSpinner= (LinearLayout)findViewById(R.id.ll_spinner) ;
        linSpinner.setVisibility(View.GONE);
        buttonSearch .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SearchActivity.this,"你点击了搜索",Toast.LENGTH_SHORT).show();
                hintKbOne();
                linSpinner.setVisibility(View.VISIBLE);
            }
        });
        buttonFiltration .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtrationDrawerLayout.openDrawer(Gravity.RIGHT);
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                hintKbOne();
            }
        });
    }
    public static void actionStart(Context context, String data1, String data2){
        Intent intent = new Intent(context,SearchActivity.class);
        intent.putExtra("para1",data1);
        intent.putExtra("para2",data2);
        context.startActivity(intent);
    }

    private void setSpinner(){
        dealTypeSpinner = (Spinner)findViewById(R.id.spin_deal_type);
        orderSpinner = (Spinner)findViewById(R.id.spin_order);
        dealTypeAdapter = new ArrayAdapter<String>(SearchActivity.this,R.layout.custom_spinner_style,dealType);
        dealTypeAdapter.setDropDownViewResource(R.layout.custom_spinner_drop_style);
        dealTypeSpinner.setAdapter(dealTypeAdapter);
        dealTypeSpinner.setSelection(0,true);
        orderAdapter = new ArrayAdapter<String>(SearchActivity.this,R.layout.custom_spinner_style,order[0]);
        orderAdapter.setDropDownViewResource(R.layout.custom_spinner_drop_style);
        orderSpinner.setAdapter(orderAdapter);
        orderSpinner.setSelection(0,true);


       dealTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> arg0,View arg1,int position,long args3){
                orderAdapter = new ArrayAdapter<String>(SearchActivity.this,R.layout.custom_spinner_style,order[position]);

                orderSpinner.setAdapter(orderAdapter);
                orderAdapter.setDropDownViewResource(R.layout.custom_spinner_drop_style);
            }
           @Override
           public void onNothingSelected(AdapterView<?> args0){}
        });
    }


    //关闭软键盘
    private void hintKbOne() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
    // 得到InputMethodManager的实例
        if (imm.isActive()) {
            // 如果开启
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
    private void initFiltrationDrawer()
    {
        listView = (ListView)findViewById(R.id.search_filtration_list                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          );
        ArrayList<ListItem> list_GroupItem = new ArrayList<ListItem>();
        UniversalAdapter mAdapter_ListGroup = new UniversalAdapter(SearchActivity.this, list_GroupItem);
        mAdapter_ListGroup.AddType(R.layout.price_item);
        mAdapter_ListGroup.AddType(R.layout.deal_type_item);
        mAdapter_ListGroup.AddType(R.layout.book_type_title_item);
        mAdapter_ListGroup.AddType(R.layout.book_type_item);
        mAdapter_ListGroup.AddType(R.layout.drawer_button_item);
        listView.setAdapter(mAdapter_ListGroup);
        list_GroupItem.add(new ListItem(0, getHashMap0()));
        list_GroupItem.add(new ListItem(1, getHashMap0()));
        list_GroupItem.add(new ListItem(2, getHashMap0()));
        list_GroupItem.add(new ListItem(3, getHashMap3("文学艺术")));
        list_GroupItem.add(new ListItem(3, getHashMap3("人文社科")));
        list_GroupItem.add(new ListItem(3, getHashMap3("经济管理")));
        list_GroupItem.add(new ListItem(3, getHashMap3("生活休闲")));
        list_GroupItem.add(new ListItem(3, getHashMap3("外语学习")));
        list_GroupItem.add(new ListItem(3, getHashMap3("自然科学")));
        list_GroupItem.add(new ListItem(3, getHashMap3("考试教育")));
        list_GroupItem.add(new ListItem(3, getHashMap3("计算机")));
        list_GroupItem.add(new ListItem(3, getHashMap3("医学")));
        list_GroupItem.add(new ListItem(4, getHashMap0()));


        mAdapter_ListGroup.notifyDataSetChanged();
    }


    private HashMap<Integer, Object> getHashMap0() {
        HashMap<Integer, Object> map1 = new HashMap<Integer, Object>();
        return map1;
    }
    private HashMap<Integer, Object> getHashMap3(String s) {
        HashMap<Integer, Object> map1 = new HashMap<Integer, Object>();
        map1.put(R.id.tv_book_type, s);
        return map1;
    }

}