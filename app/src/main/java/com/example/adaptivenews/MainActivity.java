package com.example.adaptivenews;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adaptivenews.adapters.CustomAdapter;
import com.example.adaptivenews.api.OnFetchDataListener;
import com.example.adaptivenews.api.RequestManager;
import com.example.adaptivenews.api.SelectListener;
import com.example.adaptivenews.api.models.NewsApiResponse;
import com.example.adaptivenews.api.models.NewsHeadlines;
import com.example.adaptivenews.databinding.ActivityMainBinding;
import com.example.adaptivenews.fragment.LogInFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }


}
