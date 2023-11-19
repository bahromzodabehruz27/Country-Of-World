package tj.behruz.atlasofworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import tj.behruz.atlasofworld.ui.AppNavigation
import tj.behruz.atlasofworld.ui.components.AtlasTopAppBar
import tj.behruz.atlasofworld.ui.components.CountryItem
import tj.behruz.atlasofworld.ui.theme.AtlasOfWorldTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AtlasOfWorldTheme {

                AppNavigation()


                // A surface container using the 'background' color from the theme

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        style = MaterialTheme.typography.h4
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AtlasOfWorldTheme {
        Greeting("Android")
    }
}