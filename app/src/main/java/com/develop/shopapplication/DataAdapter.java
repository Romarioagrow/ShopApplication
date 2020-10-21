package com.develop.shopapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class DataAdapter extends ArrayAdapter<String> {

    private static final String[] mContacts = { "Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Полосатик", "Матроскин", "Лизка", "Томосина",
            "Бегемот", "Чеширский", "Дивуар", "Тигра", "Лаура" };

    Context mContext;

    public DataAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) convertView;

        if (convertView == null) {
            convertView = new TextView(mContext);
            label = (TextView) convertView;
        }

        label.setText(mContacts[position]);
        return (convertView);
    }

    public String getItem(int position) {
        return mContacts[position];
    }



}
