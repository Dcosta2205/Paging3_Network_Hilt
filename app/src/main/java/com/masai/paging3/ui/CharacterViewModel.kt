package com.masai.paging3.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.masai.paging3.data.CharacterRepository
import com.masai.paging3.model.CharacterDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val characterRepository: CharacterRepository) :
    ViewModel() {

    fun searchResults(): LiveData<PagingData<CharacterDTO>> {
        return characterRepository.getSearchResults()
    }
}