package com.example.s.actuacombatproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.s.actuacombatproject.R;
import com.example.s.actuacombatproject.abstracts.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 *  报名页面
 */
public class SignUpFragment extends BaseFragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_signup, container, false);
        return view;
    }

    @Override
    public String getTitle() {
        return "报名";
    }
}
