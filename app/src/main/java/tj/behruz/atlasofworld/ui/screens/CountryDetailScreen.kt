package tj.behruz.atlasofworld.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import tj.behruz.atlasofworld.R
import tj.behruz.atlasofworld.domain.model.Country

@Preview(showBackground = true)
@Composable
fun CountryDetailsScreen(navController: NavController, country: Country) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(country.name.common) },
            backgroundColor = MaterialTheme.colors.background,
            navigationIcon = {
                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp, 24.dp)
                        .clickable {
                            navController.navigateUp()
                        },

                    )
            })
    },

        content = { paddingValues: PaddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(country.flags.png)
                        .crossfade(true).build(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(10.dp),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "flagImage"
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.onSurface),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .width(16.dp)
                            .padding(16.dp)
                    )
                    Image(
                        modifier = Modifier.size(36.dp),
                        painter = painterResource(id = R.drawable.official_icon),
                        contentDescription = "official Icon"
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Official Name",
                            style = MaterialTheme.typography.subtitle1,
                            color = MaterialTheme.colors.surface
                        )
                        Text(text = country.name.official, style = MaterialTheme.typography.caption)
                    }


                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(MaterialTheme.colors.background)

                )

                //capital item
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.onSurface),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .width(16.dp)
                            .padding(16.dp)
                    )
                    Image(
                        modifier = Modifier.size(36.dp),
                        painter = painterResource(id = R.drawable.capital_icon),
                        contentDescription = "official Icon"
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Capital",
                            style = MaterialTheme.typography.subtitle1,
                            color = MaterialTheme.colors.surface
                        )
                        Text(
                            text = country.capital?.firstOrNull() ?: "",
                            style = MaterialTheme.typography.caption
                        )
                    }


                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(MaterialTheme.colors.background)

                )


                //population
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.onSurface),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .width(16.dp)
                            .padding(16.dp)
                    )
                    Image(
                        modifier = Modifier.size(36.dp),
                        painter = painterResource(id = R.drawable.population_icon),
                        contentDescription = "official Icon"
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Population",
                            style = MaterialTheme.typography.subtitle1,
                            color = MaterialTheme.colors.surface
                        )
                        Text(
                            text = country.population.toString(),
                            style = MaterialTheme.typography.caption
                        )
                    }


                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(MaterialTheme.colors.background)

                )

                //area
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.onSurface),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .width(16.dp)
                            .padding(16.dp)
                    )
                    Image(
                        modifier = Modifier.size(36.dp),
                        painter = painterResource(id = R.drawable.baseline_area_chart_24),
                        contentDescription = "official Icon"
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Area",
                            style = MaterialTheme.typography.subtitle1,
                            color = MaterialTheme.colors.surface
                        )
                        Text(
                            text = country.area.toString(), style = MaterialTheme.typography.caption
                        )
                    }

                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(MaterialTheme.colors.background)
                )

                //time zone
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.onSurface),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .width(16.dp)
                            .padding(16.dp)
                    )
                    Image(
                        modifier = Modifier.size(36.dp),
                        painter = painterResource(id = R.drawable.baseline_access_time_24),
                        contentDescription = "official Icon"
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Time Zone",
                            style = MaterialTheme.typography.subtitle1,
                            color = MaterialTheme.colors.surface
                        )
                        Text(
                            text = country.timezones?.firstOrNull().toString(),
                            style = MaterialTheme.typography.caption
                        )
                    }

                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(MaterialTheme.colors.background)

                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.onSurface),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .width(16.dp)
                            .padding(16.dp)
                    )
                    Image(
                        modifier = Modifier.size(36.dp),
                        painter = painterResource(id = R.drawable.baseline_add_location_24),
                        contentDescription = "official Icon"
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Longitude ",
                            style = MaterialTheme.typography.subtitle1,
                            color = MaterialTheme.colors.surface
                        )
                        Text(
                            text = country.latlng?.firstOrNull().toString(),
                            style = MaterialTheme.typography.caption
                        )
                    }

                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(MaterialTheme.colors.background)


                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.onSurface),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .width(16.dp)
                            .padding(16.dp)
                    )
                    Image(
                        modifier = Modifier.size(36.dp),
                        painter = painterResource(id = R.drawable.baseline_add_location_24),
                        contentDescription = "official Icon"
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Latitude",
                            style = MaterialTheme.typography.subtitle1,
                            color = MaterialTheme.colors.surface
                        )
                        Text(
                            text = country.latlng?.get(1).toString(),
                            style = MaterialTheme.typography.caption
                        )
                    }

                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(MaterialTheme.colors.background)
                )


            }
        })

}




