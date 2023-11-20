package tj.behruz.atlasofworld.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.squareup.moshi.Moshi
import tj.behruz.atlasofworld.domain.model.Country
import tj.behruz.atlasofworld.domain.model.CountryType
import tj.behruz.atlasofworld.domain.model.Screens
import tj.behruz.atlasofworld.ui.screens.CountryDetailsScreen
import tj.behruz.atlasofworld.ui.screens.MainScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: CountryViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = Screens.MAIN.route) {
        composable(Screens.MAIN.route) {
            MainScreen(navController = navController, countryViewModel = viewModel)
        }
        composable(
            Screens.DETAILS.route.plus("/{country}"),
            arguments = listOf(navArgument("country") { type = CountryType() })
        ) { backStack ->
            val country = backStack.arguments?.getParcelable<Country>("country")
            if (country != null) {
                CountryDetailsScreen(navController = navController, country)
            }
        }


    }
}