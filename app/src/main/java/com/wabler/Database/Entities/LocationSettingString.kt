package com.wabler.Database.Entities

import androidx.room.*

@Entity
data class LocationSettingString(@PrimaryKey(autoGenerate = true) var settingsId: Int = 0){
    var SettingKey: String = ""
    var LocationSettingsTypeId: Int? = null
    var SettingValue: String = ""
    var Description: String = ""

    constructor(SettingKey: String) : this() {
        this.SettingKey = SettingKey
    }
}