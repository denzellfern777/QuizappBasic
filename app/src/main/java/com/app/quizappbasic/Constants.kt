package com.app.quizappbasic

object Constants{
    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val questionOne = Question(1,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Austria",
            "Argentina",
            "Algeria",
            "Albania",
            2)
        questionsList.add(questionOne)

        val questionTwo = Question(2,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Afghanistan",
            "Austria",
            "Australia",
            "Azerbaijan",
            3)
        questionsList.add(questionTwo)

        val questionThree = Question(3,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Bahrain",
            "Burma",
            "Bolivia",
            1)
        questionsList.add(questionThree)

        val questionFour = Question(4,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus",
            "Botswana",
            "Burundi",
            "Brazil",
            4)
        questionsList.add(questionFour)

        val questionFive = Question(5,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Djibouti",
            "Denmark",
            "Dominica",
            "Dominican Republic",
            2)
        questionsList.add(questionFive)

        val questionSix = Question(6,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "France",
            "Federal Government of Germany",
            "Finland",
            "Fiji",
            4)
        questionsList.add(questionSix)

        val questionSeven = Question(7,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Ghana",
            "Greece",
            "Germany",
            "Guinea",
            3)
        questionsList.add(questionSeven)

        val questionEight = Question(8,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Iceland",
            "India",
            "Indonesia",
            "Israel",
            2)
        questionsList.add(questionEight)

        val questionNine = Question(9,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Kenya",
            "Korea",
            "Kyrgyzstan",
            1)
        questionsList.add(questionNine)

        val questionTen = Question(10,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Nepal",
            "Norway",
            "Nigeria",
            "New Zealand",
            4)
        questionsList.add(questionTen)

        return questionsList
    }
}