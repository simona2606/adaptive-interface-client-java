package com.example.adaptivenews.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.adaptivenews.MyThread;
import com.example.adaptivenews.R;
import com.example.adaptivenews.User;
import com.example.adaptivenews.databinding.FragmentLogInBinding;


public class LogInFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    private FragmentLogInBinding mBinding;
    MyThread myThread;
    private User user = new User();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentLogInBinding.inflate(inflater, container, false);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.type, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mBinding.emptyPassw.setVisibility(View.INVISIBLE);
        mBinding.EmptyName.setVisibility(View.INVISIBLE);

        //mBinding.loginBtn.setBackgroundColor(Color.parseColor("#474973"));
        myThread = new MyThread();
        new Thread(myThread).start();



        mBinding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mBinding.name.getText().toString().equals("") && !mBinding.Password.getText().toString().equals("")){
                    user.setName(mBinding.name.getText().toString());
                    user.setPassword(mBinding.Password.getText().toString());
                    user.setAccess("Dichromasy");
                    LogInFragmentDirections.ActionLoginFragmentToHomeFragment action = LogInFragmentDirections.actionLoginFragmentToHomeFragment();
                    action.setAccessibility(user.getAccess());
                    Navigation.findNavController(view).navigate(action);


                }else if (mBinding.name.getText().toString().equals("") && mBinding.Password.getText().toString().equals("")){
                    mBinding.EmptyName.setVisibility(View.VISIBLE);
                    mBinding.emptyPassw.setVisibility(View.VISIBLE);
                }else if (mBinding.name.getText().toString().equals("")){
                    mBinding.emptyPassw.setVisibility(View.INVISIBLE);
                    mBinding.EmptyName.setVisibility(View.VISIBLE);
                }else if (mBinding.Password.getText().toString().equals("")){
                    mBinding.EmptyName.setVisibility(View.INVISIBLE);
                    mBinding.emptyPassw.setVisibility(View.VISIBLE);
                }

                if (user.getAccess().equals("Deuteranopia")){
                    mBinding.signInBtn.setBackgroundColor(getResources().getColor(R.color.Deuteranopia));
                    Window window = LogInFragment.this.getActivity().getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.Deuteranopia));
                    window.setNavigationBarColor(getResources().getColor(R.color.Deuteranopia));
                }else if (user.getAccess().equals("Dichromasy")){
                    mBinding.signInBtn.setBackgroundColor(getResources().getColor(R.color.Dichromasy));
                    Window window = LogInFragment.this.getActivity().getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.Dichromasy));
                    window.setNavigationBarColor(getResources().getColor(R.color.Dichromasy));
                }else if (user.getAccess().equals("Deuteranomaly")){
                    mBinding.signInBtn.setBackgroundColor(getResources().getColor(R.color.Deuteranomaly));
                    Window window = LogInFragment.this.getActivity().getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.Deuteranomaly));
                    window.setNavigationBarColor(getResources().getColor(R.color.Deuteranomaly));
                }
            }
        });

        mBinding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registrationFragment);
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
}