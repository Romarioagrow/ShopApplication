package com.develop.shopapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ProductsAdapter extends BaseAdapter /*extends ArrayAdapter<ProductDto>*/ {
    private final Context mContext;

    ProductDto productDto1 = new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000);
    ProductDto productDto2 = new ProductDto(1, "Apple iPhone 8", "Mobile_phone", 40000);
    ProductDto productDto3 = new ProductDto(1, "Apple iPhone XR", "Mobile_phone", 50000);
    ProductDto productDto4 = new ProductDto(1, "Apple iPhone 12", "Mobile_phone", 90000);
    ProductDto[] productDtos = new ProductDto[]{productDto1, productDto2, productDto3, productDto4};
    //private final ProductDto[] productDtos;

    public ProductsAdapter(Context c) {
        this.mContext = c;
        //this.productDtos = productDtos;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        final ProductDto product = productDtos[position];

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.product_row, null);
        }

        // 3
        //final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
        final TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_book_name);
        final TextView authorTextView = (TextView)convertView.findViewById(R.id.textview_book_author);
       // final ImageView imageViewFavorite = (ImageView)convertView.findViewById(R.id.imageview_favorite);

        // 4
        //imageView.setImageResource(product.getImageResource());
        nameTextView.setText(product.getName());
        authorTextView.setText(product.getAuthor());

        return convertView;




        /*TextView dummyTextView = new TextView(mContext);
        dummyTextView.setText(String.valueOf(position));




        return dummyTextView;*/
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
