package com.develop.shopapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ProductsAdapter extends BaseAdapter /*extends ArrayAdapter<ProductDto>*/ {
    private final Context mContext;

    ProductDto productDto1 = new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000);
    ProductDto productDto2 = new ProductDto(1, "Apple iPhone 8", "Mobile_phone", 40000);
    ProductDto productDto3 = new ProductDto(1, "Apple iPhone XR", "Mobile_phone", 50000);
    ProductDto productDto4 = new ProductDto(1, "Apple iPhone 12", "Mobile_phone", 90000);
    ProductDto[] productDtos = new ProductDto[]{productDto1, productDto2, productDto3, productDto4};

    public ProductsAdapter(Context c) {
        this.mContext = c;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        TextView dummyTextView = new TextView(mContext);
        dummyTextView.setText(String.valueOf(position));
        return dummyTextView;
    }

    @Override
    public int getCount() {
        return this.productDtos.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public ProductDto getItem(int position) {
        //return productDtos[position];
        return null;
    }

}
