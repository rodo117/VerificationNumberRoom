package luxoft.project.verificationcode.fragments

import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.validate_code_layout.*
import kotlinx.android.synthetic.main.validate_code_layout.view.*
import kotlinx.android.synthetic.main.validate_code_layout.view.number_tv
import luxoft.project.verificationcode.R
import luxoft.project.verificationcode.viewModel.SendMessageViewModel

open class SendMessageFragment:Fragment() {

    protected lateinit var model: SendMessageViewModel
    lateinit var delegate:SaveNumber

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SaveNumber) {
            delegate = context
        } else {
            throw ClassCastException(
                context.toString() + " must implement saveNumber.")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val rootView = inflater.inflate(R.layout.validate_code_layout, container, false)
        rootView.number_tv.inputType = InputType.TYPE_CLASS_PHONE
        rootView.button_verify_send_data.setOnClickListener{
           sendOrVerifyData()
        }


        model = activity?.run {
            ViewModelProviders.of(this).get(SendMessageViewModel::class.java)
        }?: throw Exception("Invalid Activity")


        return rootView
    }


    open fun sendOrVerifyData() {
        val number = getString(R.string.mex_code_number)+number_tv.text.toString()
        delegate.onSaveNumber()
        model.saveNumber(number)
    }

     interface SaveNumber {
         fun onSaveNumber()
     }

}
