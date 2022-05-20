package binar.andlima.news_daggerhilt_retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import binar.andlima.news_daggerhilt_retrofit.api.NewsApi
import binar.andlima.news_daggerhilt_retrofit.model.ResponseNews
import binar.andlima.news_daggerhilt_retrofit.model.ResponseNewsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(api: NewsApi) : ViewModel(){

//    @Inject
//    lateinit var api : NewsApi

    private val newsLiveData = MutableLiveData<List<ResponseNewsItem>>()
    val new : LiveData<List<ResponseNewsItem>> = newsLiveData

    init {

        viewModelScope.launch {
            val datanews = api.getAllNews()
            delay(2000)
            newsLiveData.value = datanews
        }
    }
}