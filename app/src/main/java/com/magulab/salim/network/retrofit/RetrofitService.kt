package com.magulab.salim.network.retrofit

import com.magulab.salim.network.data.HouseholdApplianceData
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("householdAppliances")
    fun requestGetHouseholdAppliances(): Single<List<HouseholdApplianceData>>

}