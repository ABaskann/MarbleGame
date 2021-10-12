package com.abaskan.squitgamemarbelgame

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.abaskan.squitgamemarbelgame.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        playwithAi()

        binding.buttonPlaywith2Players.setOnClickListener {
            playwith2Players()
        }
        binding.buttonPlaywithAi.setOnClickListener {

        }

    }

    fun playwithAi() {

        visibilty()

        var marbleAi = 5
        var marblePlayer = 5
        binding.aiMarble.text = "Ai Marble: $marbleAi"
        binding.playerMarbleTextView.text = "Player Marble: $marblePlayer"

        var playerEvenorOdd = 0
        var aibet = 0

        when (marbleAi) {
            1 -> aibet = 1
            2 -> aibet = 1
            3 -> aibet = 2
            4 -> aibet = 2
            5 -> aibet = 3
            6 -> aibet = 3
            7 -> aibet = 4
            8 -> aibet = 4
            9 -> aibet = 5
            10 -> aibet = 5
        }
        val secilenbutton = binding.radiobuttongroup.checkedRadioButtonId
        binding.playButton.setOnClickListener {
            if (secilenbutton == R.id.radioButtonEven) {
                playerEvenorOdd = 0
                println("Player even or odd $playerEvenorOdd")
            } else if (secilenbutton == R.id.radioButtonOdd) {
                playerEvenorOdd = 1
                println("Player even or odd $playerEvenorOdd")

            }
            binding.aiBetTextView.text = "Ai Bet: $aibet"

            val playerBet = binding.playerBetEditText.text.toString()

            println("Player Bet $playerBet")

            val evenorodd = (0..1).random()
            println("Ai Choose $evenorodd")

            if (playerEvenorOdd == evenorodd){
                marblePlayer+=aibet
                marbleAi-=aibet
            }else{
                marbleAi+=playerBet.toInt()
                marblePlayer-=playerBet.toInt()

            }
            binding.aiMarble.text = "Ai Marble: $marbleAi"
            binding.playerMarbleTextView.text = "Player Marble: $marblePlayer"

        }

    }

    fun playwith2Players() {

    }

    fun visibilty() {
        binding.buttonPlaywithAi.visibility = View.INVISIBLE
        binding.buttonPlaywith2Players.visibility = View.INVISIBLE
        binding.aiBetTextView.visibility = View.VISIBLE
        binding.aiMarble.visibility = View.VISIBLE
        binding.playerBetEditText.visibility = View.VISIBLE
        binding.playerMarbleTextView.visibility = View.VISIBLE
        binding.radioButtonEven.visibility = View.VISIBLE
        binding.radioButtonOdd.visibility = View.VISIBLE
        binding.playButton.visibility = View.VISIBLE
        binding.radiobuttongroup.visibility = View.VISIBLE

    }
}