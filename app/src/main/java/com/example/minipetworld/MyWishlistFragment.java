package com.example.minipetworld;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyWishlistFragment extends Fragment {
    public MyWishlistFragment() {
        // Required empty public constructor
    }

    private RecyclerView wishlistRecyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wishlist, container, false);
        wishlistRecyclerview = view.findViewById(R.id.my_wishlist_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecyclerview.setLayoutManager(linearLayoutManager);

        List<WishlistModel> wishlistModelList = new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.comb, "comb", 1, "3", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
        wishlistModelList.add(new WishlistModel(R.drawable.cooolll, "collor", 0, "4", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
        wishlistModelList.add(new WishlistModel(R.drawable.coolll, "collor", 4, "2", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
        wishlistModelList.add(new WishlistModel(R.drawable. basket, "basket", 9, "1", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));
        wishlistModelList.add(new WishlistModel(R.drawable.doghouse, "Dog House", 2, "0", 25, "Rs. 4999/-", "Rs. 5999/-", "COD"));

        WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistModelList,true);
        wishlistRecyclerview.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();

        return view;
    }
}