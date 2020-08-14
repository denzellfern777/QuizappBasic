package com.app.quizappbasic

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val name = intent.getStringExtra("name")
        val score = intent.getStringExtra("score")
        val outOf = intent.getStringExtra("outOf")

        congrats_tv.text = "Congrats $name!"
        score_tv.text = "You scored $score out of $outOf"

        finish_btn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun closeApp() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Do you want to exit?")
            .setPositiveButton("Yes") { dialog, which ->
                finish()
                System.exit(0)
            }
            .setNegativeButton("No") { dialog, which -> dialog?.dismiss() }
            .show()
    }

    override fun onBackPressed() {
        closeApp()
    }
}


