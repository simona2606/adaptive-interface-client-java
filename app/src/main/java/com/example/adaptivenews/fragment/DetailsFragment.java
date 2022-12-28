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

import com.example.adaptivenews.R;
import com.example.adaptivenews.api.models.NewsHeadlines;
import com.example.adaptivenews.databinding.FragmentDetailsBinding;
import com.example.adaptivenews.databinding.FragmentHomeBinding;
import com.squareup.picasso.Picasso;

public class DetailsFragment extends Fragment {
    NewsHeadlines headlines;
    private FragmentDetailsBinding mBinding;
    private String access = new String();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentDetailsBinding.inflate(inflater, container, false);

        DetailsFragmentArgs args = DetailsFragmentArgs.fromBundle(getArguments());
        headlines = args.getHeadlines();
        access = args.getAccessibility();
        mBinding.textDetailTitle.setText(headlines.getTitle());
        mBinding.textDetailAuthor.setText(headlines.getAuthor());

        if (access.equals("Deuteranopia")){
            mBinding.textDetailAuthor.setTextColor(getResources().getColor(R.color.secondary_text_deuteranopia));
        }else if (access.equals("Monochromacy")){
            mBinding.textDetailAuthor.setTextColor(getResources().getColor(R.color.secondary_text_mono));
        }else if (access.equals("Deuteranomaly")){
            mBinding.textDetailAuthor.setTextColor(getResources().getColor(R.color.secondary_text_deuteranomaly));
        }else if (access.equals("Low vision")){
            mBinding.textDetailTitle.setTextSize(18);
            mBinding.textDetailAuthor.setTextSize(18);
            mBinding.textDetailTime.setTextSize(18);
            mBinding.textDetailDetail.setTextSize(18);
            mBinding.textDetailContent.setTextSize(18);
        }
        mBinding.textDetailTime.setText(headlines.getPublishedAt());
        mBinding.textDetailDetail.setText(headlines.getDescription());
        mBinding.textDetailContent.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(mBinding.imgDetailNews);

        return mBinding.getRoot();
    }

}
