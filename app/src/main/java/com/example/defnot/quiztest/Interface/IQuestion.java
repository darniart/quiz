package com.example.defnot.quiztest.Interface;

import com.example.defnot.quiztest.Model.CurrentQuestion;

public interface IQuestion {
    CurrentQuestion getSelectedAnswer(); // get selected answer form user select
    void showCorrectAnswer(); // bold coorect answer
    void disableAnswer(); // disable checkbox
    void resetQuestion(); // reset all
}
