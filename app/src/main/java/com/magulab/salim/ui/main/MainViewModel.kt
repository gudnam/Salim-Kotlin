package com.magulab.salim.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var mypageMover = MutableLiveData<Unit>()

    fun getMyPageMover() = mypageMover

    fun clickMyPageButton() {
        mypageMover.postValue(Unit)
    }
}