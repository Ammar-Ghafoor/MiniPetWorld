package com.example.minipetworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import java.util.ArrayList;
import java.util.List;

import static com.example.minipetworld.DeliveryActivity.SELECT_ADDRESS;


public class MyAddressesActivity extends AppCompatActivity {

    // comoing from delivery activity hai my account frag
    private RecyclerView myAddressesRecyclerview;
    private Button deliverHereBtn;
    private static AddressesAdapter addressesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addresses);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My addresses");
        getSupportActionBar().setDisplayShowTitleEnabled(true);


        myAddressesRecyclerview = findViewById(R.id.addresses_recyclerview);
        deliverHereBtn = findViewById(R.id.deliver_here_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myAddressesRecyclerview.setLayoutManager(layoutManager);

        List<AddressesModel> addressesModelList = new ArrayList<>();
        addressesModelList.add(new AddressesModel("Muhammad Ali","Shad bagh lahore","1234",true));
        addressesModelList.add(new AddressesModel("Hamid Ali","Gujrawala","1234",false));
        addressesModelList.add(new AddressesModel("Ammar ghafoor","Hasil pur","1234",false));

        int mode = getIntent().getIntExtra("MODE",-1);
        if (mode == SELECT_ADDRESS){
            deliverHereBtn.setVisibility(View.VISIBLE);
            }else{
            deliverHereBtn.setVisibility(View.INVISIBLE);

        }
            addressesAdapter = new AddressesAdapter(addressesModelList,mode);
            myAddressesRecyclerview.setAdapter(addressesAdapter);
        ((SimpleItemAnimator)myAddressesRecyclerview.getItemAnimator()).setSupportsChangeAnimations(false); //it disables the by default select animantion because we have set the customized animation
            addressesAdapter.notifyDataSetChanged();
    }


    public static void refreshItem(int deselect,int select){
        addressesAdapter.notifyItemChanged(deselect);  //this  method refresh addresses to show and hide check mark from address
        addressesAdapter.notifyItemChanged(select);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}