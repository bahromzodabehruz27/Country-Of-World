package tj.behruz.atlasofworld.ui.screens

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson
import tj.behruz.atlasofworld.domain.model.Screens
import tj.behruz.atlasofworld.ui.CountryViewModel
import tj.behruz.atlasofworld.ui.components.AtlasTopAppBar
import tj.behruz.atlasofworld.ui.components.CountryItem

@Composable
fun MainScreen(navController: NavController, countryViewModel: CountryViewModel) {

    val state = countryViewModel.state.value

    LaunchedEffect(key1 = true, block = {
        countryViewModel.getCountries()
    })

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)) {
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
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }


    }

}
