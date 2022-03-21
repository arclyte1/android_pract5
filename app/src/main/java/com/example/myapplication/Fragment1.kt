package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class Fragment1 : Fragment() {

    private val viewModel: CalcViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_1, container, false)

        view.findViewById<Button>(R.id.button4).setOnClickListener {
            viewModel.num.value = (viewModel.num.value?.plus(1.0))
        }

        view.findViewById<Button>(R.id.button5).setOnClickListener {
            viewModel.num.value = (viewModel.num.value?.minus(1.0))
        }


        return view
    }
}