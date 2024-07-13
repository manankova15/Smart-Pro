data class Filter(
    val name: String,
    val criteria: Map<String, String>  // Пример структуры критериев
)

data class SavedFilter(
    val id: Long,
    val userId: Long,  // ID пользователя, для которого сохранен фильтр
    val filter: Filter
)
