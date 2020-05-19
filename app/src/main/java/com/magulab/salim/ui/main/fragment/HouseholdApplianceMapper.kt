package com.magulab.salim.ui.main.fragment

import com.magulab.salim.network.data.HouseholdApplianceData

fun transformHouseholdAppliancesDataList(list: List<HouseholdApplianceData>): List<HouseholdApplianceItem> {
    var itemList = arrayListOf<HouseholdApplianceItem>()
    list.forEach { itemList.add(transformHouseholdAppliancesData(it)) }
    return itemList
}
fun transformHouseholdAppliancesData(data: HouseholdApplianceData): HouseholdApplianceItem {
    return HouseholdApplianceItem(data.name, data.content)
}