package tj.behruz.atlasofworld.domain.model

data class Country(
    val name: CountryInfo,
    val capital: List<String>?,
    val region: String,
    val area: Double,
    val population: Int,
    val flags: CountryFlags,
    val continents: List<String>
)


