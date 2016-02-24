package com.smallnew.fucardpager;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.smallnew.fucardpager.view.CenterViewPager;
import com.smallnew.fucardpager.view.CenterViewPagerAdapter;
import com.smallnew.fucardpager.view.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FuPagerActivity extends AppCompatActivity {

    private CenterViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fu_pager);
        viewPager = (CenterViewPager)this.findViewById(R.id.centerViewPager);
        initPager();
    }

    private void initPager() {
        List<View> views = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            View card = new View(this);
            card.setBackgroundColor(getRandomColor());
            card.setTag(i);
            views.add(card);
        }
        CenterViewPagerAdapter adapter = new CenterViewPagerAdapter(this, views);
        viewPager.setAdapter(adapter);
        viewPager.enableCenterLockOfChilds();
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
