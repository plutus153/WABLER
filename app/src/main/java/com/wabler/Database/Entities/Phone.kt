package com.wabler.Database.Entities

import androidx.room.*

@Entity
data class Phone(@PrimaryKey(autoGenerate = true) var phoneId: Int = 0) {
    var imei: String = ""
    var msn: String = ""
    var ipAddress: String = "0.0.0.0"
    var isAdmin: Boolean = false

    @Ignore
    var appVersion: String = ""
    @Ignore
    var isNewDevice: Boolean = false

    constructor(imei: String) : this() {
        this.imei = imei
    }

    constructor(imei: String,
                msn: String,
                isBlacklisted: Boolean) : this() {
        this.imei = imei
        this.msn = msn
        this.isAdmin = isBlacklisted
    }
}