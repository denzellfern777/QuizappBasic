package com.app.quizappbasic

data class Question (
    val id: Int,
    val question: String,
    val picture: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)