package luxoft.project.verificationcode.Room.Interfaces

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import luxoft.project.verificationcode.Room.Entities.PhoneNumber

@Dao
interface PhoneNumberDao {

    @Query("SELECT * FROM numbers_table")
    fun getAllNumbers():LiveData<List<PhoneNumber>>

    @Insert
    suspend fun insert(phoneNumber: PhoneNumber)

}