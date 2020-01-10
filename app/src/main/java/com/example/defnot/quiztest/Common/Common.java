package com.example.defnot.quiztest.Common;

import android.os.CountDownTimer;

import com.example.defnot.quiztest.Model.Category;
import com.example.defnot.quiztest.Model.CurrentQuestion;
import com.example.defnot.quiztest.Model.Question;
import com.example.defnot.quiztest.QuestionFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Common {

    public static final int TOTAL_TIME = 20*60*1000 ; // 20 MIN
    public static List<Question> questionList=new ArrayList<>();
    public static List<CurrentQuestion> answerSheetList = new ArrayList<>();
    public static Category selectedCategory = new Category();

    public static CountDownTimer countDownTimer;
    public static int right_answer_count = 0;
    public static int wrong_answer_count = 0;
    public static ArrayList<QuestionFragment> fragmentsList = new ArrayList<>();
    public static TreeSet<String> selected_values = new TreeSet<>();


    public enum ANSWER_TYPE {
        NO_ANSWER,
        WRONG_ANSWER,
        RIGHT_ANSWER
    }
}
