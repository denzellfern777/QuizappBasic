package com.app.quizappbasic

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_quiz_btn.setOnClickListener {
            if (TextUtils.isEmpty(name_et.text)){
                name_et_layout.error = "Please enter your name to proceed."
            }
            else{
                name_et_layout.error = null
                val i = Intent(this,QuizQuestionsActivity::class.java)
                i.putExtra("name",name_et.text.toString())
                startActivity(i)
                finish()
            }
        }
    }

    private fun closeApp() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Do you want to exit?")
            .setPositiveButton("Yes") {
                    dialog, which ->
                finish()
                System.exit(0)
            }
            .setNegativeButton("No") {
                    dialog, which -> dialog?.dismiss() }
            .show()
    }

    override fun onBackPressed() {
        closeApp()
    }
}