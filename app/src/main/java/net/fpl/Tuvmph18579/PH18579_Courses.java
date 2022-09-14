package net.fpl.Tuvmph18579;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import net.fpl.Tuvmph18579.Adapter.CoursesViewpagerAdapter;


public class PH18579_Courses extends AppCompatActivity {
    public static ViewPager viewPager;
    CoursesViewpagerAdapter coursesViewpagerAdapter;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph18579_courses);
        viewPager = findViewById(R.id.viewpager1);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        coursesViewpagerAdapter = new CoursesViewpagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(coursesViewpagerAdapter);
//        khi vuot view pager sẽ thay đổi icon ở bottomNavigationView
        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.nav_courses_info).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.nav_courses_my).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        khi click bottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_courses_info:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.nav_courses_my:
                        viewPager.setCurrentItem(1);
                        break;
                }
                return false;
            }
        });

    }
}