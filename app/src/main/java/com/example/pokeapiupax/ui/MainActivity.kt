package com.example.pokeapiupax.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.pokeapiupax.R
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

        setVisib(View.INVISIBLE)

        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()

        ft.add(R.id.content_fmts, fmt)
        ft.addToBackStack(null)
        ft.commit()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        onBackPressedDispatcher.onBackPressed()
        setVisib(View.VISIBLE)
    }

    fun setVisib(enabVis: Int) {
        bindMain.tvUpax.visibility = enabVis
        bindMain.btnFmtUrl.visibility = enabVis
        bindMain.btnFmtPokemon.visibility = enabVis
    }
}