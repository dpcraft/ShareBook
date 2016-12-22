package cn.dpcraft.sharebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by DPC on 2016/12/11.
 */
public class SearchActivity extends Activity {

    private Spinner dealTypeSpinner = null;
    private Spinner orderSpinner = null;
    ArrayAdapter<String> dealTypeAdapter = null;
    ArrayAdapter<String> orderAdapter = null;

    private String[] dealType = new String[]{"全部","仅出售","仅出租"};
    private String[][] order = new String[][]{{"综合","价格从低到高","价格从高到低","成色优先"},
            {"综合","价格从低到高","价格从高到低","成色优先"},
            {"综合","日期从长到短","日期从短到长","成色优先"}};


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setSpinner();
        EditText etSearch = (EditText)findViewById(R.id.et_search);
        Button buttonSearch = (Button)findViewById(R.id.button_search);
        Button buttonBack = (Button)findViewById(R.id.button_back) ;
        Button buttonFiltration = (Button)findViewById(R.id.button_filtration);
        buttonSearch .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SearchActivity.this,"你点击了搜索",Toast.LENGTH_SHORT).show();
                hintKbOne();
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
        dealTypeAdapter = new ArrayAdapter<String>(SearchActivity.this,R.layout.support_simple_spinner_dropdown_item,dealType);
        dealTypeSpinner.setAdapter(dealTypeAdapter);
        dealTypeSpinner.setSelection(0,true);
        orderAdapter = new ArrayAdapter<String>(SearchActivity.this,R.layout.support_simple_spinner_dropdown_item,order[0]);
        orderSpinner.setAdapter(orderAdapter);
        orderSpinner.setSelection(0,true);

       /* dealTypeSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemSelected(AdapterView<?> arg0,View arg1,int position,long args3){
                orderAdapter = new ArrayAdapter<String>(SearchActivity.this,R.layout.search_spinner_item,order[position]);
                orderSpinner.setAdapter(orderAdapter);
            }
        });*/
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
}