package com.masai.paging3.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.masai.paging3.api.ApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val apiService: ApiService) {

    /**
     * From the Paging Source generate a PagedList<CharacterDTO> which is later feeded to
     * PagingAdapter
     */
    fun getSearchResults() =
        Pager(
            config = PagingConfig(
                /*
                Defines the number of items loaded at once from the [PagingSource].
                 */
                pageSize = 20,
                /*
                 Defines the maximum number of items that may be loaded into [PagingData] before pages should
                 be dropped.

                 * If set to [MAX_SIZE_UNBOUNDED], pages will never be dropped.

                 For example: If the maxSize = 50, once 50 items are scrolled those items will be dropped and the user won't be able to see them
                 */
                maxSize = PagingConfig.MAX_SIZE_UNBOUNDED,
                /*
                 Prefetch distance which defines how far from the edge of loaded content an access must be to
                 trigger further loading. Typically should be set several times the number of visible items
                 onscreen.

                 E.g., If this value is set to 50, a [PagingData] will attempt to load 50 items in advance of
                 data that's already been accessed.
                 */
                prefetchDistance = 50,
                enablePlaceholders = true

            ),
            pagingSourceFactory = { CharacterDataSource(apiService) }
        ).liveData
}