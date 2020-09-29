package com.example.mutipleandroidstructure;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mutipleandroidstructure.databinding.ActivityPrimaryBinding;
import com.example.mutipleandroidstructure.fragments.CenterFragment;
import com.example.mutipleandroidstructure.fragments.HomeFragment;
import com.example.mutipleandroidstructure.fragments.MoreFragment;
import com.example.mutipleandroidstructure.fragments.PlayFragment;

import java.util.ArrayList;

public class PrimaryActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityPrimaryBinding viewDataBinding;
    private FragmentManager supportFragmentManager;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_primary);
        initView();
        initData();
        initListener();
    }

    private void initData() {
        HomeFragment homeFragment = new HomeFragment();
        PlayFragment playFragment = new PlayFragment();
        MoreFragment moreFragment = new MoreFragment();
        CenterFragment centerFragment = new CenterFragment();
        fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(playFragment);
        fragments.add(moreFragment);
        fragments.add(centerFragment);

        showFragment(0);
    }

    private void showFragment(int index) {
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        for (Fragment fragment : fragments) {
            transaction.hide(fragment);
        }
        if (fragments.get(index).isAdded()) {
            transaction.show(fragments.get(index));
        } else {
            transaction.add(R.id.fl_content, fragments.get(index));
            transaction.show(fragments.get(index));
        }
        transaction.commitNow();
    }

    private void initListener() {
        viewDataBinding.btnHome.setOnClickListener(this);
        viewDataBinding.btnPlay.setOnClickListener(this);
        viewDataBinding.btnMore.setOnClickListener(this);
        viewDataBinding.btnCenter.setOnClickListener(this);
    }

    private void initView() {
        supportFragmentManager = getSupportFragmentManager();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_home:
                showFragment(0);
                break;
            case R.id.btn_play:
                showFragment(1);
                break;
            case R.id.btn_more:
                showFragment(2);
                break;
            case R.id.btn_center:
                showFragment(3);
                break;
        }
    }
}
