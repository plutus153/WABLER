package com.wabler.Database.Entities

import androidx.room.*

@Entity
data class User(@PrimaryKey(autoGenerate = true) var userId: Int = 0) {
    var phoneId: Int = 0
    var userLevelId: Int = 0
    var lastName: String = ""
    var firstName: String = ""
}