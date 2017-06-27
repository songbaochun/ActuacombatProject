package com.example.s.actuacombatproject.tool;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by s on 17-6-23.
 */

public class QuestionReader {
    private Document document;
    private List<Question> questionList = new ArrayList<>();

    public QuestionReader(Context context, int resid) throws SAXException {
        InputStream in = context.getResources().openRawResource(resid);
        parseInputStream(in);
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public QuestionReader(InputStream inputStream) throws SAXException {

        parseInputStream(inputStream);
    }


    private void parseInputStream(InputStream in) throws SAXException {

        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
            NodeList questionNodeList = document.getElementsByTagName("question");
            Node questionNode;
            for (int i = 0; i < questionNodeList.getLength(); i++) {
                questionNode = questionNodeList.item(i);
                NodeList childNodes = questionNode.getChildNodes();

                Map<String, String> childrenMap = new HashMap<>();
                Node child;
                for (int j = 0; j < childNodes.getLength(); j++) {
                    child = childNodes.item(j);
                    if (!child.getNodeName().equals("#text")) {
                        childrenMap.put(child.getNodeName(), child.getTextContent());
                    }
                }

                questionList.add(new Question(
                        childrenMap.get("title"),
                        childrenMap.get("a"),
                        childrenMap.get("b"),
                        childrenMap.get("c"),
                        childrenMap.get("d"),
                        childrenMap.get("answer"),
                        childrenMap.get("type"),
                        childrenMap.get("description"),
                        childrenMap.get("image")));
            }

        } catch (IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}
