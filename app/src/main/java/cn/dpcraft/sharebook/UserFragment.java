package cn.dpcraft.sharebook;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
import java.util.Map;


/**
 * Created by DPC on 2016/12/6.
 */
public class UserFragment extends Fragment{
    private ListView listView; // 声明列表视图对象
    private List<Map<String, Object>> list;// 声明列表容器

    public UserFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Button buttonMyInfo =(Button) getActivity().findViewById(R.id.button_my_info);
        Button buttonMyMessage = (Button) getActivity().findViewById(R.id.button_my_message);
        Button buttonMyUpload = (Button) getActivity().findViewById(R.id.button_my_upload) ;
        Button buttonMyLike = (Button) getActivity().findViewById(R.id.button_my_like) ;
        Button buttonMyHistory = (Button) getActivity().findViewById(R.id.button_my_history) ;
        buttonMyInfo .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyInfoActivity.actionStart(getActivity(),"data1","data2");
                }
            });
        buttonMyMessage .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyMessageActivity.actionStart(getActivity(),"data1","data2");
            }
        });
        buttonMyUpload .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyUploadActivity.actionStart(getActivity(),"data1","data2");
            }
        });
        buttonMyLike .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyLikeActivity.actionStart(getActivity(),"data1","data2");
            }
        });
        buttonMyHistory .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyHistoryActivity.actionStart(getActivity(),"data1","data2");
            }
        });
    }
}
