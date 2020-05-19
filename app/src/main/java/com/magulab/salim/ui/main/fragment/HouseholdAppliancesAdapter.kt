package com.magulab.salim.ui.main.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.magulab.salim.R
import kotlinx.android.synthetic.main.item_household_appliances.view.*

class HouseholdAppliancesAdapter : RecyclerView.Adapter<HouseholdAppliancesAdapter.HouseholdAppliancesHolder>() {

    var items: MutableList<HouseholdAppliancesItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HouseholdAppliancesHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HouseholdAppliancesHolder, position: Int) {
        items[position].let {
            with(holder) {
                tvTitle?.text = it.title
                tvContent?.text = it.content
            }
        }
    }


    inner class HouseholdAppliancesHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_household_appliances, parent, false
        )
    ) {
        val tvTitle: TextView? = itemView.tv_main_title
        val tvContent: TextView? = itemView.tv_main_content
    }
}
