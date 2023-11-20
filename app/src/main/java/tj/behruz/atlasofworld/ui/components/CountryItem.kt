package tj.behruz.atlasofworld.ui.components

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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import tj.behruz.atlasofworld.domain.model.Country
import tj.behruz.atlasofworld.ui.theme.typography
import androidx.compose.material.CircularProgressIndicator

@Preview(showBackground = true)
@Composable
fun CountryItem(country: Country, itemHandler: (Country) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = {
                itemHandler.invoke(country)
            }), elevation = 0.dp, backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Row(

            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(country.flags.png)
                    .crossfade(true).build(),
                loading = {
                    CircularProgressIndicator()
                },
                error = {

                },
                modifier = Modifier.size(120.dp, 100.dp),
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

