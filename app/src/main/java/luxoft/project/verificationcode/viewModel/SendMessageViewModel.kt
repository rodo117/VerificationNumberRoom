package luxoft.project.verificationcode.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import luxoft.project.verificationcode.room.entities.PhoneNumber
import luxoft.project.verificationcode.room.NumbersRoomDataBase
import luxoft.project.verificationcode.room.repository.PhoneNumberRepository


class SendMessageViewModel(application:Application) : AndroidViewModel(application) {

    val allNumbers: LiveData<List<PhoneNumber>> by lazy {
        repository.allNumbers
    }

    private val repository: PhoneNumberRepository

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