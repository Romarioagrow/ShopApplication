package com.develop.shopapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

public class ProductsAdapter extends BaseAdapter /*extends ArrayAdapter<ProductDto>*/ {
    private final Context mContext;

    List<ProductDto> productsList = Arrays.asList(
            new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000),
            new ProductDto(1, "Apple iPhone 8", "Mobile_phone", 40000),
            new ProductDto(1, "Apple iPhone XR", "Mobile_phone", 50000),
            new ProductDto(1, "Apple iPhone 12", "Mobile_phone", 90000),
            new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000),
            new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000),
            new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000),
            new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000),
            new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000),
            new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000),
            new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000),
            new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000),
            new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000),
            new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000)
    );

    public ProductsAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final ProductDto product = productsList.get(position);//productDtos[position];

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.product_row, null);
        }

        final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
        final TextView productNameView = (TextView)convertView.findViewById(R.id.textview_product_name);
        final TextView productTypeView = (TextView)convertView.findViewById(R.id.textview_product_type);

        productNameView.setText(product.getName());
        productTypeView.setText(product.getType());

        return convertView;
    }

    @Override
    public int getCount() {
        return this.productsList.size();
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
