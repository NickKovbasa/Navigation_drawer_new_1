package com.example.kolyakb.navigation_drawer_1.Helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.kolyakb.navigation_drawer_1.BuildConfig;
import com.example.kolyakb.navigation_drawer_1.Fragments.FragmentContent;
import com.example.kolyakb.navigation_drawer_1.Interface.NavigationManager;
import com.example.kolyakb.navigation_drawer_1.MainActivity;
import com.example.kolyakb.navigation_drawer_1.R;

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

       showFragments(FragmentContent.newInstance(title), false);


    }

    private void showFragments(Fragment fragmentContent, boolean b) {
        FragmentManager fm = mFragmentManager;
        FragmentTransaction ft = fm.beginTransaction().replace(R.id.container, fragmentContent);
        ft.addToBackStack(null);
        if (b || !BuildConfig.DEBUG)
            ft.commitAllowingStateLoss();
        else
            ft.commit();
        fm.executePendingTransactions();
    }
}
