package com.example.pokeapiupax

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.pokeapiupax.databinding.FmtShowImageUrlBinding

class FmtShowImageUrl : Fragment() {

    // Objects
    private var _bindImage: FmtShowImageUrlBinding? = null
    private val bindImage get() = _bindImage!!

    //lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           initObjets()
        }
    }

    private fun initObjets() {
        //context = FmtShowImageUrl.th
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindImage = FmtShowImageUrlBinding.inflate(layoutInflater, container, false)
        return bindImage.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showImage()
    }

    private fun showImage() {

        val media = "https://i0.wp.com/eltallerdehector.com/wp-content/uploads/2023/07/Bob-Esponja-png.png?fit=800%2C800&ssl=1"
        if (media != null) {

            Glide.with(this)
                .load(media)
                .placeholder(R.drawable.ic_launcher_background)
                .into(bindImage.ivImageUrl)
        } else {
            bindImage.ivImageUrl.setImageResource(R.drawable.ic_launcher_background)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindImage = null
    }
}