package com.app.quizappbasic

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    var name = ""
    var mCurrentPosition: Int = 1
    var mQuestionsList: ArrayList<Question>? = null
    var mSelectedOptionPosition: Int = 0
    var mTotalScore: Int = 0
    var answerSubmitted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        setContentView(R.layout.activity_quiz_questions)

        name = intent.getStringExtra("name").toString()

        mQuestionsList = Constants.getQuestions()

        getQuestion()

        option_one.setOnClickListener(this)
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        option_four.setOnClickListener(this)
        submit_btn.setOnClickListener(this)
    }

    private fun getQuestion() {
        val question: Question? = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsStyle()

        question_tv.text = question!!.question
        progressbar.progress = mCurrentPosition
        progress_tv.text = "$mCurrentPosition/" + progressbar.max
        flag_iv.setImageResource(question.picture)
        option_one.text = question.optionOne
        option_two.text = question.optionTwo
        option_three.text = question.optionThree
        option_four.text = question.optionFour
    }

    private fun defaultOptionsStyle() {
        val options = ArrayList<TextView>()
        options.add(0, option_one)
        options.add(1, option_two)
        options.add(2, option_three)
        options.add(3, option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.background = ContextCompat.getDrawable(this, R.drawable.buttonstyle)
            option.typeface = Typeface.DEFAULT
        }
    }

    private fun selectedOptionStyle(tv: TextView, selectedOption: Int) {
        defaultOptionsStyle()
        mSelectedOptionPosition = selectedOption
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.background = ContextCompat.getDrawable(this, R.drawable.buttonstylepressed)
        tv.setTypeface(tv.typeface, Typeface.BOLD)
    }

    private fun highlightAnswerStyle(tv: TextView, background: Int) {
        tv.setTextColor(Color.parseColor("#ffffff"))
        tv.background = ContextCompat.getDrawable(this, background)
        tv.setTypeface(tv.typeface, Typeface.BOLD)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.option_one -> selectedOptionStyle(option_one, 1)
            R.id.option_two -> selectedOptionStyle(option_two, 2)
            R.id.option_three -> selectedOptionStyle(option_three, 3)
            R.id.option_four -> selectedOptionStyle(option_four, 4)
            R.id.submit_btn -> {
                if (mSelectedOptionPosition != 0) {
                    if (answerSubmitted) {
                        nextQuestion()
                    } else {
                        answerSubmitted = true
                        option_one.isClickable = false
                        option_two.isClickable = false
                        option_three.isClickable = false
                        option_four.isClickable = false

                        if (mCurrentPosition == 10) {
                            submit_btn.text = getString(R.string.view_score)
                        } else {
                            submit_btn.text = getString(R.string.btn_next)
                        }

                        if (mSelectedOptionPosition == mQuestionsList!![mCurrentPosition - 1].correctAnswer) {
                            highlightBtnCorrect()
                            mTotalScore += 1

                        } else {
                            highlightBtnCorrect()
                            highlightBtnWrong()
                        }
                    }
                }
            }
        }
    }

    private fun highlightBtnCorrect() {
        when (mQuestionsList!![mCurrentPosition - 1].correctAnswer) {
            1 -> highlightAnswerStyle(option_one, R.drawable.buttonstylecorrect)
            2 -> highlightAnswerStyle(option_two, R.drawable.buttonstylecorrect)
            3 -> highlightAnswerStyle(option_three, R.drawable.buttonstylecorrect)
            4 -> highlightAnswerStyle(option_four, R.drawable.buttonstylecorrect)
        }
    }

    private fun highlightBtnWrong() {
        when (mSelectedOptionPosition) {
            1 -> highlightAnswerStyle(option_one, R.drawable.buttonstylewrong)
            2 -> highlightAnswerStyle(option_two, R.drawable.buttonstylewrong)
            3 -> highlightAnswerStyle(option_three, R.drawable.buttonstylewrong)
            4 -> highlightAnswerStyle(option_four, R.drawable.buttonstylewrong)
        }
    }

    private fun nextQuestion() {

        if (mCurrentPosition < 10) {
            mCurrentPosition += 1
            mSelectedOptionPosition = 0
            getQuestion()
            answerSubmitted = false

            submit_btn.text = getString(R.string.submit)

            option_one.isClickable = true
            option_two.isClickable = true
            option_three.isClickable = true
            option_four.isClickable = true

        } else {
            answerSubmitted = true
            val i = Intent(this,ResultActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("score",mTotalScore.toString())
            i.putExtra("outOf",mQuestionsList!!.size.toString())
            startActivity(i)
            finish()
        }
    }
    private fun closeApp() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Are you sure want to exit?")
            .setMessage("You progress will be lost if you exit.")
            .setPositiveButton("Proceed") {
                    dialog, which ->
                finish()
                System.exit(0)
            }
            .setNegativeButton("Cancel") {
                    dialog, which -> dialog?.dismiss() }
            .show()
    }

    override fun onBackPressed() {
        closeApp()
    }
}