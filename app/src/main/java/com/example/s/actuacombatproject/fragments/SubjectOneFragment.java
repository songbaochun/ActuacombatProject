package com.example.s.actuacombatproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.s.actuacombatproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectOneFragment extends Fragment {
   private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_subject_one, container, false);
        return view;
    }

}
