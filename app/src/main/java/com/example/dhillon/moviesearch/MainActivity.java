package com.example.dhillon.moviesearch;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.dhillon.moviesearch.fragment.SearchFragment;

import simplifii.framework.activity.BaseActivity;

/**
 * Created by Dhillon on 3/23/2017.
 */

public class MainActivity extends BaseActivity {
    private FragmentManager fragmentManager;
    private android.support.v4.app.FragmentTransaction fragmentTransaction;
    private SearchFragment searchFragment;


    private Boolean backPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        searchFragment = SearchFragment.getInstance(this);
        addFragment(searchFragment, true);
    }

    public void addFragment(Fragment fragment, boolean b) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (b) {
            fragmentTransaction.addToBackStack("home");
        } else {
            fragmentTransaction.addToBackStack("others");
        }
        fragmentTransaction.add(R.id.ll_container, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if (!backPressed) {
            if (fragmentManager.getBackStackEntryCount() > 1) {
                fragmentManager.popBackStack("others", 1);
            } else {
                showToast("Press back again to exit");
                setBackPressed(true);
            }
        } else {
            finish();
        }
    }

    public Boolean getBackPressed() {
        return backPressed;
    }

    public void setBackPressed(Boolean backPressed) {
        this.backPressed = backPressed;
    }

}
