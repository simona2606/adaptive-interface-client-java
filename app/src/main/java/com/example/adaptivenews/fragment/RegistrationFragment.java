package com.example.adaptivenews.fragment;

import android.app.Activity;
import android.graphics.Color;
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

import com.example.adaptivenews.MyThread;
import com.example.adaptivenews.R;
import com.example.adaptivenews.User;
import com.example.adaptivenews.databinding.FragmentLogInBinding;
import com.example.adaptivenews.databinding.FragmentRegistrationBinding;

public class RegistrationFragment extends Fragment implements AdapterView.OnItemSelectedListener{


    private FragmentRegistrationBinding mBinding;
    MyThread myThread;
    private User user = new User();

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
                // your code here
                if (mBinding.spinner.getSelectedItem().toString().equals("Deuteranopia")){
                mBinding.signInBtn.setBackgroundColor(getResources().getColor(R.color.Deuteranopia));
                    Window window = RegistrationFragment.this.getActivity().getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.Deuteranopia));
                    window.setNavigationBarColor(getResources().getColor(R.color.Deuteranopia));
            }else if (mBinding.spinner.getSelectedItem().toString().equals("Dichromasy")){
                    mBinding.signInBtn.setBackgroundColor(getResources().getColor(R.color.Dichromasy));
                    Window window = RegistrationFragment.this.getActivity().getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.Dichromasy));
                    window.setNavigationBarColor(getResources().getColor(R.color.Dichromasy));
                }else if (mBinding.spinner.getSelectedItem().toString().equals("Deuteranomaly")){
                    mBinding.signInBtn.setBackgroundColor(getResources().getColor(R.color.Deuteranomaly));
                    Window window = RegistrationFragment.this.getActivity().getWindow();
                    window.setStatusBarColor(getResources().getColor(R.color.Deuteranomaly));
                    window.setNavigationBarColor(getResources().getColor(R.color.Deuteranomaly));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        mBinding.emptyName.setVisibility(View.INVISIBLE);
        mBinding.emptyPassword.setVisibility(View.INVISIBLE);
        //myThread = new MyThread();
        //new Thread(myThread).start();

        mBinding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mBinding.name.getText().toString().equals("") && !mBinding.Password.getText().toString().equals("")){
                    user.setName(mBinding.name.getText().toString());
                    user.setSurname(mBinding.surname.getText().toString());
                    user.setPassword(mBinding.Password.getText().toString());
                    user.setAccess(mBinding.spinner.getSelectedItem().toString());
                    RegistrationFragmentDirections.ActionRegistrationFragmentToHomeFragment action = RegistrationFragmentDirections.actionRegistrationFragmentToHomeFragment();
                    action.setAccessibility(user.getAccess());
                    Navigation.findNavController(view).navigate(action);
                }else if (mBinding.name.getText().toString().equals("") && mBinding.Password.getText().toString().equals("")){
                    mBinding.emptyName.setVisibility(View.VISIBLE);
                    mBinding.emptyPassword.setVisibility(View.VISIBLE);
                }else if (mBinding.name.getText().toString().equals("")){
                    mBinding.emptyPassword.setVisibility(View.INVISIBLE);
                    mBinding.emptyName.setVisibility(View.VISIBLE);
                }else if (mBinding.Password.getText().toString().equals("")){
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


}
