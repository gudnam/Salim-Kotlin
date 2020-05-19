package com.magulab.salim.ui

import com.magulab.salim.network.data.HouseholdApplianceData
import com.magulab.salim.network.retrofit.RetrofitRestAPI
import com.magulab.salim.network.retrofit.RetrofitService
import io.reactivex.Single

object RestAPI {

    private val BASE_URL = "https://us-central1-magulab.cloudfunctions.net/"
    private val TIMEOUT = 10L

    private val service: RetrofitService = RetrofitRestAPI(BASE_URL, TIMEOUT).getService()

    fun requestGetHouseholdAppliances(): Single<HouseholdApplianceData> {
        return service.requestGetHouseholdAppliances()
    }
}