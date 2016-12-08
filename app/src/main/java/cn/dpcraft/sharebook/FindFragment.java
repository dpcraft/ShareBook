package cn.dpcraft.sharebook;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DPC on 2016/12/6.
 */
public class FindFragment extends Fragment{
    private List<BookPreview> bookPreviewList = new ArrayList<BookPreview>();
    private  ListView listView;
    private BookAdapter bookAdapter;
    public FindFragment() {
        }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initBook();
        listView = (ListView) view.findViewById(R.id.find_list_view);
        listView.setAdapter(bookAdapter);
        return view;
        }
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        bookAdapter = new BookAdapter(activity,R.layout.book_preview_item,bookPreviewList);

    }
    private void initBook(){
        for(int i = 0;i < 10; i++){
            bookPreviewList.add(new BookPreview());
        }
    }
}
