package com.example.appforresume.questions

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import com.example.appforresume.DataModel
import com.example.appforresume.R
import com.example.appforresume.databinding.FragmentQuestion6Binding
import com.example.appforresume.databinding.FragmentQuestion7Binding

class Question7 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    private lateinit var b: FragmentQuestion7Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        b = FragmentQuestion7Binding.inflate(inflater)
        return b.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var result: Boolean = false
        b.checkOut.setOnClickListener{
            if (!isFieldEmpty()) {
                result = if (b.answer.text.toString() == "17") {
                    b.backgroundQuest.setBackgroundColor(resources.getColor(R.color.right, null))
                    b.imQuest.setImageResource(R.drawable.correct)
                    true
                } else {
                    b.backgroundQuest.setBackgroundColor(resources.getColor(R.color.wrong, null))
                    b.imQuest.setImageResource(R.drawable.wrong)
                    false
                }
                b.checkOut.isClickable = false
                b.answer.isFocusable = false
                b.toNext.visibility = View.VISIBLE
            }
            dataModel.messageToQuestFrag1.value = result
        }
        b.toNext.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
            dataModel.turnOnClickable.value = true
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Question7()
    }

    private fun isFieldEmpty(): Boolean {
        b.apply {
            if(answer.text.isNullOrEmpty()) answer.error = "Don't forget to enter the answer)"
            return answer.text.isNullOrEmpty()
        }
    }
}