package ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.myanmarhumanrights.R;

import java.util.List;

/**
 * Created by winhtaikaung on 11/4/15.
 */
public class ArticleGrid_Adapter extends BaseAdapter {


    Context mContext;
    LayoutInflater inflater;
    List<String> mTitle_list;

    public ArticleGrid_Adapter(Context c,List<String> title_list){
        this.mContext=c;
        inflater=(LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
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

            view.setTag(vh);
        }

        vh.tv_article.setTag(position);
        return null;
    }

    static class ViewHolder{
        TextView tv_article;
    }
}
