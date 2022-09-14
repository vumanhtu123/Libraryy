package net.fpl.Tuvmph18579.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import net.fpl.Tuvmph18579.Fragment.Fragment_one;
import net.fpl.Tuvmph18579.Fragment.Fragment_three;
import net.fpl.Tuvmph18579.Fragment.Fragment_two;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Fragment_one();
            case 1:
                return new Fragment_two();
            case 2:
                return new Fragment_three();
            default:
                return new Fragment_one();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
