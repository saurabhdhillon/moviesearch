package com.example.dhillon.moviesearch.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dhillon.moviesearch.MainActivity;
import com.example.dhillon.moviesearch.R;
import com.example.dhillon.moviesearch.model.SearchMovieResponse;

import java.util.ArrayList;
import java.util.List;

import simplifii.framework.asyncmanager.HttpParamObject;
import simplifii.framework.fragments.BaseFragment;
import simplifii.framework.utility.AppConstants;

/**
 * Created by Dhillon on 3/23/2017.
 */

public class SearchFragment extends BaseFragment {
    private Button btnSearch;
    private EditText etSearch, etYear, etType;
    private String SEARCHURL = "http://www.omdbapi.com/";
    private String title = "", year = "";
    private MainActivity mainActivity;
    private MoviesDetailFragment moviesDetailFragment;
    private String[] movies;
    private List<SearchMovieResponse> moviesList;
    private String type = "";
    private int noOfResponses = 0;

    @Override
    public void initViews() {
        initToolBar("Movie Search");
        etSearch = (EditText) findView(R.id.et_title);
        etYear = (EditText) findView(R.id.et_year);
        etType = (EditText) findView(R.id.et_type);
        btnSearch = (Button) findView(R.id.btn_search);
        moviesList = new ArrayList<>();
        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_search:
                if (isValid()) {
                    noOfResponses = 0;
                    moviesList.clear();
                    searchMovie();
                }
                break;
        }
    }

    private void searchMovie() {
        for (String str : movies) {
            HttpParamObject httpParamObject = new HttpParamObject();
            httpParamObject.setUrl(SEARCHURL);
            httpParamObject.addParameter("t", str.trim());
            httpParamObject.addParameter("y", year);
            httpParamObject.addParameter("type", type);
            httpParamObject.setJSONContentType();
            httpParamObject.setClassType(SearchMovieResponse.class);
            executeTask(AppConstants.TASKCODES.SEARCH_MOVIE, httpParamObject);
        }
    }


    private boolean isValid() {
        title = etSearch.getText().toString().trim();
        movies = title.split(",");
        year = etYear.getText().toString().trim();
        type = etType.getText().toString().toLowerCase().trim();
        if (movies.length == 0) {
            showToast("Please enter movie title");
            return false;
        }
        if (year.length() > 0 && year.length() != 4) {
            showToast("Please enter valid year");
            return false;
        }
        if (type.length() > 0) {
            if (type.compareTo("movie") != 0) {
                if (type.compareTo("serial") != 0) {
                    showToast("Type can be serial or movie");
                    return false;
                }

            }
        }
        return true;
    }

    @Override
    public void onPostExecute(Object response, int taskCode, Object... params) {
        super.onPostExecute(response, taskCode, params);
        if (null == response) {
            return;
        }
        switch (taskCode) {
            case AppConstants.TASKCODES.SEARCH_MOVIE:
                SearchMovieResponse searchMovieResponse = (SearchMovieResponse) response;
                if (searchMovieResponse.getResponse().toLowerCase().compareTo("true") == 0) {
                    moviesList.add(searchMovieResponse);
                } else {
                    if (!TextUtils.isEmpty(searchMovieResponse.getError()))
                        showToast(movies[noOfResponses] + " " + searchMovieResponse.getError());
                }
                noOfResponses++;
                if (noOfResponses == movies.length) {
                    MovieListFragment movieListFragment = MovieListFragment.getInstance(mainActivity, moviesList);
                    mainActivity.addFragment(movieListFragment, true);
                }
                break;

        }
    }

    @Override
    public int getViewID() {
        return R.layout.fragment_search;
    }

    public static SearchFragment getInstance(MainActivity mainActivity) {
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.mainActivity = mainActivity;
        return searchFragment;
    }
}
