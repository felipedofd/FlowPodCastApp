package com.example.flowpodcast


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flowpodcast.controller.ListEpisodesAdapter
import com.example.flowpodcast.databinding.ActivityMainBinding
import com.example.flowpodcast.view.FlowViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

const val EXTRA_MESSAGE = "bla"

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val mViewModel: FlowViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.logoFlow.setOnClickListener {
            val intent = Intent(this, PlayerActivity::class.java)
            intent.putExtra("bla", false)
            startActivity(intent)
        }

        binding.flowPage.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("webiew", false)
            startActivity(intent)
        }


        mViewModel.BuscarVideos()
        mViewModel.episodes.observe(this) {
            binding.episodesList.adapter = ListEpisodesAdapter(
                it.items, this
            )
        }

    }

}



