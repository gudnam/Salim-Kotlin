package com.magulab.salim.ui.main.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magulab.salim.R
import com.magulab.salim.network.data.HouseholdApplianceData
import com.magulab.salim.ui.RestAPI
import com.magulab.salim.ui.util.inflate
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_household_appliances.*


class HouseholdAppliancesFragment : Fragment() {
    private val TAG = "HouseholdAppliancesFragment"

    private val householdAppliancesList: RecyclerView by lazy {
        rv_household_appliances
    }
    private val adapter = HouseholdAppliancesAdapter()
    var compositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.fragment_household_appliances)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        householdAppliancesList.setHasFixedSize(true)
        initView()
    }

    override fun onResume() {
        super.onResume()
        setData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.dispose()
    }

    private fun initView() {
        rv_household_appliances.adapter = adapter
        rv_household_appliances.layoutManager = LinearLayoutManager(context)
    }

    private fun setData() {
        RestAPI.requestGetHouseholdAppliances()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {
                Log.e(TAG, "onError : " + it.message)
            }
            .unsubscribeOn(Schedulers.io())
            .onErrorReturn {
                Log.e(TAG, "onErrorReturn : " + it.message)
                HouseholdApplianceData("")
            }
            .subscribe { result ->
                Log.i("TEST", "$result")
            }
            .addTo(compositeDisposable)

        adapter.items.add(HouseholdAppliancesItem("에어컨", "9일 뒤에 필터 청소"))
        adapter.items.add(HouseholdAppliancesItem("가습기", "9일 뒤에 필터 청소"))
        adapter.items.add(HouseholdAppliancesItem("세탁기", "9일 뒤에 필터 청소"))
        adapter.notifyDataSetChanged()
    }
}