package luxoft.project.verificationcode.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import luxoft.project.verificationcode.Fragments.NumbersFragment
//import com.twilio.Twilio

import luxoft.project.verificationcode.Fragments.SendMessageFragment
import luxoft.project.verificationcode.R
import luxoft.project.verificationcode.Room.Entities.PhoneNumber
import luxoft.project.verificationcode.ViewModel.SendMessageViewModel

class MainActivity : AppCompatActivity(),SendMessageFragment.SaveNumber {


    private lateinit var model: SendMessageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*Twilio.init(
            getString(R.string.twilio_account_sid),
            getString(R.string.twilio_token)
        )*/

        model = ViewModelProviders.of(this).get(SendMessageViewModel::class.java)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container,SendMessageFragment()).commit()



        val observer = Observer<List<PhoneNumber>> { phoneNumberList ->
            if(supportFragmentManager.findFragmentById(R.id.fragment_container) is NumbersFragment) {
                val numbersFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NumbersFragment
                numbersFragment.setListNumbers(phoneNumberList)
            }

        }

        model.allNumbers.observe(this, observer)
    }


    override fun onSaveNumber() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, NumbersFragment()).addToBackStack(null).commit()
    }
}
