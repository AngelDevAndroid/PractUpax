package com.example.pokeapiupax.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokeapiupax.databinding.FmtShowImageUrlBinding
import com.example.pokeapiupax.utils.MyApp
import com.example.pokeapiupax.utils.UtilsFun

class FmtShowImageUrl : Fragment() {

    // Objects
    private var _bindImage: FmtShowImageUrlBinding? = null
    private val bindImage get() = _bindImage!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           initObjets()
        }
    }

    private fun initObjets() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindImage = FmtShowImageUrlBinding
            .inflate(layoutInflater, container, false)
        return bindImage.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        UtilsFun().showImage(MyApp.getContext()!!, _bindImage)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindImage = null
    }
}