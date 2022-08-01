package com.example.paybackcodingtask.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.paybackcodingtask.databinding.ActivityImageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}