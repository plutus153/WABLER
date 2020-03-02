package com.wabler.Database

import com.wabler.Database.Entities.Security

//https://developer.android.com/training/data-storage/room/creating-views

class Quarantine {
    var security: List<Security>
    var imei: String = ""

    constructor(securityInfo: List<Security>, imei: String){
        this.security = securityInfo
        this.imei = imei
    }
}

class RequestCode {
    var requestName = ""
    var requestCode = 0

    constructor(requestName: String, requestCode: Int){
        this.requestCode = requestCode
        this.requestName = requestName
    }
}