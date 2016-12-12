package cn.dpcraft.sharebook;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by DPC on 2016/12/6.
 */
public class RequestFragment extends Fragment{
    public RequestFragment(){}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_request, container, false);
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Button buttonAdd = (Button)getActivity().findViewById(R.id.button_add);
        buttonAdd .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestUploadActivity.actionStart(getActivity(),"data1","data2");
            }
        });

    }
}
