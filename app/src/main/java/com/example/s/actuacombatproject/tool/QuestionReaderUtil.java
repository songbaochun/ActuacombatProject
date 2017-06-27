package com.example.s.actuacombatproject.tool;

import android.content.Context;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * Created by s on 17-6-23.
 */

public class QuestionReaderUtil {
    public static List<Question> read(Context context) throws SAXException {
        try {
            return new QuestionReader(context.getAssets().open("onequestion.xml")).getQuestionList();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
