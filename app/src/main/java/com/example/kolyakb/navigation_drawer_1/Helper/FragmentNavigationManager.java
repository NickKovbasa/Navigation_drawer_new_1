package com.example.kolyakb.navigation_drawer_1.Helper;

import android.support.v4.app.FragmentManager;

import com.example.kolyakb.navigation_drawer_1.Interface.NavigationManager;
import com.example.kolyakb.navigation_drawer_1.MainActivity;

public class FragmentNavigationManager implements NavigationManager {

    private static FragmentNavigationManager mInstance;

    private FragmentManager mFragmentManager;
    private MainActivity mainActivity;
    
    public static FragmentNavigationManager getmInstance (MainActivity mainActivity)
    {
        if (mInstance == null)
            mInstance = new FragmentNavigationManager();
        mInstance.configure(mainActivity);
        
        return mInstance;
    }

    private void configure(MainActivity mainActivity) {

        mainActivity = mainActivity;
        mFragmentManager = mainActivity.getSupportFragmentManager();
    }

    @Override
    public void showFragments(String title) {

    }
}
