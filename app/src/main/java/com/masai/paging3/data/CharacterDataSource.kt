package com.masai.paging3.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.masai.paging3.api.ApiService
import com.masai.paging3.model.CharacterDTO
import com.masai.paging3.model.ResponseDTO

/**
 * This is the Paging Source class where the data is being loaded from server
 * based on the page number provided. The paging Source takes 2 parameters <Key, Value>,
 * key is the page number of type INT and Value is CharacterDTO as we are going to receive a List<CharacterDTO> from the server
 */
class CharacterDataSource(private val apiService: ApiService) :
    PagingSource<Int, CharacterDTO>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDTO> {
        return try {

            val pageNumber = params.key ?: 1 // current page that is being displayed
            val response: ResponseDTO = apiService.getCharactersByPage(pageNumber)

            val data = response.results // List of results from the API
            LoadResult.Page(
                data = data, // Provide the List<CharacterDTO>
                prevKey = null,
                nextKey = if (data.isEmpty()) null else pageNumber + 1 // As the user scrolls provide the next page number till there is no more data
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDTO>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}