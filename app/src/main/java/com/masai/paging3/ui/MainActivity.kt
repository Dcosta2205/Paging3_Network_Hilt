package com.masai.paging3.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.paging3.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val characterViewModel by viewModels<CharacterViewModel>()
    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
        characterViewModel.searchResults().observe(this, {
            lifecycleScope.launch {
                it?.let {
                    /*
                    Submit the data to the pager Adapter
                     */
                    characterAdapter.submitData(lifecycle, it)
                }
            }
        })
    }

    private fun setAdapter() {
        characterAdapter = CharacterAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerview.apply {
            layoutManager = linearLayoutManager
            this.adapter = characterAdapter
        }
    }
}