package com.magulab.salim.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.magulab.salim.R
import com.magulab.salim.ui.main.fragment.HouseholdAppliancesFragment
import com.magulab.salim.ui.mypage.MyPageActivity
import com.magulab.salim.common.moveTo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        bindLiveData()
        setView()
        setEvent()
    }

    private fun bindLiveData() {
        viewModel.getMyPageMover().observe(this, Observer {
            moveTo(MyPageActivity::class.java)
        })
    }

    private fun setView() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.cl_household_appliances, HouseholdAppliancesFragment()).addToBackStack(null).commit()
    }

    private fun setEvent() {
        iv_mypage.setOnClickListener { viewModel.clickMyPageButton() }
    }
}
