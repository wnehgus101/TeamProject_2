package com.example.ui_project;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TapPageAdapter extends FragmentStateAdapter {


    private int tabCount;

    public TapPageAdapter(FragmentManager fm, int tabCount){
        super(fm.getPrimaryNavigationFragment());
        this.tabCount = tabCount;
    }
    @Override
    public Fragment createFragment(int position) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
