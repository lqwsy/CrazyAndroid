package com.gdou.bookstore;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-03-30.
 */

public class BookShelfFragment extends Fragment {

    private ListView lv_books;
    private SwipeRefreshLayout srl;
    private List<String> stringList;
    private ArrayAdapter lvAdapter;

    public BookShelfFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookshelf,container,false);
        ButterKnife.bind(this,view);
        lv_books = (ListView) view.findViewById(R.id.lv_books);
        srl = (SwipeRefreshLayout) view.findViewById(R.id.swip_refresh_layout);
        initData();
        return view;
    }

    private void initData(){
        stringList = new ArrayList<>();
        for(int i=0;i<20;i++){
            stringList.add(String.valueOf(i));
        }
        lvAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,stringList );
        lv_books.setAdapter(lvAdapter);

        //单击事件
        lv_books.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"点击行 "+stringList.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        //长按事件
        lv_books.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"长按行 "+stringList.get(position),Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        //初始化下拉控件颜色
        srl.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);

        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... voids) {
                        SystemClock.sleep(2000);
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        Toast.makeText(getActivity(), "下拉刷新成功", Toast.LENGTH_SHORT).show();
                        srl.setRefreshing(false);
                    }
                }.execute();
            }
        });

    }

}
