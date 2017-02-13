package com.example.administrator.xubotao1502h20170213.Adater;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.administrator.xubotao1502h20170213.Bean.Bean;
import com.example.administrator.xubotao1502h20170213.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */
public class ListMyAdater extends BaseAdapter {
    private final FragmentActivity activity;
    private final List<Bean> beanList;

    public ListMyAdater(FragmentActivity activity, List<Bean> beanList) {
        this.activity = activity;
        this.beanList = beanList;
    }
    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //MyView myView;
        //if(convertView!=null)
        //{
            convertView=View.inflate(activity, R.layout.listview,null);
            //myView = new MyView();
            TextView title=(TextView) convertView.findViewById(R.id.title);
            TextView author_name= (TextView) convertView.findViewById(R.id.author_name);
            ImageView img= (ImageView) convertView.findViewById(R.id.image);
            //convertView.setTag(myView);
       // }
        //else
        //{
       //     myView= (MyView) convertView.getTag();
       // }
        ImageLoader.getInstance().displayImage(beanList.get(position).getThumbnail_pic_s(),img);
        title.setText(beanList.get(position).getTitle());
        author_name.setText(beanList.get(position).getAuthor_name());
        return convertView;
    }
    /*class MyView
    {
        ImageView img;
        TextView Title;
        TextView author_name;
    }*/
}
