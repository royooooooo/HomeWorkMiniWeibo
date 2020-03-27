package com.thoughtworks.homeworkminiweibo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thoughtworks.homeworkminiweibo.data.Moment
import com.thoughtworks.homeworkminiweibo.model.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MomentViewModel : ViewModel() {
    val moments: MutableLiveData<List<Moment>> by lazy {
        MutableLiveData<List<Moment>>().also { loadMoments(it) }
    }

    private fun loadMoments(it: MutableLiveData<List<Moment>>) {
        ApiService.getInstance().getMoment().enqueue(object : Callback<List<Moment>> {
            override fun onFailure(call: Call<List<Moment>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Moment>>, response: Response<List<Moment>>) {
                it.value = response.body()
            }
        })
    }
}
