package com.wabler.Database.Entities

import androidx.room.*

@Entity
data class UserLevel(@PrimaryKey(autoGenerate = true) var userLevelId: Int = 0){
    var privId: Int = 0
    var name: String = ""
}