package luxoft.project.verificationcode.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import luxoft.project.verificationcode.room.entities.PhoneNumber


@Dao
interface PhoneNumberDao {

    @Query("Select * from numbers_table")
    fun getAllNumbers():LiveData<List<PhoneNumber>>

    @Insert
    suspend fun insert(phoneNumber: PhoneNumber)


}