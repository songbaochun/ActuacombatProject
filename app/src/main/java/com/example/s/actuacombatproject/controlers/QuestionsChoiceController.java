package com.example.s.actuacombatproject.controlers;

import android.content.Intent;
import android.view.View;

import com.example.s.actuacombatproject.activitis.CityChoiceActivity;
import com.example.s.actuacombatproject.activitis.MainActivity;
import com.example.s.actuacombatproject.activitis.QuestionsChoiceActivity;
import com.example.s.actuacombatproject.databinding.ActivityQuestionsChoiceBinding;

/**
 * Created by s on 17-6-19.
 */

public class QuestionsChoiceController {
    private QuestionsChoiceActivity questionsChoiceActivity;
    private ActivityQuestionsChoiceBinding binding;

    public QuestionsChoiceController(final QuestionsChoiceActivity questionsChoiceActivity, ActivityQuestionsChoiceBinding binding) {
        this.questionsChoiceActivity = questionsChoiceActivity;
        this.binding = binding;
        binding.questionsReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(questionsChoiceActivity, MainActivity.class);
                questionsChoiceActivity.startActivity(in);
            }
        });
        binding.btnquding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(questionsChoiceActivity, CityChoiceActivity.class);
                questionsChoiceActivity.startActivity(intent);
            }
        });
    }
}
