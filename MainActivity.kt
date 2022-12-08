package com.example.anagrams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var wordBox: TextView? = null
    private var guess: EditText? = null
    private var begin: Button? = null
    private var submit: Button? = null
    private var correctAnswer: String? = null
    private var mix: String? = null
    private var score = 0
    private var tries = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wordBox = findViewById<View>(R.id.wordBox) as TextView
        guess = findViewById<View>(R.id.guess) as EditText
        submit = findViewById<View>(R.id.submit) as Button
        submit!!.setOnClickListener(this)
        begin = findViewById<View>(R.id.begin) as Button
        begin!!.setOnClickListener(this)
        begin()
    }


    val RANDOM = Random()
    val wrds = arrayOf("ORANGE", "BELTWAY", "APPLE", "KOTLIN", "MOJA")

    // Pulls random word from list
    private fun ranWrd(): String {
        mix = wrds[RANDOM.nextInt(wrds.size)]
        val new = mix.toString()

        return new
    }
    //Rearranges the letters of the word

    fun mixWrds(new: String?): String? {

        if (new != null && "" != new) {
            val let = new.toCharArray()
            val anag = let.toMutableList()
            val mixed = anag.shuffled().toString()

            return mixed
        }
        return new
    }

    //Resets game
    fun begin() {
        correctAnswer = ranWrd()
        val Ang: String? = mixWrds(mix)
        wordBox!!.setText(Ang)
        guess!!.setText("")
        score = 0
        tries = 3
    }

    /* fun next() {
       correctAnswer = ranWrd()
       val Ang: String? =
     */



    //Check if guess is correct and gives user feedback
    private fun verify(): Int {
        val userWrd = guess!!.text.toString()
        tries--
        if (correctAnswer == userWrd) {
            score++
            Toast.makeText(this, "That's correct", Toast.LENGTH_SHORT).show()
        } else if(correctAnswer != userWrd) {
            Toast.makeText(this, "Incorrect, you have $tries tries left", Toast.LENGTH_SHORT).show()

            //very iffy
        } else if (tries==0){
            Toast.makeText(this, "You have no tries left, please RESET", Toast.LENGTH_SHORT).show()
        }
        return tries
    }

    //Assigns functions to buttons
    override fun onClick(view: View) {
        if(view == submit){
            verify()
        }
        else if(view == begin){
            begin()
        }
       /* else if(view == submit && tries ==0){
            begin()
            submit!!.isInvisible
        }*/
    }

}