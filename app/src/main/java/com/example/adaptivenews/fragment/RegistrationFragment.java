package com.example.adaptivenews.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.adaptivenews.Client;
import com.example.adaptivenews.MainActivity;
import com.example.adaptivenews.MyThread;
import com.example.adaptivenews.R;
import com.example.adaptivenews.User;
import com.example.adaptivenews.databinding.FragmentLogInBinding;
import com.example.adaptivenews.databinding.FragmentRegistrationBinding;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegistrationFragment extends Fragment implements AdapterView.OnItemSelectedListener{


    private FragmentRegistrationBinding mBinding;
    MyThread myThread;
    private User user = new User();
    private Client client = new Client();
    private Thread thread;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //getContext().getTheme().applyStyle(R.style.Theme_2,true);



        mBinding = FragmentRegistrationBinding.inflate(inflater, container, false);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.type, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mBinding.spinner.setAdapter(adapter);
        mBinding.spinner.setOnItemSelectedListener(this);
        mBinding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (mBinding.spinner.getSelectedItem().toString().equals("Deuteranopia")){
                    mBinding.signInBtn.setBackgroundColor(getResources().getColor(R.color.primary_deuteranopia));
                    Window window = RegistrationFragment.this.getActivity().getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.divider_color_deuteranopia));
                    window.setNavigationBarColor(getResources().getColor(R.color.divider_color_deuteranopia));

                    mBinding.signInBtn.setTextSize(14);
                    mBinding.emptyPassword.setTextSize(14);
                    mBinding.emptyName.setTextSize(14);
                    mBinding.name.setTextSize(14);
                    mBinding.Password.setTextSize(14);
                    mBinding.textview.setTextSize(14);

                    ColorMatrixColorFilter filter = new ColorMatrixColorFilter(DEUTERANOPIA);
                    mBinding.imageView.setColorFilter(filter);

                } else if (mBinding.spinner.getSelectedItem().toString().equals("Monochromacy")){
                    mBinding.signInBtn.setBackgroundColor(getResources().getColor(R.color.primary_mono));
                    Window window = RegistrationFragment.this.getActivity().getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.divider_color_mono));
                    window.setNavigationBarColor(getResources().getColor(R.color.divider_color_mono));

                    mBinding.signInBtn.setTextSize(14);
                    mBinding.emptyPassword.setTextSize(14);
                    mBinding.emptyName.setTextSize(14);
                    mBinding.name.setTextSize(14);
                    mBinding.Password.setTextSize(14);
                    mBinding.textview.setTextSize(14);

                    ColorMatrixColorFilter filter = new ColorMatrixColorFilter(ACROMATOPSIA);
                    mBinding.imageView.setColorFilter(filter);

                } else if (mBinding.spinner.getSelectedItem().toString().equals("Deuteranomaly")){
                    mBinding.signInBtn.setBackgroundColor(getResources().getColor(R.color.primary_deuteranomaly));
                    Window window = RegistrationFragment.this.getActivity().getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.divider_color_deuteranomaly));
                    window.setNavigationBarColor(getResources().getColor(R.color.divider_color_deuteranomaly));

                    mBinding.signInBtn.setTextSize(14);
                    mBinding.emptyPassword.setTextSize(14);
                    mBinding.emptyName.setTextSize(14);
                    mBinding.name.setTextSize(14);
                    mBinding.Password.setTextSize(14);
                    mBinding.textview.setTextSize(14);
                    ColorMatrixColorFilter filter = new ColorMatrixColorFilter(Deuteranomaly);
                    mBinding.imageView.setColorFilter(filter);

                } else if (mBinding.spinner.getSelectedItem().toString().equals("Low vision")){
                    mBinding.signInBtn.setBackgroundColor(getResources().getColor(R.color.primary));
                    Window window = RegistrationFragment.this.getActivity().getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.primary_light));
                    window.setNavigationBarColor(getResources().getColor(R.color.primary_light));

                    mBinding.signInBtn.setTextSize(18);
                    mBinding.emptyPassword.setTextSize(18);
                    mBinding.emptyName.setTextSize(18);
                    mBinding.name.setTextSize(18);
                    mBinding.Password.setTextSize(18);
                    mBinding.textview.setTextSize(18);

                    ColorMatrixColorFilter filter = new ColorMatrixColorFilter(NORMAL);
                    mBinding.imageView.setColorFilter(filter);

                } else{
                    mBinding.signInBtn.setBackgroundColor(getResources().getColor(R.color.primary));
                    Window window = RegistrationFragment.this.getActivity().getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.primary_light));
                    window.setNavigationBarColor(getResources().getColor(R.color.primary_light));

                    ColorMatrixColorFilter filter = new ColorMatrixColorFilter(NORMAL);
                    mBinding.imageView.setColorFilter(filter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        mBinding.emptyName.setVisibility(View.INVISIBLE);
        mBinding.emptyPassword.setVisibility(View.INVISIBLE);


        mBinding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!mBinding.name.getText().toString().equals("") && !mBinding.Password.getText().toString().equals("")) {
                    user.setName(mBinding.name.getText().toString());
                    user.setPassword(mBinding.Password.getText().toString());
                    user.setAccess(mBinding.spinner.getSelectedItem().toString());

                    client.setClient(user, "registration");
                    thread = new Thread(client);
                    thread.start();

                    while(thread.isAlive() && client.getOperationSuccessfullyCompleted().equals("")){
                        System.out.println("loading");
                    }

                   // client.sendMessage(user.getName());
                   // client.sendMessage(user.getPassword());
                   // client.sendMessage(user.getAccess());
                    if (client.getOperationSuccessfullyCompleted().equals("registration completed")) {
                        RegistrationFragmentDirections.ActionRegistrationFragmentToHomeFragment action = RegistrationFragmentDirections.actionRegistrationFragmentToHomeFragment();
                        action.setAccessibility(user.getAccess());
                        Navigation.findNavController(view).navigate(action);
                    }else{
                        Toast.makeText(getContext(),"Registration error",Toast.LENGTH_SHORT).show();
                    }
                } else if (mBinding.name.getText().toString().equals("") && mBinding.Password.getText().toString().equals("")) {
                    mBinding.emptyName.setVisibility(View.VISIBLE);
                    mBinding.emptyPassword.setVisibility(View.VISIBLE);
                } else if (mBinding.name.getText().toString().equals("")) {
                    mBinding.emptyPassword.setVisibility(View.INVISIBLE);
                    mBinding.emptyName.setVisibility(View.VISIBLE);
                } else if (mBinding.Password.getText().toString().equals("")) {
                    mBinding.emptyName.setVisibility(View.INVISIBLE);
                    mBinding.emptyPassword.setVisibility(View.VISIBLE);
                }

            }
        });

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    public void btnClickSnd(View v) {
        String msg = mBinding.name.getText().toString();
        myThread.sendMsgParam(msg);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private static final float[] Deuteranomaly = {
            0.8f ,0.2f ,0,0,0,
            0.258f,0.742f ,0,0,0,
            0,0.142f,0.858f,0,0,
            0,0,0,1,0,
            0,0,0,0
    };

    private static final float[] ACROMATOPSIA = {
            0.299f,0.587f,0.114f,0,0,
            0.299f,0.587f,0.114f,0,0,
            0.299f,0.587f,0.114f,0,0,
            0,0,0,1,0,
            0,0,0,0,1
    };

    private static final float[] DEUTERANOPIA = {
            0.625f,0.375f,0,0,0,
            0.7f,0.3f,0,0,0,
            0,0.3f,0.7f,0,0,
            0,0,0,1,0,
            0,0,0,0,1
    };

    private static final float[] NORMAL = {
            1,0,0,0,0,
            0,1,0,0,0,
            0,0,1,0,0,
            0,0,0,1,0,
            0,0,0,0,1
    };

}
