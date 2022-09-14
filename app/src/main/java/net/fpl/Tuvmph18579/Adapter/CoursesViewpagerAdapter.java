package net.fpl.Tuvmph18579.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import net.fpl.Tuvmph18579.Fragment_Screen.PH18579_DangKiMonHoc;
import net.fpl.Tuvmph18579.Fragment_Screen.PH18579_MonHocDaDangKi;

public class CoursesViewpagerAdapter extends FragmentStatePagerAdapter {
    public CoursesViewpagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
               return new PH18579_DangKiMonHoc();
            case 1:
               return new PH18579_MonHocDaDangKi();
            default:
                return new PH18579_DangKiMonHoc();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
