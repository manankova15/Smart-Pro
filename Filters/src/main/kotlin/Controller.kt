import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/filters")
class FilterController(private val filterService: FilterService) {

    @PostMapping("/save")
    fun saveFilter(
        @RequestParam userId: Long,
        @RequestBody filter: Filter
    ): ResponseEntity<SavedFilter> {
        val savedFilter = filterService.saveFilter(userId, filter)
        return ResponseEntity(savedFilter, HttpStatus.CREATED)
    }

    @GetMapping("/user/{userId}")
    fun getFiltersByUserId(@PathVariable userId: Long): ResponseEntity<List<SavedFilter>> {
        val filters = filterService.getFiltersByUserId(userId)
        return ResponseEntity(filters, HttpStatus.OK)
    }

    @DeleteMapping("/{filterId}")
    fun deleteFilter(@PathVariable filterId: Long): ResponseEntity<Void> {
        filterService.deleteFilter(filterId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
