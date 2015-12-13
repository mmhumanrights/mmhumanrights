package ui.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myanmarhumanrights.R;

import java.util.List;

import comm.Com_Utils;

/**
 * Created by winhtaikaung on 11/4/15.
 */
public class ArticleGridAdapter extends BaseAdapter {


    Context mContext;
    LayoutInflater inflater;
    List<String> mTitle_list;
    String[] arr_material_array;
    Com_Utils com_utils=new Com_Utils();

    public ArticleGridAdapter(Context c, List<String> title_list){
        this.mContext=c;
        this.inflater=(LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        this.arr_material_array=mContext.getResources().getStringArray(R.array.material_colors_array);
        this.mTitle_list=title_list;

    }

    @Override
    public int getCount() {
        return mTitle_list.size();
    }

    @Override
    public Object getItem(int position) {
        return mTitle_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder vh;
        if(view !=null){
            vh=(ViewHolder)view.getTag();
        }else{
            vh=new ViewHolder();
            view=inflater.inflate(R.layout.griditem_article,parent,false);
            vh.tv_article=(TextView)view.findViewById(R.id.tv_article);
            vh.grid_item_root_layout=(RelativeLayout)view.findViewById(R.id.grid_item_root_layout);

            view.setTag(vh);
        }

        vh.tv_article.setTag(position);

        vh.tv_article.setText(mTitle_list.get(position));



        String ran_color=arr_material_array[com_utils.getRandomnum(arr_material_array.length,0)];
        /*int ran_color_hex = Integer.parseInt(ran_color.replaceFirst("#",""), 16);
        Log.w("COLOR_CODES", String.valueOf(ran_color_hex));*/
        vh.grid_item_root_layout.setBackgroundColor(Color.parseColor(ran_color));
        vh.tv_article.setTextColor(Color.parseColor("#FFFFFF"));




        return view;
    }

    static class ViewHolder{
        TextView tv_article;
        RelativeLayout grid_item_root_layout;
    }
}
