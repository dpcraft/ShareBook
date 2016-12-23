package cn.dpcraft.sharebook;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by DPC on 2016/12/6.
 */
public class FindFragment extends Fragment{
    private DrawerLayout filtrationDrawerLayout;
    private ListView listView; // 声明列表视图对象
    private List<BookPreview> bookPreviewList = new ArrayList<BookPreview>();
    private  ListView bookListView;
    private BookAdapter bookAdapter;
    //private float alpha = 0.4f;
    public FindFragment() {}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initBook();
        bookListView = (ListView) view.findViewById(R.id.find_list_view);
        bookListView.setAdapter(bookAdapter);
        return view;
        }
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        bookAdapter = new BookAdapter(activity,R.layout.book_preview_item,bookPreviewList);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initFiltrationDrawer();
        filtrationDrawerLayout = (DrawerLayout) getActivity().findViewById(R.id.find_page_drawer_layout);
        filtrationDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        filtrationDrawerLayout.setScrimColor(0x00000000);
       // filtrationDrawerLayout.setAlpha(alpha);

        Button buttonFiltration = (Button) getActivity().findViewById(R.id.button_filtration);
        Button buttonSearchEdit = (Button)getActivity().findViewById(R.id.button_search_edit);
        buttonFiltration .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               filtrationDrawerLayout.openDrawer(Gravity.RIGHT);
            }
        });
        buttonSearchEdit .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchActivity.actionStart(getActivity(),"data1","data2");
            }
        });

    }
    private void initBook(){
        for(int i = 0;i < 10; i++){
            bookPreviewList.add(new BookPreview());
        }
    }
    public void initFiltrationDrawer()
    {
        listView = (ListView)getActivity().findViewById(R.id.find_page_filtration_list);
        ArrayList<ListItem> list_GroupItem = new ArrayList<ListItem>();
        UniversalAdapter mAdapter_ListGroup = new UniversalAdapter(getActivity(), list_GroupItem);
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
