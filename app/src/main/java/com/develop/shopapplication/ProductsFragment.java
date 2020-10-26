package com.develop.shopapplication;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import androidx.fragment.app.Fragment;

public class ProductsFragment extends Fragment {
    private GridView gridView;

    public ProductsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        gridView = (GridView) view.findViewById(R.id.gridView);
        ProductsAdapter productsAdapter = new ProductsAdapter(container.getContext());
        gridView.setAdapter(productsAdapter);
        return view;


        /*
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                ProductDto productDto = (ProductDto) o;
                Toast.makeText(getContext(), "Selected :" + " " + productDto.getType() +"\n("+ productDto.getName()+")",
                        Toast.LENGTH_LONG).show();
            }
        });*/
       // /*return*/ inflater.inflate(R.layout.fragment_products, container, false);
    }
}
