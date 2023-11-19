package tj.behruz.atlasofworld.domain.model

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val name: CountryInfo,
    val capital: List<String>?,
    val region: String,
    val area: Double,
    val population: Int,
    val flags: CountryFlags,
    val continents: List<String>,
    val timezones:List<String>?,
    val latlng:List<Double>?
): Parcelable{

    override fun toString(): String {
        return Uri.encode(Gson().toJson(this))
    }


}





class CountryType : NavType<Country>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Country? {
        return bundle.getParcelable(key)
    }
    override fun parseValue(value: String): Country {
        return Gson().fromJson(value, Country::class.java)
    }
    override fun put(bundle: Bundle, key: String, value: Country) {
        bundle.putParcelable(key, value)
    }
}