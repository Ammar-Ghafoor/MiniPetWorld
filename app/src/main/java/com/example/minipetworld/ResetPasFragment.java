package com.example.minipetworld;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasFragment extends Fragment {

    public ResetPasFragment() {
        // Required empty public constructor
    }

    private FrameLayout parentFramelayout;
    private Button reset_btn;
    private TextView reset_goback;
    private EditText reset_email;
    private FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_reset_pas, container, false);

        reset_btn =view.findViewById(R.id.reset_btn);
        reset_email =view.findViewById(R.id.reset_email);
        reset_goback =view.findViewById(R.id.reset_goback);
        parentFramelayout = getActivity().findViewById(R.id.register_frame_layout);
        firebaseAuth = FirebaseAuth.getInstance();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        reset_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignInFragment());
            }
        });
        reset_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkinputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset_btn.setEnabled(false);
                reset_btn.setTextColor(Color.argb(50,255,255,255));

                firebaseAuth.sendPasswordResetEmail(reset_email.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getActivity(),"Email Sent Successfully",Toast.LENGTH_LONG).show();

                                }else{
                                    String error =task.getException().getMessage();
                                    Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                                }
                                reset_btn.setEnabled(true);
                                reset_btn.setTextColor(Color.rgb(255,255,255));

                            }
                        });
            }
        });

    }

    private void checkinputs() {

        if(!TextUtils.isEmpty(reset_email.getText())){
                reset_btn.setEnabled(true);
                reset_btn.setTextColor(Color.rgb(255,255,255));

        }else{
            reset_btn.setEnabled(false);
            reset_btn.setTextColor(Color.argb(50,255,255,255));

        }
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_form_right);
        fragmentTransaction.replace(parentFramelayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}