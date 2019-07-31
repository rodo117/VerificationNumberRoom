package luxoft.project.verificationcode.Room.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import luxoft.project.verificationcode.Room.Entities.PhoneNumber
import luxoft.project.verificationcode.Room.Interfaces.PhoneNumberDao

class PhoneNumberRepository(private val phoneNumberDao: PhoneNumberDao){

    val allNumbers:LiveData<List<PhoneNumber>>  = phoneNumberDao.getAllNumbers()

    @WorkerThread
    suspend fun insertPhoneNumber(phoneNumber:PhoneNumber){
        phoneNumberDao.insert(phoneNumber)
    }


}