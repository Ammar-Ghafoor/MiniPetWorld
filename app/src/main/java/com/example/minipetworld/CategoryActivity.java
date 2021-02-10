package com.example.minipetworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title= getIntent().getStringExtra("Categoryname");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);

        ///////////////////////////// banner slide


        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.ad6, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ad7, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ad1, "#077AE4"));


        sliderModelList.add(new SliderModel(R.drawable.ad1, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ad2, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ad3, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ad4, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ad5, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ad6, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ad7, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ad1, "#077AE4"));

        sliderModelList.add(new SliderModel(R.drawable.ad1, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ad2, "#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.ad3, "#077AE4"));


        ////////////////banner slide


        //////////////////////// strip ad
        // ////////////////////// strip ad


        //////////////////////// horizontal product layout

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.coolll, "collor", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.comb, "comb", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.cooolll, "coller", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.shampoo, "shampoo", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.basket, "basket", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.litter, "Litter", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bowls, "Collor", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.cooolll, "Collor", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bolw, "Bowl", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.doghouse, "Dog House", "the best product", "RS 1600/-"));

        //////////////////////// horizontal product layout
        ///////////////////////////////////////////////////////////

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);


        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.sad2, "#000000"));
        homePageModelList.add(new HomePageModel(2, "Deals of The Day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Deals of The Day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.sad1, "#000000"));
        homePageModelList.add(new HomePageModel(2, "Deals of The Day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Deals of The Day", horizontalProductScrollModelList));


        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //top three action icon
        int  id = item.getItemId();
        if(id == R.id.main_search_icon){
            //todo
            return true;
        }
        return super.onOptionsItemSelected(item);
  }

}