package com.example.dhillon.moviesearch.fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dhillon.moviesearch.MainActivity;
import com.example.dhillon.moviesearch.R;
import com.example.dhillon.moviesearch.model.SearchMovieResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import simplifii.framework.ListAdapters.CustomListAdapter;
import simplifii.framework.ListAdapters.CustomListAdapterInterface;
import simplifii.framework.fragments.BaseFragment;

/**
 * Created by Dhillon on 3/23/2017.
 */

public class MovieListFragment extends BaseFragment implements CustomListAdapterInterface, AdapterView.OnItemClickListener {
    private MainActivity mainActivity;
    private List<SearchMovieResponse> moviesList = new ArrayList<>();
    private CustomListAdapter customListAdapter;
    private ListView listView;
    private TextView tvEmpty;

    @Override
    public void initViews() {
        initToolBar("Movies List");
        findViews();
    }

    private void findViews() {
        customListAdapter = new CustomListAdapter(getActivity(), R.layout.row_movie, moviesList, this);
        listView = (ListView) findView(R.id.lv_movies);
        tvEmpty = (TextView) findView(R.id.tv_empty);
        listView.setAdapter(customListAdapter);
        listView.setEmptyView(tvEmpty);
        listView.setOnItemClickListener(this);
    }

    @Override
    public int getViewID() {
        return R.layout.fragment_movies_list;
    }

    public static MovieListFragment getInstance(MainActivity mainActivity, List<SearchMovieResponse> moviesList) {
        MovieListFragment movieListFragment = new MovieListFragment();
        movieListFragment.moviesList.clear();
        movieListFragment.moviesList.addAll(moviesList);
        movieListFragment.mainActivity = mainActivity;
        return movieListFragment;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent, int resourceID, LayoutInflater inflater) {
        Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(resourceID, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        SearchMovieResponse searchMovieResponse = moviesList.get(position);
        StringBuilder titleBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(searchMovieResponse.getTitle()))
            titleBuilder.append(searchMovieResponse.getTitle());
        if (!TextUtils.isEmpty(searchMovieResponse.getYear()))
            titleBuilder.append(" (").append(searchMovieResponse.getYear()).append(")");
        if (titleBuilder != null) {
            holder.tvName.setText(titleBuilder.toString());
        }
        if (!TextUtils.isEmpty(searchMovieResponse.getGenre()))
            holder.tvGenre.setText(searchMovieResponse.getGenre());

        if (!TextUtils.isEmpty(searchMovieResponse.getReleased()))
            holder.tvRelease.setText(searchMovieResponse.getReleased());

        if (!TextUtils.isEmpty(searchMovieResponse.getDirector()))
            holder.tvDirector.setText(searchMovieResponse.getDirector());

        if (!TextUtils.isEmpty(searchMovieResponse.getActors()))
            holder.tvCast.setText(searchMovieResponse.getActors());

        if (!TextUtils.isEmpty(searchMovieResponse.getPoster()))
            Picasso.with(getActivity()).load(searchMovieResponse.getPoster()).into(holder.ivPoster);

        return convertView;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MoviesDetailFragment moviesDetailFragment = MoviesDetailFragment.getInstance(mainActivity, moviesList.get(position));
        mainActivity.addFragment(moviesDetailFragment, false);
    }

    class Holder {
        TextView tvName, tvGenre, tvCast, tvRelease, tvDirector;
        ImageView ivPoster;

        public Holder(View v) {
            tvCast = (TextView) v.findViewById(R.id.tv_cast);
            tvDirector = (TextView) v.findViewById(R.id.tv_director);
            tvName = (TextView) v.findViewById(R.id.tv_title);
            tvRelease = (TextView) v.findViewById(R.id.tv_released);
            tvGenre = (TextView) v.findViewById(R.id.tv_genre);
            ivPoster = (ImageView) v.findViewById(R.id.iv_poster);

        }
    }
}
