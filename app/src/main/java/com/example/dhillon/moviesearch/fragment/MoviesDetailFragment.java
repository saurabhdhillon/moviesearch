package com.example.dhillon.moviesearch.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dhillon.moviesearch.MainActivity;
import com.example.dhillon.moviesearch.R;
import com.example.dhillon.moviesearch.model.SearchMovieResponse;
import com.squareup.picasso.Picasso;

import simplifii.framework.fragments.BaseFragment;

/**
 * Created by Dhillon on 3/23/2017.
 */

public class MoviesDetailFragment extends BaseFragment {
    private MainActivity mainActivity;
    private LinearLayout llLanguages, llCountries, llDescription;
    private RelativeLayout rlDirector, rlCast, rlGenre, rlRelease;
    private TextView tvCast, tvMovie, tvRelease, tvDescription, tvLanguages, tvCountries, tvGenre, tvDirector;
    private SearchMovieResponse searchMovieResponse;
    private StringBuilder titleBuilder;
    private ImageView ivPoster;

    @Override
    public void initViews() {
        initToolBar("Movie Title");
        findViews();
        titleBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(searchMovieResponse.getTitle()))
            titleBuilder.append(searchMovieResponse.getTitle());
        if (!TextUtils.isEmpty(searchMovieResponse.getYear()))
            titleBuilder.append(" (").append(searchMovieResponse.getYear()).append(")");
        if (titleBuilder != null) {
            tvMovie.setText(titleBuilder.toString());
            initToolBar(titleBuilder.toString());
        }
        if (!TextUtils.isEmpty(searchMovieResponse.getGenre()))
            tvGenre.setText(searchMovieResponse.getGenre());
        else
            rlGenre.setVisibility(View.GONE);

        if (!TextUtils.isEmpty(searchMovieResponse.getReleased()))
            tvRelease.setText(searchMovieResponse.getReleased());
        else
            rlRelease.setVisibility(View.GONE);

        if (!TextUtils.isEmpty(searchMovieResponse.getDirector()))
            tvDirector.setText(searchMovieResponse.getDirector());
        else rlDirector.setVisibility(View.GONE);

        if (!TextUtils.isEmpty(searchMovieResponse.getActors()))
            tvCast.setText(searchMovieResponse.getActors());
        else rlCast.setVisibility(View.GONE);

        if (!TextUtils.isEmpty(searchMovieResponse.getPlot()))
            tvDescription.setText(searchMovieResponse.getPlot());

        if (!TextUtils.isEmpty(searchMovieResponse.getLanguage()))
            tvLanguages.setText(searchMovieResponse.getLanguage());
        else llLanguages.setVisibility(View.GONE);

        if (!TextUtils.isEmpty(searchMovieResponse.getCountry()))
            tvCountries.setText(searchMovieResponse.getCountry());
        else llCountries.setVisibility(View.GONE);

        if (!TextUtils.isEmpty(searchMovieResponse.getPoster()))
            Picasso.with(mainActivity).load(searchMovieResponse.getPoster()).into(ivPoster);
    }

    private void findViews() {
        llLanguages = (LinearLayout) findView(R.id.ll_languages);
        llCountries = (LinearLayout) findView(R.id.ll_countries);
        llDescription = (LinearLayout) findView(R.id.ll_description);
        rlDirector = (RelativeLayout) findView(R.id.rl_director);
        rlRelease = (RelativeLayout) findView(R.id.rl_release);
        rlCast = (RelativeLayout) findView(R.id.rl_cast);
        rlGenre = (RelativeLayout) findView(R.id.rl_genre);
        tvCast = (TextView) findView(R.id.tv_cast);
        tvDescription = (TextView) findView(R.id.tv_description);
        tvDirector = (TextView) findView(R.id.tv_director);
        tvMovie = (TextView) findView(R.id.tv_title);
        tvRelease = (TextView) findView(R.id.tv_released);
        tvLanguages = (TextView) findView(R.id.tv_languages);
        tvCountries = (TextView) findView(R.id.tv_countries);
        tvGenre = (TextView) findView(R.id.tv_genre);
        ivPoster = (ImageView) findView(R.id.iv_poster);
    }

    @Override
    public int getViewID() {
        return R.layout.fragment_movie_detail;
    }

    public static MoviesDetailFragment getInstance(MainActivity mainActivity, SearchMovieResponse searchMovieResponse) {
        MoviesDetailFragment moviesDetailFragment = new MoviesDetailFragment();
        moviesDetailFragment.mainActivity = mainActivity;
        moviesDetailFragment.searchMovieResponse = searchMovieResponse;
        return moviesDetailFragment;
    }

}
