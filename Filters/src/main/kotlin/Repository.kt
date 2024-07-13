import org.springframework.data.repository.CrudRepository

interface SavedFilterRepository : CrudRepository<SavedFilter, Long> {
    fun findByUserId(userId: Long): List<SavedFilter>
}
