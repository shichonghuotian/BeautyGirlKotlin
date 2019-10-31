package com.moon.beautygirlkotlin.gank

import androidx.lifecycle.MutableLiveData
import com.moon.beautygirlkotlin.base.BaseViewModel
import com.moon.beautygirlkotlin.gank.model.GankMeiziBody
import com.moon.beautygirlkotlin.gank.repository.GankRepository

/**
 * author: jiangtao.liang
 * date:   On 2019-10-30 12:49
 */
class GankViewModel(private val repository : GankRepository) : BaseViewModel() {

    val list = ArrayList<GankMeiziBody>()

    val _item = MutableLiveData<List<GankMeiziBody>>().apply {
        value = emptyList()
    }

    fun getGankList(pageNum: Int, page: Int){
        launch ({
            _item.value = repository.getGankList(pageNum,page).results

            if (!_item.value!!.isEmpty()){
                list.clear()
                list.addAll(_item.value!!)
            }
            return@launch
        },
        {

        })
    }
}