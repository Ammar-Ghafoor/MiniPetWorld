package com.example.minipetworld;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView homePageRecyclerview;
    private HomePageAdapter adapter;
    private List<CategoryModel> categoryModelList;
    private FirebaseFirestore firebaseFirestore;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        categoryModelList = new ArrayList<CategoryModel>();
        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);


        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("CATEGORIES").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                categoryModelList.add(new CategoryModel(documentSnapshot.get("icon").toString(), documentSnapshot.get("categoryName").toString()));
                            }
                            categoryAdapter.notifyDataSetChanged();

                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        ///////////////////////////// banner slide
        List<SliderModel> sliderModelList = new ArrayList<>();

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

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.litter, "Litter box", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.comb, "Comb", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.shampoo, "shampoo", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.basket, "Cat basket", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.comb, "Dog Comb", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bolw, "Eating Bowl", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bowls, "Eating Bowl", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.coolll, "Dog Collor", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.cooolll, "Dog Collor", "the best product", "RS 1600/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.doghouse, "Dog House", "the best product", "RS 1600/-"));

//        //////////////////////// horizontal product layout
        ///////////////////////////////////////////////////////////


        homePageRecyclerview = view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerview.setLayoutManager(testingLayoutManager);


        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.sad2, "#ff0000"));
        homePageModelList.add(new HomePageModel(2, "Deals of the day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Deals of the day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.sad1, "#ff0000"));


        adapter = new HomePageAdapter(homePageModelList);
        homePageRecyclerview.setAdapter(adapter);


        ///////////////////////////////////////////////////////////

        return view;
    }

}