package com.wabler.Database.Interface

import androidx.room.*
import com.wabler.Database.Entities.*
import com.wabler.Utilities.ErrorLog

@Dao
interface ISecurityLogDao: IBaseDao<SecurityLog> {
    @Query("Select * from SecurityLog")
    fun getSecurityLogList(): List<SecurityLog>

    @Query("Select Count(phoneId) from SecurityLog where phoneId = :phoneId")
    fun getCountSecurityLog(phoneId: Int): Int

    @Query("Delete from SecurityLog")
    fun clearSecurityLog()

    @Query("Select * from SecurityLog where securityLogId= :securityLogId")
    fun getSecurityLogById(securityLogId: Int): SecurityLog

    @Query("Select Max(securityLogId) from SecurityLog where securityId= :securityId and phoneId= :phoneId")
    fun getLastSecurityLog(securityId: Int, phoneId: Int): Int

    @Insert
    fun addNewSecurityLog(securityLog: SecurityLog)

    fun addSecurityLog(securityLog: SecurityLog): SecurityLog {
        try{
            addNewSecurityLog(securityLog)
            val securityLogId = getLastSecurityLog(securityLog.securityId, securityLog.phoneId)
            return getSecurityLogById(securityLogId)
        } catch (e: Exception){
            val name = object : Any() { }.javaClass.enclosingMethod?.name
            ErrorLog.WriteErrorLog(e, name!!)
        }
        return SecurityLog()
    }
}