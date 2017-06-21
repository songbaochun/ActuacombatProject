package com.example.s.actuacombatproject.tool;

import android.content.Context;

import com.example.s.actuacombatproject.base.Questions;

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
 * Created by s on 17-6-21.
 */

public class OneQuestionsReader {
    private Document parse;
    private List<Questions> list = new ArrayList<>();

    public OneQuestionsReader(Context context, InputStream open) throws SAXException {
        try {
            //获取文件支援
            parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(open);
            //获取根节点
            NodeList question = parse.getElementsByTagName("question");
            Node node;
            for (int i = 0; i < question.getLength(); i++) {
                node = question.item(i);
                //获取根节点下的子节点
                NodeList childNodes = node.getChildNodes();
                Node child;

                Map<String, String> map = new HashMap<>();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    child = childNodes.item(j);
                    if (!child.getNodeName().equals("#text")) {
                        map.put(child.getNodeName(), child.getTextContent().trim());

                    }
                }
                list.add(new Questions(
                        map.get("title"),
                        map.get("a"),
                        map.get("b"),
                        map.get("c"),
                        map.get("d"),
                        map.get("answer"),
                        map.get("type")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

    public List<Questions> getQuestions(){

        return list;
    }
}
