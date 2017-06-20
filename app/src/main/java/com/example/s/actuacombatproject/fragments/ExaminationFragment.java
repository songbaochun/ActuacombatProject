package com.example.s.actuacombatproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.s.actuacombatproject.R;
import com.example.s.actuacombatproject.databinding.FragmentExaminationBinding;

/**
 * A simple {@link Fragment} subclass.
 * 考试的fragment
 */
public class ExaminationFragment extends Fragment {
    private View view;
    private FragmentExaminationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_examination, container, false);
        binding = FragmentExaminationBinding.bind(view);
        return view;
    }

}
