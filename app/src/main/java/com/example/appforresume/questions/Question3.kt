package com.example.appforresume.questions

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.appforresume.DataModel
import com.example.appforresume.R
import com.example.appforresume.databinding.FragmentQuestion3Binding

class Question3 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    private lateinit var b: FragmentQuestion3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentQuestion3Binding.inflate(inflater)
        return b.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(b){
        var result = false
        checkOut.setOnClickListener{
            if (!isFieldEmpty()) {
                result = if (answer.text.toString() == "49") {
                    backgroundQuest.setBackgroundColor(resources.getColor(R.color.right, null))
                    imQuest.setImageResource(R.drawable.correct)
                    true
                } else {
                    backgroundQuest.setBackgroundColor(resources.getColor(R.color.wrong, null))
                    imQuest.setImageResource(R.drawable.wrong)
                    false
                }
                checkOut.isClickable = false
                answer.isFocusable = false
                toNext.visibility = VISIBLE
            }
            dataModel.messageToQuestFrag1.value = result
        }
        toNext.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.remove(this@Question3)?.commit()
            dataModel.turnOnClickable.value = true
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Question3()
    }

    private fun isFieldEmpty(): Boolean {
        b.apply {
            if(answer.text.isNullOrEmpty()) answer.error = getString(R.string.forgot_text)
            return answer.text.isNullOrEmpty()
        }
    }
}