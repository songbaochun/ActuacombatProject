package com.example.s.actuacombatproject.activitis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.s.actuacombatproject.R;

/**
 * Created by s on 17-6-19.
 * 题库选择
 */

public class QuestionsChoiceActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_choice);
       findViewById(R.id.btnquding).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(QuestionsChoiceActivity.this,CityChoiceActivity.class);
              startActivity(intent);
            }
        });
    }
}
