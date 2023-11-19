package tj.behruz.atlasofworld.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import tj.behruz.atlasofworld.data.usecases.CountryUseCase
import tj.behruz.atlasofworld.domain.model.CountryResponse
import tj.behruz.atlasofworld.domain.model.MainScreenState
import tj.behruz.atlasofworld.domain.model.Result
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(private val countryUseCase: CountryUseCase) :
    ViewModel() {
    private val _state = mutableStateOf(MainScreenState())
    val state: State<MainScreenState> = _state

    fun getCountries() {

        viewModelScope.launch {
           countryUseCase.invoke().collect {result->
               when(result){
                   is Result.Error -> _state.value = MainScreenState(error = result.message)
                   Result.Loading -> _state.value = MainScreenState(isLoading = true)
                   is Result.Success ->_state.value = MainScreenState(coins = result.data.items)
               }
           }
        }


    }


}


