package com.example.mutipleandroidstructure.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mutipleandroidstructure.R;
import com.example.mutipleandroidstructure.adapter.HomePagerAdapter;
import com.example.mutipleandroidstructure.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private FragmentHomeBinding viewDataBinding;
    private ArrayList<Fragment> fragments;
    private boolean clickedFlag = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        initView();
        initData();
        initListener();
        return viewDataBinding.getRoot();
    }

    private void initView() {
        // 初始化碎片
        fragments = new ArrayList<>();
        NewsFragment newsFragment = new NewsFragment();
        StoreFragment storeFragment = new StoreFragment();
        AboutFragment aboutFragment = new AboutFragment();
        fragments.add(newsFragment);
        fragments.add(storeFragment);
        fragments.add(aboutFragment);


    }

    private void initData() {

    }

    private void initListener() {
        viewDataBinding.btnTitleNews.setOnClickListener(this);
        viewDataBinding.btnTitleStore.setOnClickListener(this);
        viewDataBinding.btnTitleAbout.setOnClickListener(this);
        viewDataBinding.vpHome.setAdapter(new HomePagerAdapter(getActivity().getSupportFragmentManager(), fragments));

        viewDataBinding.vpHome.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (!clickedFlag) {
                    switch (position) {
                        case 0:
                            viewDataBinding.btnTitleNews.setChecked(true);
                            break;
                        case 1:
                            viewDataBinding.btnTitleStore.setChecked(true);
                            break;
                        case 2:
                            viewDataBinding.btnTitleAbout.setChecked(true);
                            break;
                    }
                } else {
                    clickedFlag = false;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_title_news:
                viewDataBinding.vpHome.setCurrentItem(0);
                break;
            case R.id.btn_title_store:
                viewDataBinding.vpHome.setCurrentItem(1);
                break;
            case R.id.btn_title_about:
                viewDataBinding.vpHome.setCurrentItem(2);
                break;
        }
        clickedFlag = true;
    }
}
