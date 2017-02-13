package com.example.administrator.xubotao1502h20170213.Fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.xubotao1502h20170213.Adater.ListMyAdater;
import com.example.administrator.xubotao1502h20170213.Bean.Bean;
import com.example.administrator.xubotao1502h20170213.R;
import com.example.administrator.xubotao1502h20170213.Uilt.HttpUrl;
import com.example.administrator.xubotao1502h20170213.Uilt.Shuilt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */

public class Massage_Fragment extends Fragment{
    private List<Bean> beanList=new ArrayList<>();
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_massage,null);
        //得到控件
        listView = (ListView) inflate.findViewById(R.id.listview);
        String path="http://v.juhe.cn/toutiao/index?type=guonei&key=a1e360288df07697f4514880f2c1ee12";
        new Task().execute(path);
        return inflate;
    }
    class  Task extends AsyncTask<String ,String ,String>
    {
        private ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(getActivity());
            dialog.setMessage("请稍后。。。。");
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String vaule = HttpUrl.httpUrl(params[0]);
            Log.d("zzz1", vaule);
            setJson(vaule);
            return vaule;
        }

        @Override
        protected void onPostExecute(String s) {
            dialog.dismiss();
            listView.setAdapter(new ListMyAdater(getActivity(),beanList));
        }

        public void setJson(String vaule) {
            JSONObject vauleObject = null;
            try {
                vauleObject = new JSONObject(vaule);
                JSONObject result = vauleObject.optJSONObject("result");
                Log.d("zzz2",result.toString());
                JSONArray data = result.optJSONArray("data");
                Log.d("zzz3",data.toString());
                String[] dataArr = new String[data.length()];
                for (int i=0;i<data.length();i++)
                {
                    dataArr[i]=data.optString(i);
                    JSONObject dataArrObject = new JSONObject(dataArr[i]);
                    String author_name = dataArrObject.optString("author_name");
                    String title = dataArrObject.optString("title");
                    String thumbnail_pic_s = dataArrObject.optString("thumbnail_pic_s");
                    Log.d("zzz4", author_name + "====" + title + "====" + thumbnail_pic_s);
                    Bean bean = new Bean(author_name, title, thumbnail_pic_s);
                    beanList.add(bean);
                    Log.d("zzz5", beanList.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
