package com.example.adaptivenews.fragment;

import static android.content.Intent.getIntent;

import android.graphics.ColorMatrixColorFilter;
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
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(DEUTERANOPIA);
            mBinding.imgDetailNews.setColorFilter(filter);
        }else if (access.equals("Monochromacy")){
            mBinding.textDetailAuthor.setTextColor(getResources().getColor(R.color.secondary_text_mono));
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(ACROMATOPSIA);
            mBinding.imgDetailNews.setColorFilter(filter);
        }else if (access.equals("Deuteranomaly")){
            mBinding.textDetailAuthor.setTextColor(getResources().getColor(R.color.secondary_text_deuteranomaly));
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(Deuteranomaly);
            mBinding.imgDetailNews.setColorFilter(filter);
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
