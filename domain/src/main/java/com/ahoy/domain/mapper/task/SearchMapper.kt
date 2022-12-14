package com.ahoy.domain.mapper.task

import com.ahoy.domain.base.ModelMapper
import com.ahoy.entities.task.local.SearchResultItem
import com.ahoy.entities.task.remote.RemoteSearchResultItem
import javax.inject.Inject

class SearchMapper @Inject constructor(
) : ModelMapper<List<RemoteSearchResultItem>, List<SearchResultItem>> {
    override fun convert(from: List<RemoteSearchResultItem>?): List<SearchResultItem> {
        return from?.map {
            SearchResultItem(
                country = it.country ?: "",
                name = it.name ?: "",
                lon = it.lon ?: 0.0,
                id = it.id ?: 0,
                region = it.region ?: "",
                lat = it.lat ?: 0.0,
                url = it.url ?: ""
            )
        } ?: listOf()
    }
}