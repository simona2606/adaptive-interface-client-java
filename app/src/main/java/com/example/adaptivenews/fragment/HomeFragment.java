package com.example.adaptivenews.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adaptivenews.R;
import com.example.adaptivenews.adapters.CustomAdapter;
import com.example.adaptivenews.api.OnFetchDataListener;
import com.example.adaptivenews.api.RequestManager;
import com.example.adaptivenews.api.models.NewsApiResponse;
import com.example.adaptivenews.api.models.NewsHeadlines;
import com.example.adaptivenews.api.SelectListener;
import com.example.adaptivenews.databinding.FragmentHomeBinding;
import com.example.adaptivenews.databinding.FragmentLogInBinding;

import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment implements SelectListener, View.OnClickListener{

    private FragmentHomeBinding mBinding;
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;
    private String access = new String();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false);
        HomeFragmentArgs args = HomeFragmentArgs.fromBundle(getArguments());
        access = args.getAccessibility();

        mBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Fetching news articles of " + query);
                dialog.show();
                RequestManager manager = new RequestManager(container.getContext());
                manager.getNewsHeadlines(listener, "general", query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        mBinding.exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(requireView()).navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment());

            }
        });
        dialog = new ProgressDialog(container.getContext());
        dialog.setTitle("Fetching news articles..");
        dialog.show();

        mBinding.btn1.setOnClickListener(this);
        mBinding.btn2.setOnClickListener(this);
        mBinding.btn3.setOnClickListener(this);
        mBinding.btn4.setOnClickListener(this);
        mBinding.btn5.setOnClickListener(this);
        mBinding.btn6.setOnClickListener(this);
        mBinding.btn7.setOnClickListener(this);

        if (access.equals("Deuteranopia")){
            mBinding.btn1.setBackgroundColor(getResources().getColor(R.color.primary_deuteranopia));
            mBinding.btn2.setBackgroundColor(getResources().getColor(R.color.primary_deuteranopia));
            mBinding.btn3.setBackgroundColor(getResources().getColor(R.color.primary_deuteranopia));
            mBinding.btn4.setBackgroundColor(getResources().getColor(R.color.primary_deuteranopia));
            mBinding.btn5.setBackgroundColor(getResources().getColor(R.color.primary_deuteranopia));
            mBinding.btn6.setBackgroundColor(getResources().getColor(R.color.primary_deuteranopia));
            mBinding.btn7.setBackgroundColor(getResources().getColor(R.color.primary_deuteranopia));
            mBinding.exitButton.setBackgroundColor(getResources().getColor(R.color.primary_deuteranopia));

            mBinding.btn1.setTextSize(14);
            mBinding.btn2.setTextSize(14);
            mBinding.btn3.setTextSize(14);
            mBinding.btn4.setTextSize(14);
            mBinding.btn5.setTextSize(14);
            mBinding.btn6.setTextSize(14);
            mBinding.btn7.setTextSize(14);
        }else if (access.equals("Monochromacy")){
            mBinding.btn1.setBackgroundColor(getResources().getColor(R.color.primary_mono));
            mBinding.btn2.setBackgroundColor(getResources().getColor(R.color.primary_mono));
            mBinding.btn3.setBackgroundColor(getResources().getColor(R.color.primary_mono));
            mBinding.btn4.setBackgroundColor(getResources().getColor(R.color.primary_mono));
            mBinding.btn5.setBackgroundColor(getResources().getColor(R.color.primary_mono));
            mBinding.btn6.setBackgroundColor(getResources().getColor(R.color.primary_mono));
            mBinding.btn7.setBackgroundColor(getResources().getColor(R.color.primary_mono));
            mBinding.exitButton.setBackgroundColor(getResources().getColor(R.color.primary_mono));

            mBinding.btn1.setTextSize(14);
            mBinding.btn2.setTextSize(14);
            mBinding.btn3.setTextSize(14);
            mBinding.btn4.setTextSize(14);
            mBinding.btn5.setTextSize(14);
            mBinding.btn6.setTextSize(14);
            mBinding.btn7.setTextSize(14);
        }else if (access.equals("Deuteranomaly")){
            mBinding.btn1.setBackgroundColor(getResources().getColor(R.color.primary_deuteranomaly));
            mBinding.btn2.setBackgroundColor(getResources().getColor(R.color.primary_deuteranomaly));
            mBinding.btn3.setBackgroundColor(getResources().getColor(R.color.primary_deuteranomaly));
            mBinding.btn4.setBackgroundColor(getResources().getColor(R.color.primary_deuteranomaly));
            mBinding.btn5.setBackgroundColor(getResources().getColor(R.color.primary_deuteranomaly));
            mBinding.btn6.setBackgroundColor(getResources().getColor(R.color.primary_deuteranomaly));
            mBinding.btn7.setBackgroundColor(getResources().getColor(R.color.primary_deuteranomaly));
            mBinding.exitButton.setBackgroundColor(getResources().getColor(R.color.primary_deuteranomaly));

            mBinding.btn1.setTextSize(14);
            mBinding.btn2.setTextSize(14);
            mBinding.btn3.setTextSize(14);
            mBinding.btn4.setTextSize(14);
            mBinding.btn5.setTextSize(14);
            mBinding.btn6.setTextSize(14);
            mBinding.btn7.setTextSize(14);
        }else if (access.equals("Low vision")){

            mBinding.btn1.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.btn2.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.btn3.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.btn4.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.btn5.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.btn6.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.btn7.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.exitButton.setBackgroundColor(getResources().getColor(R.color.primary));

            mBinding.btn1.setTextSize(18);
            mBinding.btn2.setTextSize(18);
            mBinding.btn3.setTextSize(18);
            mBinding.btn4.setTextSize(18);
            mBinding.btn5.setTextSize(18);
            mBinding.btn6.setTextSize(18);
            mBinding.btn7.setTextSize(18);

        }else{
            mBinding.btn1.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.btn2.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.btn3.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.btn4.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.btn5.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.btn6.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.btn7.setBackgroundColor(getResources().getColor(R.color.primary));
            mBinding.exitButton.setBackgroundColor(getResources().getColor(R.color.primary));

        }

        RequestManager manager = new RequestManager(container.getContext());
        manager.getNewsHeadlines(listener, "general", null);

        return mBinding.getRoot();
    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            if (list.isEmpty()) {
                Toast.makeText(getContext(), "No data found!", Toast.LENGTH_SHORT).show();
            } else {
                showNews(list);
                dialog.dismiss();
            }
        }

        @Override
        public void onError(String message) {
            Toast.makeText(getContext(), "An Error Occurred!", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = mBinding.recyclerMain;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        adapter = new CustomAdapter(getContext(), list, this,access);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClicked(NewsHeadlines headlines) {
        HomeFragmentDirections.ActionHomeFragmentToDetailsFragment action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(headlines);
        action.setHeadlines(headlines);
        action.setAccessibility(access);
        Navigation.findNavController(requireView()).navigate(action);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String category = button.getText().toString();
        dialog.setTitle("Fetching news articles of " + category);
        dialog.show();
        RequestManager manager = new RequestManager(getContext());
        manager.getNewsHeadlines(listener, category, null);

    }
}
