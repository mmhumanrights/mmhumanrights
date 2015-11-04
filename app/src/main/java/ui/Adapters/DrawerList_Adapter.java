package ui.Adapters;

/**
 * Created by winhtaikaung on 9/30/15.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myanmarhumanrights.R;


/**
 * Created by jr on 5/31/15.
 */
public class DrawerList_Adapter extends BaseAdapter {
    String[] listitem=null;
    int[] listicon=null;
    Context mContext;
    LayoutInflater inflater;

    public DrawerList_Adapter(Context _context, String[] _listitem, int[] _listicon){
        super();
        mContext=_context;

        inflater=(LayoutInflater)mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        this.listitem=_listitem;
        this.listicon=_listicon;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView!=null){
            vh=(ViewHolder) convertView.getTag();
        }else{
            vh=new ViewHolder();
            convertView=inflater.inflate(R.layout.drawer_listitem,null);
            convertView.setTag(vh);
            vh.tv_itemtext=(TextView) convertView.findViewById(R.id.tv_drawerlist_item);
            vh.iv_icon=(ImageView) convertView.findViewById(R.id.iv_drawerlist_item);
        }


        vh.tv_itemtext.setText(listitem[position]);
        // vh.iv_icon.setImageResource(listicon[position]);


        return convertView;
    }


    @Override
    public int getCount() {
        return listitem.length;
    }

    @Override
    public String getItem(int position) {
        return listitem[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        TextView tv_itemtext;
        ImageView iv_icon;


    }
}

