package com.example.weatherapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.common.UIState
import com.example.weatherapp.common.qualifiers.MainDispatcher
import com.example.weatherapp.domain.model.HomeContentModel
import com.example.weatherapp.domain.usecase.GetHomeContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeContentUseCase: GetHomeContentUseCase,
    @MainDispatcher
    private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _homeContent = MutableStateFlow<UIState<HomeContentModel>>(UIState.Loading)
    val homeContent: StateFlow<UIState<HomeContentModel>> get() = _homeContent

    fun getHomeContent(latLon: String) {
        viewModelScope.launch(dispatcher){
            homeContentUseCase.invoke(latLon)
                .onStart {
                    _homeContent.value = UIState.Loading
                }.catch {
                    if (it is HttpException){
                        _homeContent.value = UIState.Error(it.message())
                    }
                }.collectLatest {
                    _homeContent.value = UIState.Success(it)
                }
        }
    }
}