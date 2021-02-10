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

public class MyRewardsFragment extends Fragment {

    public MyRewardsFragment() {
        // Required empty public constructor
    }

    private RecyclerView rewardsRecyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_rewards, container, false);
    rewardsRecyclerview = view.findViewById(R.id.my_rewards_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rewardsRecyclerview.setLayoutManager(layoutManager);

        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("Cashback","Till 2nd aug 2020","Get 20% cashback on any product above Rs. 3000/- and below Rs. 1000/-"));
        rewardModelList.add(new RewardModel("Cashback","Till 2nd aug 2020","Get 20% cashback on any product above Rs. 3000/- and below Rs. 1000/-"));
        rewardModelList.add(new RewardModel("Cashback","Till 2nd aug 2020","Get 20% cashback on any product above Rs. 3000/- and below Rs. 1000/-"));
        rewardModelList.add(new RewardModel("Discount","Till 2nd aug 2020","Get 20% cashback on any product above Rs. 3000/- and below Rs. 1000/-"));
        rewardModelList.add(new RewardModel("Discount","Till 2nd aug 2020","Get 20% cashback on any product above Rs. 3000/- and below Rs. 1000/-"));
        rewardModelList.add(new RewardModel("Discount","Till 2nd aug 2020","Get 20% cashback on any product above Rs. 3000/- and below Rs. 1000/-"));
        rewardModelList.add(new RewardModel("Buy 1 Get 1","Till 2nd aug 2020","Get 20% cashback on any product above Rs. 3000/- and below Rs. 1000/-"));
        rewardModelList.add(new RewardModel("Buy 1 Get 1","Till 2nd aug 2020","Get 20% cashback on any product above Rs. 3000/- and below Rs. 1000/-"));
        rewardModelList.add(new RewardModel("Buy 1 Get 1","Till 2nd aug 2020","Get 20% cashback on any product above Rs. 3000/- and below Rs. 1000/-"));
        rewardModelList.add(new RewardModel("Buy 1 Get 1","Till 2nd aug 2020","Get 20% cashback on any product above Rs. 3000/- and below Rs. 1000/-"));

        MyRewardsAdapter myRewardsAdapter = new MyRewardsAdapter(rewardModelList);
        rewardsRecyclerview.setAdapter(myRewardsAdapter);
        myRewardsAdapter.notifyDataSetChanged();
        return view;
    }
}