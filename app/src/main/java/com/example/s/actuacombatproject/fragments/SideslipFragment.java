package com.example.s.actuacombatproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.s.actuacombatproject.R;
import com.example.s.actuacombatproject.controlers.SideslipFragmentController;
import com.example.s.actuacombatproject.databinding.FragmentSideslipBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SideslipFragment extends Fragment {
    private FragmentSideslipBinding binding;
    private SideslipFragmentController controller;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sideslip, container, false);
        binding = FragmentSideslipBinding.bind(view);
        controller=new SideslipFragmentController(this,binding);
        binding.setController(controller);
        return view;
    }

}
