package com.develop.shopapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.develop.shopapplication.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {
    //private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        /*GridView gridView = (GridView)findViewById(R.id.gridView);
        ProductsAdapter booksAdapter = new ProductsAdapter(this);
        gridView.setAdapter(booksAdapter);*/

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });



        /****************************************/


        //this.gridView = (GridView)findViewById(R.id.gridView);

        /*ProductDto productDto1 = new ProductDto(1, "Apple iPhone 7", "Mobile_phone", 30000);
        ProductDto productDto2 = new ProductDto(1, "Apple iPhone 8", "Mobile_phone", 40000);
        ProductDto productDto3 = new ProductDto(1, "Apple iPhone XR", "Mobile_phone", 50000);
        ProductDto productDto4 = new ProductDto(1, "Apple iPhone 12", "Mobile_phone", 90000);

        ProductDto[] productDtos = new ProductDto[]{productDto1, productDto2, productDto3, productDto4};

        ArrayAdapter<ProductDto> arrayAdapter
                = new ArrayAdapter<ProductDto>(this, android.R.layout.simple_list_item_1 , productDtos);

        gridView.setAdapter(arrayAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                ProductDto productDto = (ProductDto) o;
                Toast.makeText(MainActivity.this, "Selected :" + " " + productDto.getType() +"\n("+ productDto.getName()+")",
                        Toast.LENGTH_LONG).show();
            }
        });*/

    }
}