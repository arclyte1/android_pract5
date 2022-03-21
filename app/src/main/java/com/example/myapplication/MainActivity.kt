package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.Fragment1Binding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var fragment1Binding: Fragment1Binding
    private val viewModel: CalcViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        fragment1Binding = Fragment1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.num.value = 0.0

        val nameObserver = Observer<Double> { newName ->
            binding.textView2.text = newName.toString()
        }

        viewModel.num.observe(this, nameObserver)

        if (savedInstanceState == null)
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<Fragment1>(R.id.fragment_container_view)
            }

        binding.button.setOnClickListener {
            supportFragmentManager.commit {
                replace<Fragment1>(R.id.fragment_container_view)
            }
        }
        binding.button2.setOnClickListener {
            supportFragmentManager.commit {
                replace<Fragment2>(R.id.fragment_container_view)
            }
        }
        binding.button3.setOnClickListener {
            supportFragmentManager.commit {
                replace<Fragment3>(R.id.fragment_container_view)
            }
        }
    }
}