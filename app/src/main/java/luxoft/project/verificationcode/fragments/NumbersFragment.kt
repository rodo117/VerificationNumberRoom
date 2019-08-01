package luxoft.project.verificationcode.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view_layout.view.*
import luxoft.project.verificationcode.adapters.NumbersRecyclerAdapter
import luxoft.project.verificationcode.R
import luxoft.project.verificationcode.room.entities.PhoneNumber
import luxoft.project.verificationcode.viewModel.SendMessageViewModel

class NumbersFragment:Fragment() {


    protected lateinit var model: SendMessageViewModel
    lateinit var numbersAdapter:NumbersRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.recycler_view_layout, container, false)

        model = activity?.run {
            ViewModelProviders.of(this).get(SendMessageViewModel::class.java)
        }?: throw Exception("Invalid Activity")


        numbersAdapter = NumbersRecyclerAdapter()
        rootView.recycler_view.setHasFixedSize(true)
        rootView.recycler_view.layoutManager = LinearLayoutManager(context)
        rootView.recycler_view.adapter = numbersAdapter


        return rootView
    }

    fun setListNumbers(listNumbers:List<PhoneNumber>){
        numbersAdapter.setNumbers(listNumbers)
    }

}