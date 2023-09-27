package com.example.pokeapiupax

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.pokeapiupax.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Objects
    lateinit var bindMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindMain.root)

        initViews()
    }

    private fun initViews() {
        bindMain.btnFmtUrl.setOnClickListener(this)
        bindMain.btnFmtPokemon.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when(view?.id) {

            R.id.btn_fmt_url -> {
                changeFragment(FmtShowImageUrl())
            }

            R.id.btn_fmt_pokemon -> {
                changeFragment(FmtPokemonApi())
            }
        }
    }

    private fun changeFragment(fmt: Fragment) {

        setVisib(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE)

        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()

        ft.add(R.id.content_fmts, fmt)
        ft.addToBackStack(null)
        ft.commit()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        onBackPressedDispatcher.onBackPressed()
        setVisib(View.VISIBLE, View.VISIBLE, View.VISIBLE)
    }

    fun setVisib(visTxt: Int, visBtnImg: Int, visBtnPoke: Int) {
        bindMain.tvUpax.visibility = visTxt
        bindMain.btnFmtUrl.visibility = visBtnImg
        bindMain.btnFmtPokemon.visibility = visBtnPoke
    }
}