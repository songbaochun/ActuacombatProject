package com.example.s.actuacombatproject.controlers;

import android.content.Intent;
import android.view.View;

import com.example.s.actuacombatproject.activitis.SubjectOneQuestionsActivity;
import com.example.s.actuacombatproject.databinding.FragmentSubjectOneBinding;
import com.example.s.actuacombatproject.fragments.SubjectOneFragment;

/**
 * Created by s on 17-6-21.
 */

public class SubjectOneFragmentController {
    private FragmentSubjectOneBinding binding;
    private SubjectOneFragment subjectOneFragment;
    public SubjectOneFragmentController(final SubjectOneFragment subjectOneFragment, FragmentSubjectOneBinding binding) {
       this.subjectOneFragment=subjectOneFragment;
        this.binding=binding;

        binding.btnSubjectOneQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(subjectOneFragment.getContext(), SubjectOneQuestionsActivity.class);
                  subjectOneFragment.startActivity(intent);
            }
        });
    }
}
