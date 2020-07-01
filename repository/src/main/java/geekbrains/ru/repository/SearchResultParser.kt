package geekbrains.ru.repository

import geekbrains.ru.model.data.AppState
import geekbrains.ru.model.data.dto.SearchResultDto
import geekbrains.ru.model.room.HistoryEntity

fun mapHistoryEntityToSearchResult(list: List<HistoryEntity>): List<SearchResultDto> {
    val searchResult = ArrayList<SearchResultDto>()
    if (!list.isNullOrEmpty()) {
        for (entity in list) {
            searchResult.add(SearchResultDto(entity.word, null))
        }
    }
    return searchResult
}

fun convertDataModelSuccessToEntity(appState: AppState): HistoryEntity? {
    return when (appState) {
        is AppState.Success -> {
            val data = appState.data
            if (data.isNullOrEmpty() || data[0].text.isBlank()) {
                null
            } else {
                HistoryEntity(data[0].text, null)
            }
        }
        else -> null
    }
}
