package com.wabler.Database.Interface

import androidx.lifecycle.LiveData
import androidx.room.*
import com.wabler.Database.Entities.Phone
import com.wabler.Utilities.ErrorLog
import java.lang.Exception

@Dao
interface IPhoneService: IBaseDao<Phone> {

    @Query("Delete from Phone")
    fun clearPhone()

    @Query ("Select * from Phone")
    fun getPhone(): LiveData<List<Phone>>

    @Query ("Select * from Phone")
    fun getPhoneList(): List<Phone>

    @Query ("Select * from Phone where imei = :imei")
    fun getPhoneByIMEI(imei: String): Phone

    fun isDeviceExist(device: Phone): Boolean {
        return getPhoneByIMEI(device.imei) != null
    }

    fun isDeviceUnderSurveillance(phone: Phone, securityLogService: ISecurityLogDao): Boolean {
        try{
            val device = getPhoneByIMEI(phone.imei)
            if (device != null){
                return securityLogService.getCountSecurityLog(phone.phoneId) > 0
            }
        } catch (e: Exception){

            ErrorLog.WriteErrorLog(e)
        }
        return false
    }

    fun isDeviceAdmin(device: Phone): Boolean {
        try{
            val device = getPhoneByIMEI(device.imei)
            if (device != null){
                return device.isAdmin
            }
        } catch (e: Exception){
            ErrorLog.WriteErrorLog(e)
        }
        return false
    }

    fun isDeviceAdmin(imei: String): Boolean {
        return isDeviceAdmin(Phone(imei))
    }

    @Insert
    fun addNewPhone(phone: Phone)

    fun addPhone(phone: Phone): Phone{
        addNewPhone(phone)
        return getPhoneByIMEI(phone.imei)
    }

}