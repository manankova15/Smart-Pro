import org.springframework.stereotype.Service

@Service
class FilterService(private val savedFilterRepository: SavedFilterRepository) {

    fun saveFilter(userId: Long, filter: Filter): SavedFilter {
        val savedFilter = SavedFilter(0, userId, filter)  // ID 0 для автогенерации
        return savedFilterRepository.save(savedFilter)
    }

    fun getFiltersByUserId(userId: Long): List<SavedFilter> {
        return savedFilterRepository.findByUserId(userId)
    }

    fun deleteFilter(filterId: Long) {
        savedFilterRepository.deleteById(filterId)
    }
}
