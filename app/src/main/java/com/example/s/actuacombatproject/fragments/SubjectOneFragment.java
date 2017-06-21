package com.example.s.actuacombatproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.s.actuacombatproject.R;
import com.example.s.actuacombatproject.abstracts.BaseFragment;
import com.example.s.actuacombatproject.controlers.SubjectOneFragmentController;
import com.example.s.actuacombatproject.databinding.FragmentSubjectOneBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectOneFragment extends BaseFragment {
    private View view;
    private FragmentSubjectOneBinding binding;
    private SubjectOneFragmentController controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_subject_one, container, false);
        binding = FragmentSubjectOneBinding.bind(view);
        controller = new SubjectOneFragmentController(this, binding);
        binding.setController(controller);

        return view;
    }

    @Override
    public String getTitle() {
        return "科一";
    }
}
