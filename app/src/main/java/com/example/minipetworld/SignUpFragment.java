package com.example.minipetworld;

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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpFragment extends Fragment {

    public SignUpFragment() {
        // Required empty public constructor
    }


    private TextView alreadyHaveAnAcnt;
    private FrameLayout parentFramelayout;
    private EditText sign_up_email;
    private EditText sign_up_name;
    private EditText    sign_up_password;
    private EditText    sign_up_confirm_pas;
    private ProgressBar sign_up_progressBar;
    private Button sign_up_btn;
    private ImageView sign_up_close_btn;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

   private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        alreadyHaveAnAcnt = view.findViewById(R.id.sign_up_already_have_acnt);
        sign_up_email = view.findViewById(R.id.sign_up_email);
         sign_up_name = view.findViewById(R.id.sign_up_full_name);
         sign_up_password = view.findViewById(R.id.sign_up_password);
         sign_up_confirm_pas = view.findViewById(R.id.sign_up_confrm_password);
         sign_up_close_btn = view.findViewById(R.id.sign_up_close_btn);
         sign_up_btn = view.findViewById(R.id.sign_up_btn);
        sign_up_progressBar = view.findViewById(R.id.sign_up_progressBar);
        parentFramelayout = getActivity().findViewById(R.id.register_frame_layout);

        firebaseFirestore = firebaseFirestore.getInstance();
        firebaseAuth = firebaseAuth.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alreadyHaveAnAcnt.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           setFragment(new SignInFragment());
       }
   });

        sign_up_close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainintent();
            }
        });
        sign_up_email.addTextChangedListener(new TextWatcher() {
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
        sign_up_name.addTextChangedListener(new TextWatcher() {
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
        sign_up_password.addTextChangedListener(new TextWatcher() {
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
        sign_up_confirm_pas.addTextChangedListener(new TextWatcher() {
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
        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEmailAndPassword();
            }
        });

    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_form_right);
        fragmentTransaction.replace(parentFramelayout.getId(),fragment);
        fragmentTransaction.commit();
    }
    private void checkInputs(){
        if(!TextUtils.isEmpty(sign_up_email.getText())){
            if(!TextUtils.isEmpty(sign_up_name.getText())){
                if(!TextUtils.isEmpty(sign_up_password.getText()) && sign_up_password.length()>= 8){
                    if(!TextUtils.isEmpty((sign_up_confirm_pas.getText()))){
                        sign_up_btn.setEnabled(true);
                        sign_up_btn.setTextColor(Color.rgb(255,255,255));
                    }else{

                        sign_up_btn.setEnabled(false);
                        sign_up_btn.setTextColor(Color.argb(50,255,255,255));
                    }
                }else{

                    sign_up_btn.setEnabled(false);
                    sign_up_btn.setTextColor(Color.argb(50,255,255,255));
                }
            }else{

                sign_up_btn.setEnabled(false);
                sign_up_btn.setTextColor(Color.argb(50,255,255,255));
            }
        }
        else{
            sign_up_btn.setEnabled(false);
            sign_up_btn.setTextColor(Color.argb(50,255,255,255));
        }
    }
    private void CheckEmailAndPassword(){
        if(sign_up_email.getText().toString().matches(emailPattern)){
            if(sign_up_password.getText().toString().equals(sign_up_confirm_pas.getText().toString())){
                sign_up_progressBar.setVisibility(View.VISIBLE);
                sign_up_btn.setEnabled(false);
                sign_up_btn.setTextColor(Color.argb(50,255,255,255));

                firebaseAuth.createUserWithEmailAndPassword(sign_up_email.getText().toString(),sign_up_password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){
            Map<Object,String> userdata = new HashMap<>();
            userdata.put("Fullname",sign_up_name.getText().toString());

            firebaseFirestore.collection("USERS")
                    .add(userdata)
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            if (task.isSuccessful()){
                               mainintent();
                            }else{
                                sign_up_progressBar.setVisibility(View.INVISIBLE);
                                sign_up_btn.setEnabled(true);
                                sign_up_btn.setTextColor(Color.rgb(255,255,255));

                                String error =task.getException().getMessage();
                                Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

          }else{
            sign_up_progressBar.setVisibility(View.INVISIBLE);
            sign_up_btn.setEnabled(true);
            sign_up_btn.setTextColor(Color.rgb(255,255,255));

            String error =task.getException().getMessage();
            Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();

        }
    }
});
            }else{
sign_up_confirm_pas.setError("Password Dos'nt match");
            }

        }else{
sign_up_email.setError("Invelid email");
        }

    }
    private void mainintent(){
        Intent mainintent = new Intent(getActivity(),MainActivity.class);
        startActivity(mainintent);
        getActivity().finish();

    }
}