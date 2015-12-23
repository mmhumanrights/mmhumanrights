package ui.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myanmarhumanrights.R;

import comm.Com_Utils;
import models.Article;

/**
 * Created by winhtaikaung on 12/23/15.
 */
public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder> {

    Article[] arr_articles;
    Context mContext;
    String[] arr_material_array;
    ArticleItemclickHandler mClickHandler;
    Com_Utils com_utils=new Com_Utils();

    public ArticleListAdapter (Context _context,Article[] _arr_articles,ArticleItemclickHandler _handler) {
        this.arr_articles=_arr_articles;
        this.mContext =_context;
        this.mClickHandler=_handler;
        this.arr_material_array=mContext.getResources().getStringArray(R.array.material_colors_array);
    }

    public static interface ArticleItemclickHandler {
        void onItemClickListener(int AdapterPosition, Article selectedArticle, ArticleViewHolder vh);
    }



        @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.
                from(parent.getContext()).inflate(R.layout.griditem_article,parent,false);
        return new ArticleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        Article a=arr_articles[position];
        holder.tv_article.setText(a.getArticletitle());
        holder.tv_definition.setText(a.getArticledefinition());

        /*String ran_color=arr_material_array[com_utils.getRandomnum(arr_material_array.length,0)];
        int ran_color_hex = Integer.parseInt(ran_color.replaceFirst("#",""), 16);
        Log.w("COLOR_CODES", String.valueOf(ran_color_hex));
        holder.grid_item_root_layout.setBackgroundColor(Color.parseColor(ran_color));*/
        holder.tv_article.setTextColor(Color.parseColor("#000000"));
    }

    @Override
    public int getItemCount() {
        return arr_articles.length;
    }


    public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_article;
        TextView tv_definition;
        RelativeLayout grid_item_root_layout;

        public ArticleViewHolder(View itemview){
            super(itemview);
            tv_article=(TextView) itemview.findViewById(R.id.tv_article);
            tv_definition=(TextView) itemview.findViewById(R.id.tv_definition);
            grid_item_root_layout=(RelativeLayout)itemview.findViewById(R.id.grid_item_root_layout);

            grid_item_root_layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v instanceof RelativeLayout){
                int pos=getAdapterPosition();
                Article article=arr_articles[pos];
                mClickHandler.onItemClickListener(pos,article,this);
            }
        }
    }
}

