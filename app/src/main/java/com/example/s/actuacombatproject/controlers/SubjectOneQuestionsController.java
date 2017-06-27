package com.example.s.actuacombatproject.controlers;

import android.content.res.AssetManager;
import android.view.View;

import com.example.s.actuacombatproject.activitis.SubjectOneQuestionsActivity;
import com.example.s.actuacombatproject.base.Questions;
import com.example.s.actuacombatproject.databinding.ActivitySubjectOneQuestionsBinding;
import com.example.s.actuacombatproject.tool.AnswerFieldController;
import com.example.s.actuacombatproject.tool.Question;
import com.example.s.actuacombatproject.tool.QuestionReaderUtil;

import org.xml.sax.SAXException;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;


/**
 * Created by s on 17-6-21.
 */

public class SubjectOneQuestionsController implements View.OnClickListener {
    private SubjectOneQuestionsActivity subjectOneQuestionsActivity;
    private ActivitySubjectOneQuestionsBinding binding;
    private List<Question> questions;
    private Question currentQuestion;
    private AnswerFieldController currentAnswerFieldController=null;
    public SubjectOneQuestionsController(final SubjectOneQuestionsActivity subjectOneQuestionsActivity, final ActivitySubjectOneQuestionsBinding binding) throws ParserConfigurationException {
        this.subjectOneQuestionsActivity = subjectOneQuestionsActivity;
        this.binding = binding;
        try {
            questions = QuestionReaderUtil.read(subjectOneQuestionsActivity);
            System.out.println("===================="+questions);
            showRandomQuestion();
        } catch (SAXException e) {
            e.printStackTrace();
        }
  binding.button.setOnClickListener(this);
    }
    private void showRandomQuestion() {
       binding.questionDescription.setText("");
        currentQuestion = questions.get((int) (Math.random() * questions.size()));
        binding.questionTitle.setText(currentQuestion.getTitle());
        binding.answerContainer.removeAllViews();
        currentAnswerFieldController = new AnswerFieldController(subjectOneQuestionsActivity, currentQuestion);
        binding.answerContainer.addView(currentAnswerFieldController.getView());

    }

    @Override
    public void onClick(View v) {
        if (currentAnswerFieldController.isCorrect()) {
            showRandomQuestion();
            binding.questionDescription.setText("");
        } else {
            binding.questionDescription.setText("试题分析："+currentQuestion.getDescription());
        }
    }
}
