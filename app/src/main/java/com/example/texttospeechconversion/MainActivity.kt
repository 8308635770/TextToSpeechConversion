package com.example.texttospeechconversion

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText;
    lateinit var button: Button;
    lateinit var textToSpeech: TextToSpeech;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);

         textToSpeech=TextToSpeech(this, TextToSpeech.OnInitListener {

            if(it==TextToSpeech.ERROR){
                textToSpeech.setLanguage(Locale.UK)
            }

        })

        button.setOnClickListener(View.OnClickListener {

            textToSpeech.speak(editText.text.toString(),TextToSpeech.QUEUE_FLUSH,null);

        })



    }
}