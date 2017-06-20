package com.example.s.actuacombatproject.activitis;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.s.actuacombatproject.R;
import com.example.s.actuacombatproject.controlers.QuestionsChoiceController;
import com.example.s.actuacombatproject.databinding.ActivityQuestionsChoiceBinding;

/**
 * Created by s on 17-6-19.
 * 题库选择
 */

public class QuestionsChoiceActivity extends Activity {
    private View view;
    private ActivityQuestionsChoiceBinding binding;
    private QuestionsChoiceController controller;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_questions_choice);
          controller=new QuestionsChoiceController(this,binding);
        binding.setController(controller);
    }
}
