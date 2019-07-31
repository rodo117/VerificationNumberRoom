package luxoft.project.verificationcode.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import luxoft.project.verificationcode.Room.Entities.PhoneNumber
import luxoft.project.verificationcode.Room.Interfaces.PhoneNumberDao

@Database(entities = arrayOf(PhoneNumber::class),version = 1)
abstract class NumbersRoomDataBase : RoomDatabase() {

    abstract fun phoneNumbersDao(): PhoneNumberDao

    companion object {

        @Volatile
        private var INSTANCE: NumbersRoomDataBase? = null

        fun getDataBaseInstance(context: Context): NumbersRoomDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NumbersRoomDataBase::class.java,
                    "numbers_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }



}