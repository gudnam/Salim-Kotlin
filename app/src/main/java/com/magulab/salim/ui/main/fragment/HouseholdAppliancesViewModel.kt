package com.magulab.salim.ui.main.fragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.magulab.salim.ui.RestAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class HouseholdAppliancesViewModel: ViewModel() {

    private val TAG = HouseholdAppliancesViewModel::class.java.simpleName
    var disposable = CompositeDisposable()

    private var householdApplianceItemList = MutableLiveData<List<HouseholdApplianceItem>>()

    fun bindItemList() = householdApplianceItemList

    fun requestItems() {
        RestAPI.requestGetHouseholdAppliances()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {
                Log.e(TAG, "onError : " + it.message)
            }
            .unsubscribeOn(Schedulers.io())
            .onErrorReturn {
                Log.e(TAG, "onErrorReturn : " + it.message)
                arrayListOf()
            }
            .subscribe { result ->
                householdApplianceItemList.value = transformHouseholdAppliancesDataList(result)
            }
            .addTo(disposable)
    }

    fun destroyViewModel() {
        disposable.dispose()
    }
}