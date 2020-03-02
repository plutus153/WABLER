package com.wabler.Database.Entities

import androidx.room.*

@Entity
data class LocationSettingsNumeric(@PrimaryKey(autoGenerate = true) var settingsId: Int = 0){
    var SettingKey: String = ""
    var LocationSettingsTypeId: Int? = null
    var SettingValue: Double? = null
    var Description: String = ""
}

class Test{

}