package tj.behruz.atlasofworld.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import tj.behruz.atlasofworld.R
import tj.behruz.atlasofworld.domain.model.Country
import tj.behruz.atlasofworld.ui.theme.typography


@Preview(showBackground = true)
@Composable
fun CountryItem(country: Country) {
    Log.d("TEST", country.toString())
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = {

            }),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Row(

            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(country.flags.png)
                    .crossfade(true)
                    .build(),
                modifier = Modifier
                    .size(120.dp, 100.dp),
                alignment = Alignment.CenterStart,
                contentDescription = "",
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = country.name.common,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    style = typography.subtitle1,
                    color = MaterialTheme.colors.surface
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = country.capital?.firstOrNull() ?: "",
                    modifier = Modifier.padding(bottom = 10.dp),
                    style = typography.caption,

                    )
                CountryRegionTag(region = country.region)
            }
        }
    }
}

