package luxoft.project.verificationcode.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import luxoft.project.verificationcode.Room.Entities.PhoneNumber
import luxoft.project.verificationcode.Room.NumbersRoomDataBase
import luxoft.project.verificationcode.Room.Repository.PhoneNumberRepository

class SendMessageViewModel(application:Application) : AndroidViewModel(application) {

    val allNumbers: LiveData<List<PhoneNumber>> by lazy {
        repository.allNumbers
    }

    private val repository:PhoneNumberRepository

    init {
        val phoneNumberDao = NumbersRoomDataBase.getDataBaseInstance(application).phoneNumbersDao()
        repository = PhoneNumberRepository(phoneNumberDao)
    }


    fun saveNumber(number:String) {
        GlobalScope.launch {
            repository.insertPhoneNumber(PhoneNumber(number))
        }
    }



}