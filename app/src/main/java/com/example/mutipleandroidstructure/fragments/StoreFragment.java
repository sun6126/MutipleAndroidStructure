package com.example.mutipleandroidstructure.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.mutipleandroidstructure.R;
import com.example.mutipleandroidstructure.databinding.FragmentStoreBinding;


public class StoreFragment extends Fragment {

    private FragmentStoreBinding viewDataBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_store, container, false);
        return viewDataBinding.getRoot();
    }

}
