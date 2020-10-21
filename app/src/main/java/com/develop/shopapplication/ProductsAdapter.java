package com.develop.shopapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ProductsAdapter /*extends ArrayAdapter<String>*/extends BaseAdapter {
    private Context context;

    private static final String[] mContacts = { "Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Полосатик", "Матроскин", "Лизка", "Томосина",
            "Бегемот", "Чеширский", "Дивуар", "Тигра", "Лаура" };

    ProductDto productDto1 = new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000);
    ProductDto productDto2 = new ProductDto(1, "Apple iPhone 8", "Mobile_phone", 40000);
    ProductDto productDto3 = new ProductDto(1, "Apple iPhone XR", "Mobile_phone", 50000);
    ProductDto productDto4 = new ProductDto(1, "Apple iPhone 12", "Mobile_phone", 90000);
    ProductDto[] productDtos = new ProductDto[]{productDto1, productDto2, productDto3, productDto4};

    public ProductsAdapter(Context c){
        this.context = c;
    }

    /*public ProductsAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }*/

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        /*ImageView imageView = new ImageView(context);
        imageView.setImageResource(productDtos[position].hashCode());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new GridView.LayoutParams(240,240));
        return imageView;*/

        TextView label = (TextView) convertView;

        if (convertView == null) {
            convertView = new TextView(context);
            label = (TextView) convertView;
        }

        label.setText(mContacts[position]);
        return convertView;
    }

    @Override
    public int getCount() {
        return this.productDtos.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public String getItem(int position) {
        return mContacts[position];
    }


}
