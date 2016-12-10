package cn.dpcraft.sharebook;
import java.util.HashMap;
import java.util.Map;
/** ListView中的列表项
 * Created by DPC on 2016/12/10.
 */
public class ListItem {
    /**类型*/
    public int mType;
    /**键值对应Map*/
    public Map<Integer, ?> mMap ;
    public ListItem(int type, HashMap<Integer, ?> map)
    {
        mType = type;
        mMap = map;
    }
}

