package luxoft.project.verificationcode.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "numbers_table")
data class PhoneNumber(@ColumnInfo(name = "number") val number:String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int = 0

}