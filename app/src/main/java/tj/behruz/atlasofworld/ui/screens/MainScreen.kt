package tj.behruz.atlasofworld.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import tj.behruz.atlasofworld.R
import tj.behruz.atlasofworld.domain.model.Screens
import tj.behruz.atlasofworld.ui.CountryViewModel
import tj.behruz.atlasofworld.ui.components.AtlasTopAppBar
import tj.behruz.atlasofworld.ui.components.CountryItem

@Composable
fun MainScreen(navController: NavController, countryViewModel: CountryViewModel) {
    val state = countryViewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                AtlasTopAppBar()
            }

            items(state.coins) { country ->
                CountryItem(country = country) {
                    navController.navigate(Screens.DETAILS.route.plus("/${country.toString()}"))
                }

            }
        }
        if (state.error.isNotBlank()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(200.dp),
                    painter = painterResource(id = R.drawable.server_error),
                    contentDescription = "serverError"
                )

                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Button(onClick = {
                    countryViewModel.getCountries()
                }, modifier = Modifier.padding(top = 20.dp)) {
                    Text(
                        text = "Try Again",
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 8.dp,
                            bottom = 8.dp
                        )
                    )
                }


            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}
