package com.wabler.Database.Entities

import androidx.room.*

@Entity
data class Priviledge(@PrimaryKey(autoGenerate = true) var privId: Int = 0) {
    var name: String = ""
}