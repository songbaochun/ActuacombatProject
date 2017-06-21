package com.example.s.actuacombatproject.activitis;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.s.actuacombatproject.R;
import com.example.s.actuacombatproject.controlers.SubjectOneQuestionsController;
import com.example.s.actuacombatproject.databinding.ActivitySubjectOneQuestionsBinding;

import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by s on 17-6-21.
 */

public class SubjectOneQuestionsActivity extends Activity {
    private ActivitySubjectOneQuestionsBinding binding;
    private SubjectOneQuestionsController controller;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_subject_one_questions);
        try {
            controller = new SubjectOneQuestionsController(this, binding);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        binding.setController(controller);
    }
}
