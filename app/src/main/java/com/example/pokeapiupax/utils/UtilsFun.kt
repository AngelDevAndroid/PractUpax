package com.example.pokeapiupax.utils

import android.content.Context
import android.util.Log
import com.bumptech.glide.Glide
import com.example.pokeapiupax.R
import com.example.pokeapiupax.databinding.FmtShowImageUrlBinding

// Utils
class UtilsFun {

    var initialPlaceH = "Place Holder"
    val imageCir = "https://media.istockphoto.com/id/1267110917/es/vector/mujer-negra-charlando-en-un-tel%C3%A9fono-inteligente-sentado-en-la-mesa-de-la-cafeter%C3%ADa-feliz.jpg?s=612x612&w=0&k=20&c=Q2J_F09-q7G_Xf7Kol8JYghayj7s3_LCYBhqPX2VfCA="

    var finPlaceHold = ""

    fun showImage(context: Context, bindImage: FmtShowImageUrlBinding?) {

        val abc = initialPlaceH.getFirstAndLast().toString()

        val dfg = abc.replace(")", "").last().uppercaseChar()
        val sub = abc.replace("(", "").substring(0, 1)
        val subStr = sub.plus(dfg)

        if (countWords(initialPlaceH) == 1) {

            finPlaceHold = dfg.toString()
        } else {
            finPlaceHold = subStr
        }

        if (initialPlaceH[0].isDigit()
            || !initialPlaceH[0].isLetter()) {

            Log.d("WORD_TXT", "placeH ->")
        } else {
            Log.d("WORD_TXT", "noPlaceH ->")
        }

        finPlaceHold = subStr

        if (imageCir == null || imageCir.isEmpty()) {
            finPlaceHold = initialPlaceH
        }

        if (imageCir == null || initialPlaceH.isEmpty()) {
            bindImage!!.ivImageUrl.setImageResource(R.drawable.ic_prof)
        }

        if (imageCir == null && initialPlaceH[0].isDigit()
            || !initialPlaceH[0].isLetter()) {

            bindImage!!.ivImageUrl.setImageResource(R.drawable.ic_prof)
        }

        if (imageCir != null) {

            Glide.with(context)
                .load(imageCir)
                .placeholder(R.drawable.ic_prof)
                .error(finPlaceHold)
                .into(bindImage!!.ivImageUrl)
        } else {
            bindImage!!.ivImageUrl.setImageResource(R.drawable.ic_prof)
        }
    }

    private fun String.getFirstAndLast() = first() to last()

    private fun countWords(s: String): Int {

        var conteoPalabras = 0
        var palabra = false
        val finDeLinea = s.length - 1

        for (i in s.indices) {
            if (Character.isLetter(s[i]) && i != finDeLinea) {
                palabra = true
            } else if (!Character.isLetter(s[i]) && palabra) {
                conteoPalabras++
                palabra = false
            } else if (Character.isLetter(s[i]) && i == finDeLinea) {
                conteoPalabras++
            }
        }
        return conteoPalabras
    }
}