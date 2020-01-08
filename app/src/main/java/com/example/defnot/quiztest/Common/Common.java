package com.example.defnot.quiztest.Common;

import android.os.CountDownTimer;

import com.example.defnot.quiztest.Model.Category;
import com.example.defnot.quiztest.Model.CurrentQuestion;
import com.example.defnot.quiztest.Model.Question;

import java.util.ArrayList;
import java.util.List;

public class Common {

    public static final int TOTAL_TIME = 20*60*1000 ; // 20 MIN
    public static List<Question> questionList=new ArrayList<>();
    public static List<CurrentQuestion> answerSheetList = new ArrayList<>();
    public static Category selectedCategory = new Category();

    public static CountDownTimer countDownTimer;


    public enum ANSWER_TYPE {
        NO_ANSWER,
        WRONG_ANSWER,
        RIGHT_ANSWER
    }
}
