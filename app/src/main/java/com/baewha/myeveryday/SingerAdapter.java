package com.baewha.myeveryday;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class SingerAdapter extends BaseAdapter {
    private final ThirdActivity mainActivity;
    ArrayList<singeritem> items = new ArrayList<singeritem>();

    public SingerAdapter(ThirdActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void addItem(singeritem item) {
        items.add(item);
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        singeritemView view = new singeritemView(mainActivity.getApplicationContext());
        singeritem item = items.get(position);
        view.setName(item.getName());
        view.setMobile(item.getMobile());
        view.setClinic(item.getClinic());
        return view;
    }

}
