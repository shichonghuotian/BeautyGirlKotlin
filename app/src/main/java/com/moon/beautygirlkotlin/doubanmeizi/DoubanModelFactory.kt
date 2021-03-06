package com.moon.beautygirlkotlin.doubanmeizi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moon.beautygirlkotlin.doubanmeizi.rep.DoubanRepository
import com.moon.beautygirlkotlin.doubanmeizi.viewmodel.DoubanViewModel

class DoubanModelFactory(private val repository: DoubanRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DoubanViewModel(repository) as T
    }
}