package com.magulab.salim.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magulab.salim.R
import com.magulab.salim.ui.util.inflate
import kotlinx.android.synthetic.main.fragment_household_appliances.*


class HouseholdAppliancesFragment : Fragment() {
    private val TAG = HouseholdAppliancesFragment::class.java.simpleName

    private lateinit var viewModel: HouseholdAppliancesViewModel
    private val householdAppliancesList: RecyclerView by lazy {
        rv_household_appliances
    }
    private val adapter = HouseholdAppliancesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(HouseholdAppliancesViewModel::class.java)
        bindViewModel()
        return container?.inflate(R.layout.fragment_household_appliances)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        householdAppliancesList.setHasFixedSize(true)
        initView()
    }

    override fun onResume() {
        super.onResume()
        viewModel.requestItems()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.destroyViewModel()
    }

    private fun initView() {
        rv_household_appliances.adapter = adapter
        rv_household_appliances.layoutManager = LinearLayoutManager(context)
    }

    private fun bindViewModel() {
        viewModel.bindItemList().observe(viewLifecycleOwner, Observer<List<HouseholdApplianceItem>> { newItems ->
            adapter.items = newItems as MutableList<HouseholdApplianceItem>
            adapter.notifyDataSetChanged()
        })
    }
}