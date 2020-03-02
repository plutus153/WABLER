package com.wabler.Database.Entities

import androidx.room.*

@Entity
data class SecurityLog(@PrimaryKey(autoGenerate = true) var securityLogId: Int = 0) {
    var phoneId: Int = 0
    var securityId: Int = 0
    var timeStamp: String = ""

    constructor(phoneId: Int,
                securityId: Int) : this() {
        this.phoneId = phoneId
        this.securityId = securityId
        this.timeStamp = ""
    }
}