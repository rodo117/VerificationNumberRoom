package luxoft.project.verificationcode.room.repository

import androidx.lifecycle.LiveData
import luxoft.project.verificationcode.room.daos.PhoneNumberDao
import luxoft.project.verificationcode.room.entities.PhoneNumber

class PhoneNumberRepository (val phoneNumbersDao:PhoneNumberDao) {

    val allNumbers:LiveData<List<PhoneNumber>> = phoneNumbersDao.getAllNumbers()


    suspend fun insertPhoneNumber(phoneNumber: PhoneNumber){
        phoneNumbersDao.insert(phoneNumber)
    }


}