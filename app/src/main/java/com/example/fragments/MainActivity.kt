package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val firstFragment = FirstFragment()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState==null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view,firstFragment)
            }
        }

        binding.btnFirst.setOnClickListener {
                supportFragmentManager.commit {
                    show(firstFragment)
                }
        }

        binding.btnSecond.setOnClickListener {
            supportFragmentManager.commit {
                hide(firstFragment)
            }
        }

    }
}