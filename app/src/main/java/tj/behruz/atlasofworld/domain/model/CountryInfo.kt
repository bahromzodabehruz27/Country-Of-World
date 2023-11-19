package tj.behruz.atlasofworld.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryInfo(val common: String, val official: String): Parcelable