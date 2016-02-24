package com.smallnew.fucardpager.view;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CenterViewPagerAdapter<T extends View> extends PagerAdapter {

    Context mContext;
    List<T> views;

    public CenterViewPagerAdapter(Context context, List<T> views) {
        this.mContext = context;
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public float getPageWidth(int position) {
        return 0.8f;
    }


    public void addView(T view, CenterViewPager pager) {
        views.add(view);
        notifyDataSetChanged();
        pager.setCurrentItem(getCount(), true);
    }

    public void removeView(int index, CenterViewPager pager) {
        views.remove(index);

        notifyDataSetChanged();
        int position = getCount();
        if (index < getCount() - 1) {
            position = index;
        }
        pager.setCurrentItem(position, true);
    }

    public void removeView(T view, CenterViewPager pager) {
        int index = views.indexOf(view);
        views.remove(view);
        notifyDataSetChanged();
        int position = getCount();
        if (index < getCount() - 1) {
            position = index;
        }
        pager.setCurrentItem(position, true);
    }


}

