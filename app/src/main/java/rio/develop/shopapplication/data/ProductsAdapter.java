package rio.develop.shopapplication.data;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.develop.shopapplication.R;

import java.util.Arrays;
import java.util.List;

public class ProductsAdapter extends BaseAdapter {
    private final Context mContext;

    List<ProductDto> productsList = Arrays.asList(
            new ProductDto(1, "Apple iPhone 7", "Смартфон", 30000, "D:\\Projects\\AndroidStudioProjects\\ShopApplication\\app\\src\\main\\res\\8.jpg"),
            new ProductDto(1, "Apple iPhone 8", "Смартфон", 40000, "D:\\Projects\\AndroidStudioProjects\\ShopApplication\\app\\src\\main\\res\\8.jpg"),
            new ProductDto(1, "Apple iPhone XR", "Смартфон", 50000, "https://lh3.googleusercontent.com/proxy/ISScb08pKVaouGhjykiyxSBj7pImiLclXD10HOaWYgk4-K0yUJAIDWG4W_eN0wyytOdWm0m_CDoxRiHw44KgtRrRAtysM3sArG0PGpEbf7qOaZY2mQ"),
            new ProductDto(1, "Apple iPhone 12", "Смартфон", 90000, "https://lh3.googleusercontent.com/proxy/ISScb08pKVaouGhjykiyxSBj7pImiLclXD10HOaWYgk4-K0yUJAIDWG4W_eN0wyytOdWm0m_CDoxRiHw44KgtRrRAtysM3sArG0PGpEbf7qOaZY2mQ"),
            new ProductDto(1, "LG 55SM8000", "Телевизор", 50090, "https://lh3.googleusercontent.com/proxy/ISScb08pKVaouGhjykiyxSBj7pImiLclXD10HOaWYgk4-K0yUJAIDWG4W_eN0wyytOdWm0m_CDoxRiHw44KgtRrRAtysM3sArG0PGpEbf7qOaZY2mQ"),
            new ProductDto(1, "LG 2810S-PZ", "Телевизор", 17390, "https://lh3.googleusercontent.com/proxy/ISScb08pKVaouGhjykiyxSBj7pImiLclXD10HOaWYgk4-K0yUJAIDWG4W_eN0wyytOdWm0m_CDoxRiHw44KgtRrRAtysM3sArG0PGpEbf7qOaZY2mQ"),
            new ProductDto(1, "SAMSUNG UE430U", "Телевизор", 35690, "https://lh3.googleusercontent.com/proxy/ISScb08pKVaouGhjykiyxSBj7pImiLclXD10HOaWYgk4-K0yUJAIDWG4W_eN0wyytOdWm0m_CDoxRiHw44KgtRrRAtysM3sArG0PGpEbf7qOaZY2mQ"),
            new ProductDto(1, "INDESIT DS4160W", "Холодильник", 22999, "https://lh3.googleusercontent.com/proxy/ISScb08pKVaouGhjykiyxSBj7pImiLclXD10HOaWYgk4-K0yUJAIDWG4W_eN0wyytOdWm0m_CDoxRiHw44KgtRrRAtysM3sArG0PGpEbf7qOaZY2mQ"),
            new ProductDto(1, "БИРЮСА 633", "Холодильник", 23499, "https://lh3.googleusercontent.com/proxy/ISScb08pKVaouGhjykiyxSBj7pImiLclXD10HOaWYgk4-K0yUJAIDWG4W_eN0wyytOdWm0m_CDoxRiHw44KgtRrRAtysM3sArG0PGpEbf7qOaZY2mQ"),
            new ProductDto(1, "АТЛАНТ 4008-022", "Холодильник", 20890, "https://lh3.googleusercontent.com/proxy/ISScb08pKVaouGhjykiyxSBj7pImiLclXD10HOaWYgk4-K0yUJAIDWG4W_eN0wyytOdWm0m_CDoxRiHw44KgtRrRAtysM3sArG0PGpEbf7qOaZY2mQ"),
            new ProductDto(1, "FLAMA AE 1403 W", "Эликтрическая плита", 30000, "https://lh3.googleusercontent.com/proxy/ISScb08pKVaouGhjykiyxSBj7pImiLclXD10HOaWYgk4-K0yUJAIDWG4W_eN0wyytOdWm0m_CDoxRiHw44KgtRrRAtysM3sArG0PGpEbf7qOaZY2mQ"),
            new ProductDto(1, "DARINA 1BEM3", "Эликтрическая плита", 12490, "https://lh3.googleusercontent.com/proxy/ISScb08pKVaouGhjykiyxSBj7pImiLclXD10HOaWYgk4-K0yUJAIDWG4W_eN0wyytOdWm0m_CDoxRiHw44KgtRrRAtysM3sArG0PGpEbf7qOaZY2mQ"),
            new ProductDto(1, "BOSCH BGS1U1", "Пылесос", 7390, "https://lh3.googleusercontent.com/proxy/ISScb08pKVaouGhjykiyxSBj7pImiLclXD10HOaWYgk4-K0yUJAIDWG4W_eN0wyytOdWm0m_CDoxRiHw44KgtRrRAtysM3sArG0PGpEbf7qOaZY2mQ")
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
        final TextView productTypePrice = (TextView)convertView.findViewById(R.id.textview_product_price);

        //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);



        imageView.setImageBitmap(BitmapFactory.decodeFile(product.getPicLink()));

        productNameView.setText(product.getName());
        productTypeView.setText(product.getType());
        productTypePrice.setText(String.valueOf(product.getPrice()));

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
