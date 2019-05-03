package com.example.tablayoutdemo;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener, Fragment2.OnFragmentInteractionListener, Fragment3.OnFragmentInteractionListener, Fragment4.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tablayout);

        tabLayout.addTab(tabLayout.newTab().setText("TAB1"));
        tabLayout.addTab(tabLayout.newTab().setText("TAB2"));
        tabLayout.addTab(tabLayout.newTab().setText("TAB3"));
        tabLayout.addTab(tabLayout.newTab().setText("TAB4"));

        final ViewPager viewPager = findViewById(R.id.viewpager);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
      tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
          @Override
          public void onTabSelected(TabLayout.Tab tab) {
              viewPager.setCurrentItem(tab.getPosition());
          }

          @Override
          public void onTabUnselected(TabLayout.Tab tab) {
          }

          @Override
          public void onTabReselected(TabLayout.Tab tab) {

          }
      });



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
