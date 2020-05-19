package com.magulab.salim.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.magulab.salim.R
import com.magulab.salim.ui.main.fragment.HouseholdAppliancesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView()
    }

    private fun setView() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.cl_household_appliances, HouseholdAppliancesFragment()).addToBackStack(null).commit()
    }
}
