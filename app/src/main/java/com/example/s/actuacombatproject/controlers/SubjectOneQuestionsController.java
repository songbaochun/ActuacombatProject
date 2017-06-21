package com.example.s.actuacombatproject.controlers;

import android.content.res.AssetManager;
import android.view.View;
import android.widget.Toast;

import com.example.s.actuacombatproject.activitis.SubjectOneQuestionsActivity;
import com.example.s.actuacombatproject.base.Questions;
import com.example.s.actuacombatproject.databinding.ActivitySubjectOneQuestionsBinding;
import com.example.s.actuacombatproject.tool.OneQuestionsReader;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by s on 17-6-21.
 */

public class SubjectOneQuestionsController {
    private SubjectOneQuestionsActivity subjectOneQuestionsActivity;
    private ActivitySubjectOneQuestionsBinding binding;
    private String title, a, b, c, d, answer, type;
    private List<Questions> lis=new ArrayList<>();

    public SubjectOneQuestionsController(final SubjectOneQuestionsActivity subjectOneQuestionsActivity, final ActivitySubjectOneQuestionsBinding binding) throws ParserConfigurationException {
        this.subjectOneQuestionsActivity = subjectOneQuestionsActivity;
        this.binding = binding;
        AssetManager assets = subjectOneQuestionsActivity.getAssets();
        InputStream open = null;
        try {
            open = assets.open("onequestion.xml");

            OneQuestionsReader oneQuestionsReader = new OneQuestionsReader(subjectOneQuestionsActivity, open);
            List<Questions> questions = oneQuestionsReader.getQuestions();

            for (Questions q : questions) {
                title = q.getTitle();
                a = q.getA();
                b = q.getB();
                c = q.getC();
                d = q.getD();
                answer = q.getAnswer();
                type=q.getType();
                if (type.equals("duo")){
                    binding.radio.setVisibility(View.GONE);
                    binding.duo.setVisibility(View.VISIBLE);
                    lis.add(new Questions(title,a,b,c,d,answer,type));
                    binding.subjectOneQuestionText.setText(title);
                    binding.subjectOneQuestionBoxA.setText(a);
                    binding.subjectOneQuestionBoxB.setText(b);
                    binding.subjectOneQuestionBoxC.setText(c);
                    binding.subjectOneQuestionBoxD.setText(d);

                }
                if (type.equals("single")){
                    binding.radio.setVisibility(View.VISIBLE);
                    binding.duo.setVisibility(View.GONE);
                    binding.subjectOneQuestionText.setText(title);
                    binding.a.setText(a);
                    binding.b.setText(b);
                    binding.c.setText(c);
                    binding.d.setText(d);
                }
            }


        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
