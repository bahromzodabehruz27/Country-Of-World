package tj.behruz.atlasofworld.domain.model

data class MainScreenState(
    val isLoading: Boolean = false,
    val coins: List<Country> = emptyList(),
    val error: String = ""
)