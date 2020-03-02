package com.wabler.Database.Entities

import androidx.room.*

@Entity
data class Security(@PrimaryKey(autoGenerate = true) var securityId: Int = 0){
    var name: String = ""
    var level: Int = 1
    var isInternetRequired: Boolean = false
    var position: Int = 0
    var methodName: String = ""
    var enabled: Boolean = true

    @Ignore
    var Description: String = ""
    @Ignore
    var isFailed: Boolean = false

    constructor(
        name: String,
        level: Int,
        position: Int,
        isInternetRequired: Boolean,
        methodName: String) : this() {
        this.name = name
        this.position = position
        this.level = level
        this.isInternetRequired = isInternetRequired
        this.methodName = methodName
    }
}