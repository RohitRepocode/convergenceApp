package com.example.convergenceapp.Mpin;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.convergenceapp.LoginActivity;
import com.example.convergenceapp.MpinActivity;
import com.example.convergenceapp.R;
import com.example.convergenceapp.databinding.FragmentSetMpinBinding;
import com.example.convergenceapp.databinding.FragmentVerifyMpinBinding;
import com.example.convergenceapp.utils.PreferenceFactory;
import com.example.convergenceapp.utils.PreferenceKeyManager;

public class VerifyMpinFragment extends Fragment {
    private FragmentVerifyMpinBinding binding;
    String enterPin, mPin;
    Boolean areEqual;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPin =   PreferenceFactory.getInstance().getSharedPrefrencesData(PreferenceKeyManager.getPrefKeyMpin(), getContext());

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVerifyMpinBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enterPin = binding.pinviewGetMpin.getText().toString();
                if (enterPin.equalsIgnoreCase("")){
                    Toast.makeText(getContext(), "Mpin should not be empty", Toast.LENGTH_LONG).show();
                }
                else {
                    areEqual = enterPin.equals(mPin);
                    if (areEqual) {
                        intentToHome();
                    }
                    else {
                        Toast.makeText(getContext(), "Mpin is wrong ", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });


        return view;

    }

         private void intentToHome() {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}