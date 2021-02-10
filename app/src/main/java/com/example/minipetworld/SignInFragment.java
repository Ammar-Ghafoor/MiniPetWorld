package com.example.minipetworld;

import android.app.FragmentBreadCrumbs;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class SignInFragment extends Fragment {

    public SignInFragment() {
        // Required empty public constructor
    }

    private TextView dontHaveAnAcnt;
    private FrameLayout parentFramelayout;

    private EditText sign_in_email;
    private EditText sign_in_password;
    private Button sign_in_btn;
    private TextView sign_in_forgot_password;
    private ImageView sign_in_close_btn;
    private ProgressBar sign_in_progressBar;

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    private FirebaseAuth firebaseAuth;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        dontHaveAnAcnt = view.findViewById(R.id.tv_dont_have_acnt);
        parentFramelayout = getActivity().findViewById(R.id.register_frame_layout);
        sign_in_email = view.findViewById(R.id.sign_in_email);
        sign_in_forgot_password = view.findViewById(R.id.sign_in_fgt_password);
        sign_in_btn = view.findViewById(R.id.sign_in_btn);
        sign_in_password = view.findViewById(R.id.sign_in_password);
        sign_in_close_btn =view.findViewById(R.id.sign_in_close_btn);
        sign_in_progressBar =view.findViewById(R.id.sign_in_progressBar);
        firebaseAuth = FirebaseAuth.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sign_in_close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainintent();
            }
        });
        sign_in_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new ResetPasFragment());
            }
        });
        dontHaveAnAcnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignUpFragment());
            }
        });
        sign_in_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        sign_in_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailAndPassword();
            }
        });


    }



    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right,R.anim.slideout_from_left);
        fragmentTransaction.replace(parentFramelayout.getId(),fragment);
        fragmentTransaction.commit();
    }


    private void checkInputs() {
    if(!TextUtils.isEmpty(sign_in_email.getText())){
        if(!TextUtils.isEmpty(sign_in_password.getText())){
            sign_in_btn.setEnabled(true);
            sign_in_btn.setTextColor(Color.rgb(255,255,255));
        }else{
            sign_in_btn.setEnabled(false);
            sign_in_btn.setTextColor(Color.argb(50,255,255,255));
        }
    }else{
        sign_in_btn.setEnabled(false);
        sign_in_btn.setTextColor(Color.argb(50,255,255,255));

    }

    }
    private void checkEmailAndPassword() {

    if(sign_in_email.getText().toString().matches(emailPattern)){
        if(sign_in_password.length() >= 8){

            sign_in_progressBar.setVisibility(View.VISIBLE);
            sign_in_btn.setEnabled(false);
            sign_in_btn.setTextColor(Color.argb(50,255,255,255));


            firebaseAuth.signInWithEmailAndPassword(sign_in_email.getText().toString(),sign_in_password.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            mainintent();

                        }  else{
                            sign_in_progressBar.setVisibility(View.INVISIBLE);
                            sign_in_btn.setEnabled(true);
                            sign_in_btn.setTextColor(Color.rgb(255,255,255));
                            String error =task.getException().getMessage();
                            Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                        }
                        }
                    });
        }else{
            Toast.makeText(getActivity(),"Icorrect Email or Password", Toast.LENGTH_SHORT).show();
        }
    }else{
        Toast.makeText(getActivity(),"Icorrect Email or Password", Toast.LENGTH_SHORT).show();

    }

    }
    private void mainintent(){
        Intent mainintent = new Intent(getActivity(),MainActivity.class);
        startActivity(mainintent);
        getActivity().finish();

    }


}