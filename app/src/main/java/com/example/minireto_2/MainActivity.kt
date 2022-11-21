    package com.example.minireto_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

    class MainActivity : AppCompatActivity() { // button
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val ButtonRoll: Button = findViewById(R.id.ButtonRoll)

            ButtonRoll.setOnClickListener {
                time ()
            }
            rolldice() // preset image
        }

        private fun rolldice() {// img random and drawable
            var number: Int = roll(6)
            val txtResult:TextView = findViewById(R.id.txtResult)
            txtResult.text = number.toString()


            val drawableResource = when(number){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            val imgDice: ImageView = findViewById(R.id.imgDice)
            imgDice.setImageResource(drawableResource)
        }

        private fun roll(max: Int): Int {
            return (1..max).random()

        }

        private fun time (){ // clock of dice
            object: CountDownTimer (3000,100){
                override fun onTick(p0: Long) {
                    rolldice()
                }

                override fun onFinish() {

                }

            }.start()
        }
    }

