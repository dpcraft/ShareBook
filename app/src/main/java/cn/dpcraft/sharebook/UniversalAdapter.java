package cn.dpcraft.sharebook;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by DPC on 2016/12/10.
 */
public class UniversalAdapter extends BaseAdapter{
    private List<ListItem> mData;
    private LayoutInflater mInflater;
    private ArrayList<Integer> TypeList = new ArrayList<Integer>();

    public void AddType(int mResource)
    {
        TypeList.add(mResource);
    }


    public UniversalAdapter(Context context, List<ListItem> data)
    {
        mData = data;
        mInflater = LayoutInflater.from(context);
//		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getItemViewType(int position) {
        return mData.get(position).mType;
    }

    @Override
    public int getViewTypeCount() {
        if(TypeList.size()==0)
            return 1;
        else
            return TypeList.size();
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return mData.size();
    }

    public ListItem getItem(int position) {
        // TODO Auto-generated method stub
        return mData.get(position);
//		return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ViewHolder holder = null;
        int type = getItemViewType(position);

        if (convertView == null)
        {
            holder = new ViewHolder();
            ListItem item = getItem(position);
            convertView = mInflater.inflate(TypeList.get(type), null);
//            convertView = mInflater.inflate(type,parent,false);
            for (Iterator<Integer> it = item.mMap.keySet().iterator(); it.hasNext();)
            {	// 遍历
                int id = it.next();
                Object obj = convertView.findViewById(id);
                if(obj!=null)
                {
                    holder.List_Object.add(obj);
                    holder.List_id.add(id);
                }
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.SetValue(mData.get(position));
        return convertView;
    }


    public static class ViewHolder
    {
        ArrayList<Object> List_Object = new ArrayList<Object>();
        ArrayList<Integer> List_id = new ArrayList<Integer>();

        public boolean SetValue(ListItem item)
        {
            int i = 0;
            Object oV;
            for(Object obj:List_Object)
            {
//				try
                {
                    int id = List_id.get(i);
                    oV = item.mMap.get(id);

                    if(obj.getClass().equals(TextView.class))
                    {
                        ((TextView)obj).setText(oV.toString());
                    }

                    if(obj.getClass().equals(ImageView.class))
                    {
                        if(oV.getClass().equals(Integer.class))
                        {
                            ((ImageView)obj).setImageResource((Integer)oV);
                        }
                    }

                    if(obj.getClass().equals(ImageButton.class))
                    {
                        if(oV.getClass().equals(Integer.class))
                        {
                            ((ImageButton)obj).setImageResource((Integer)oV);
                        }

                        if(oV.getClass().equals(View.OnClickListener.class))
                        {
                            ((ImageButton)obj).setOnClickListener((View.OnClickListener)oV);
                        }
                    }
//				}catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
                }

                i++;
            }
            return false;
        }
    }



}
