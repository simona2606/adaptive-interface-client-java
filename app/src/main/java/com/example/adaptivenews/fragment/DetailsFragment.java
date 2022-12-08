package com.example.adaptivenews.fragment;

import static android.content.Intent.getIntent;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.adaptivenews.api.models.NewsHeadlines;
import com.example.adaptivenews.databinding.FragmentDetailsBinding;
import com.example.adaptivenews.databinding.FragmentHomeBinding;
import com.squareup.picasso.Picasso;

public class DetailsFragment extends Fragment {
    NewsHeadlines headlines;
    private FragmentDetailsBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentDetailsBinding.inflate(inflater, container, false);

        DetailsFragmentArgs args = DetailsFragmentArgs.fromBundle(getArguments());
        headlines = args.getHeadlines();
        mBinding.textDetailTitle.setText(headlines.getTitle());
        mBinding.textDetailAuthor.setText(headlines.getAuthor());
        mBinding.textDetailTime.setText(headlines.getPublishedAt());
        mBinding.textDetailDetail.setText(headlines.getDescription());
        mBinding.textDetailContent.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(mBinding.imgDetailNews);

        return mBinding.getRoot();
    }

}
