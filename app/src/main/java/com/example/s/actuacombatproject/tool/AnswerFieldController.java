package com.example.s.actuacombatproject.tool;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.example.s.actuacombatproject.databinding.JudgeChoiceLayoutBinding;
import com.example.s.actuacombatproject.databinding.MultiselectChoiceLayoutBinding;
import com.example.s.actuacombatproject.databinding.SingleChoiceLayoutBinding;

/**
 * Created by s on 17-6-23.
 */

public class AnswerFieldController {
    private Context context;
    private Question currentQuestion;
    private View view;

    private SingleChoiceLayoutBinding choiceLayoutBinding;
    private JudgeChoiceLayoutBinding judgeChoiceLayoutBinding;
    private MultiselectChoiceLayoutBinding multiselectChoiceLayoutBinding;

    public AnswerFieldController(Context context, Question currentQuestion) {
        this.currentQuestion = currentQuestion;
        this.context = context;


        if (currentQuestion.getType().equals("single")) {

            choiceLayoutBinding = SingleChoiceLayoutBinding.inflate(LayoutInflater.from(getContext()));

            choiceLayoutBinding.rbA.setText(currentQuestion.getA());
            choiceLayoutBinding.rbB.setText(currentQuestion.getB());
            choiceLayoutBinding.rbC.setText(currentQuestion.getC());
            choiceLayoutBinding.rbD.setText(currentQuestion.getD());
            view = choiceLayoutBinding.getRoot();
        } else if (currentQuestion.getType().equals("judge")) {
            //       binding.answerContainer.removeAllViews();
            //    title.set(currentQuestion.getTitle());
            judgeChoiceLayoutBinding = JudgeChoiceLayoutBinding.inflate(LayoutInflater.from(getContext()));
            //    binding.answerContainer.addView(judgeChoiceLayoutBinding.getRoot());
            Glide.with(getContext()).load(currentQuestion.getImage()).into(judgeChoiceLayoutBinding.judgeIv);
            System.out.println("===========================" + currentQuestion.getImage());
            judgeChoiceLayoutBinding.judgeRbA.setText(currentQuestion.getA());
            judgeChoiceLayoutBinding.judgeRbB.setText(currentQuestion.getB());
            view = judgeChoiceLayoutBinding.getRoot();

        } else if (currentQuestion.getType().equals("multiselect")) {
            multiselectChoiceLayoutBinding = MultiselectChoiceLayoutBinding.inflate(LayoutInflater.from(getContext()));
            multiselectChoiceLayoutBinding.checkboxA.setText(currentQuestion.getA());
            multiselectChoiceLayoutBinding.checkboxB.setText(currentQuestion.getB());
            multiselectChoiceLayoutBinding.checkboxC.setText(currentQuestion.getC());
            multiselectChoiceLayoutBinding.checkboxD.setText(currentQuestion.getD());
            view = multiselectChoiceLayoutBinding.getRoot();

        }
    }

    public Context getContext() {
        return context;
    }

    public View getView() {
        return view;
    }

    public boolean isCorrect() {
        String answer = "";
        if (currentQuestion.getType().equals("single")) {
            RadioGroup radioGroup = choiceLayoutBinding.radioGroup;
            RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());

            if (radioButton == choiceLayoutBinding.rbA) {
                answer = "a";
            } else if (radioButton == choiceLayoutBinding.rbB) {
                answer = "b";
            } else if (radioButton == choiceLayoutBinding.rbC) {
                answer = "c";
            } else if (radioButton == choiceLayoutBinding.rbD) {
                answer = "d";
            }
            return answer.equals(currentQuestion.getAnswer());
        } else if (currentQuestion.getType().equals("judge")) {
            RadioGroup radioGroup = judgeChoiceLayoutBinding.judgeRadioGroup;
            RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());


            if (radioButton == judgeChoiceLayoutBinding.judgeRbA) {
                answer = "a";
            } else if (radioButton == judgeChoiceLayoutBinding.judgeRbB) {
                answer = "b";
            }
            return answer.equals(currentQuestion.getAnswer());
        } else if (currentQuestion.getType().equals("multiselect")) {
            StringBuffer stringBuffer = new StringBuffer();
            if (multiselectChoiceLayoutBinding.checkboxA.isChecked()) {
                answer = "a";
                stringBuffer.append(answer);
            }
            if (multiselectChoiceLayoutBinding.checkboxB.isChecked()) {
                answer = "b";
                stringBuffer.append(answer);
            }
            if (multiselectChoiceLayoutBinding.checkboxC.isChecked()) {
                answer = "c";
                stringBuffer.append(answer);
            }
            if (multiselectChoiceLayoutBinding.checkboxD.isChecked()) {
                answer = "d";
                stringBuffer.append(answer);
            }
            return stringBuffer.toString().endsWith(currentQuestion.getAnswer());
        }
        return true;
    }
}
