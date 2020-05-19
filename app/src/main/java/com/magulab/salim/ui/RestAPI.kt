package com.magulab.salim.ui

import android.util.Log
import com.magulab.salim.network.data.HouseholdApplianceData
import com.magulab.salim.network.retrofit.RetrofitRestAPI
import com.magulab.salim.network.retrofit.RetrofitService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object RestAPI {
    private val service: RetrofitService = RetrofitRestAPI().getService()

    fun requestGetHouseholdAppliances(): Single<HouseholdApplianceData> {
        return service.requestGetHouseholdAppliances()
    }
}