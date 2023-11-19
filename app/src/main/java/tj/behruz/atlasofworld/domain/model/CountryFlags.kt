package tj.behruz.atlasofworld.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryFlags(val png:String,val svg:String): Parcelable