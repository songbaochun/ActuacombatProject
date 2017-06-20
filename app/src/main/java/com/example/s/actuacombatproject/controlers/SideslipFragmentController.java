package com.example.s.actuacombatproject.controlers;

import android.content.Intent;
import android.view.View;

import com.example.s.actuacombatproject.R;
import com.example.s.actuacombatproject.activitis.QuestionsChoiceActivity;
import com.example.s.actuacombatproject.databinding.FragmentSideslipBinding;
import com.example.s.actuacombatproject.fragments.SideslipFragment;

/**
 * Created by s on 17-6-20.
 */

public class SideslipFragmentController implements View.OnClickListener {
    private SideslipFragment sideslipFragment;
    private FragmentSideslipBinding binding;

    public SideslipFragmentController(SideslipFragment sideslipFragment, FragmentSideslipBinding binding) {
        this.sideslipFragment = sideslipFragment;
        this.binding = binding;

        binding.sideslipLinearLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sideslipLinearLayout:
                Intent intent = new Intent(sideslipFragment.getContext(), QuestionsChoiceActivity.class);
                sideslipFragment.startActivity(intent);
                break;

        }
    }
}
