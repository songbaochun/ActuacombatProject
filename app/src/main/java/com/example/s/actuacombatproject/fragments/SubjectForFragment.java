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
 */
public class SubjectForFragment extends BaseFragment {


    public SubjectForFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subject_for, container, false);
    }

    @Override
    public String getTitle() {
        return "科四";
    }
}
