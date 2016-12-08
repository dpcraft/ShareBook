package cn.dpcraft.sharebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DPC on 2016/12/8.
 */
public class BookAdapter extends ArrayAdapter<BookPreview>{
    private int resourceId;
    public BookAdapter(Context context,int textViewResourceId,List<BookPreview> objects){
        super(context,textViewResourceId,objects);
        resourceId =textViewResourceId;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        BookPreview bookPreview = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        }else{
            view = convertView;
        }
        ImageView previewBookImage = (ImageView) view.findViewById(R.id.book_preview_image);
        TextView previewBookName = (TextView) view.findViewById(R.id.tv_preview_book_name);
        TextView previewBookAuthor = (TextView) view.findViewById(R.id.tv_preview_book_author);
        TextView previewBookPublishingHouse = (TextView) view.findViewById(R.id.tv_preview_book_publishing_house);
        TextView previewBookPrice = (TextView) view.findViewById(R.id.tv_preview_book_price);
        previewBookImage.setImageResource(bookPreview.getImageid());
        previewBookName.setText(bookPreview.getName());
        previewBookAuthor.setText(bookPreview.getAuthor());
        previewBookPublishingHouse.setText(bookPreview.getPublishingHouse());
        previewBookPrice.setText(bookPreview.getPrice());
        return view;


    }
}
