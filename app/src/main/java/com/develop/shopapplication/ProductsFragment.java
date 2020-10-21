package com.develop.shopapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.develop.shopapplication.ui.main.PageViewModel;

public class ProductsFragment extends Fragment {

    //private GridView gridView;
    private GridView gridView;

    public ProductsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setCon(R.layout.activity_main);

        //this.gridView = (GridView)findViewById(R.id.gridView);
        //getView().getLa;

        /*pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);*/



    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState
    ) {
        //this.gridView = getView().findViewById(R.id.gridView);
        //this.gridView = getView().findViewById(R.id.gridView);
        //this.gridView = container.getRootView().findViewById(R.id.gridView);

        ProductDto productDto1 = new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000);
        ProductDto productDto2 = new ProductDto(1, "Apple iPhone 8", "Mobile_phone", 40000);
        ProductDto productDto3 = new ProductDto(1, "Apple iPhone XR", "Mobile_phone", 50000);
        ProductDto productDto4 = new ProductDto(1, "Apple iPhone 12", "Mobile_phone", 90000);
        ProductDto[] productDtos = new ProductDto[]{productDto1, productDto2, productDto3, productDto4};

        View view = inflater.inflate(R.layout.fragment_products, container, false);

        GridView gridViewYes = (GridView) view.findViewById(R.id.gridView);
        gridViewYes.setAdapter(new ArrayAdapter<ProductDto>(view.getContext(), android.R.layout.simple_list_item_1 , productDtos));


        /*
        ArrayAdapter<ProductDto> arrayAdapter = new ArrayAdapter<ProductDto>(getContext() , android.R.layout.simple_list_item_1 , productDtos);*/

        /*gridView.setAdapter(arrayAdapter);

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

        return view;
    }



}
