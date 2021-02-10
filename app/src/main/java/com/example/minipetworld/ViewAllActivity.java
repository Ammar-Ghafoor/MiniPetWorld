package com.example.minipetworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Deals of the day");


        recyclerView = findViewById(R.id.recycler_view);
        gridView = findViewById(R.id.grid_view);

        int layout_code = getIntent().getIntExtra("layout_code",-1);


        if (layout_code == 0 ) {
            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
         recyclerView.setLayoutManager(layoutManager);

            List<WishlistModel> wishlistModelList = new ArrayList<>();
            wishlistModelList.add(new WishlistModel(R.drawable.doghouse, "Dog House", 1, "3", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.comb, "Comb", 0, "4", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.coolll, "collor", 4, "2", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.cooolll, "collor", 9, "1", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.basket, "basket", 2, "0", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.litter, "litter box", 1, "3", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.shampoo, "shampoo", 0, "4", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.basket, "basket", 4, "2", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.bowls, "bowl", 9, "1", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.bolw, "bowl", 2, "0", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
                       wishlistModelList.add(new WishlistModel(R.drawable.doghouse, "Dog House", 1, "3", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.comb, "Comb", 0, "4", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.coolll, "collor", 4, "2", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.cooolll, "collor", 9, "1", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.basket, "basket", 2, "0", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.litter, "litter box", 1, "3", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.shampoo, "shampoo", 0, "4", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.basket, "basket", 4, "2", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.bowls, "bowl", 9, "1", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
            wishlistModelList.add(new WishlistModel(R.drawable.bolw, "bowl", 2, "0", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));


            WishlistAdapter adapter = new WishlistAdapter(wishlistModelList, false);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else if(layout_code == 1){


        gridView.setVisibility(View.VISIBLE);

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.cooolll, "Collor", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.comb, "Comb", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.coolll, "Dog collor", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bolw, "Bowl", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bowls, "Dog Bowl", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.basket, "Dog Basket", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.litter, "Litter Box", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.shampoo, "Shampoo", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.basket, "Basket", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.doghouse, "Dog House", "All Wooden", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.cooolll, "Collor", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.comb, "Comb", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.coolll, "Dog collor", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bolw, "Bowl", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bowls, "Dog Bowl", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.basket, "Dog Basket", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.litter, "Litter Box", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.shampoo, "Shampoo", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.basket, "Basket", "the product that you'll love", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.doghouse, "Dog House", "All Wooden", "RS 1600/-"));

        GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProductScrollModelList);
        gridView.setAdapter(gridProductLayoutAdapter);
        gridProductLayoutAdapter.notifyDataSetChanged();

        }

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //top three action icon
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}