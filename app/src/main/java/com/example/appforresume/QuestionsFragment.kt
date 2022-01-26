package com.example.appforresume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.appforresume.databinding.FragmentQuestionsBinding
import com.example.appforresume.questions.*

class QuestionsFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    private lateinit var b: FragmentQuestionsBinding
    private var counter = 1
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentQuestionsBinding.inflate(inflater)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageToQuestFrag1.observe(activity as LifecycleOwner) {
            if (it) {
                when (counter) {
                    2 -> b.quest1.setImageResource(R.drawable.right_box)
                    3 -> b.quest2.setImageResource(R.drawable.right_box)
                    4 -> b.quest3.setImageResource(R.drawable.right_box)
                    5 -> b.quest4.setImageResource(R.drawable.right_box)
                    6 -> b.quest5.setImageResource(R.drawable.right_box)
                    7 -> b.quest6.setImageResource(R.drawable.right_box)
                    8 -> b.quest7.setImageResource(R.drawable.right_box)
                    9 -> b.quest8.setImageResource(R.drawable.right_box)
                    10 -> b.quest9.setImageResource(R.drawable.right_box)
                    11 -> b.quest10.setImageResource(R.drawable.right_box)
                }
                score++
            } else {
                when (counter) {
                    2 -> b.quest1.setImageResource(R.drawable.wrong_box)
                    3 -> b.quest2.setImageResource(R.drawable.wrong_box)
                    4 -> b.quest3.setImageResource(R.drawable.wrong_box)
                    5 -> b.quest4.setImageResource(R.drawable.wrong_box)
                    6 -> b.quest5.setImageResource(R.drawable.wrong_box)
                    7 -> b.quest6.setImageResource(R.drawable.wrong_box)
                    8 -> b.quest7.setImageResource(R.drawable.wrong_box)
                    9 -> b.quest8.setImageResource(R.drawable.wrong_box)
                    10 -> b.quest9.setImageResource(R.drawable.wrong_box)
                    11 -> b.quest10.setImageResource(R.drawable.wrong_box)
                }
            }
        }
        dataModel.turnOnClickable.observe(activity as LifecycleOwner) {
            b.btnStartQuestions.isClickable = it
        }
        b.btnStartQuestions.setOnClickListener{
            b.btnStartQuestions.isClickable = false
            when (counter) {
                1 -> {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.btnStartQuestions, Question1())
                        ?.commit()
                }
                2 -> {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.btnStartQuestions, Question2())
                        ?.commit()
                }
                3 -> {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.btnStartQuestions, Question3())
                        ?.commit()
                }
                4 -> {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.btnStartQuestions, Question4())
                        ?.commit()
                }
                5 -> {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.btnStartQuestions, Question5())
                        ?.commit()
                }
                6 -> {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.btnStartQuestions, Question6())
                        ?.commit()
                }
                7 -> {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.btnStartQuestions, Question7())
                        ?.commit()
                }
                8 -> {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.btnStartQuestions, Question8())
                        ?.commit()
                }
                9 -> {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.btnStartQuestions, Question9())
                        ?.commit()
                }
                10 -> {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.btnStartQuestions, Question10())
                        ?.commit()
                }
                11 -> {
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.btnStartQuestions, ResultFragment())
                        ?.commit()
                    dataModel.scoreToResult.value = score
                }
            }
            counter++
        }
        dataModel.scoreToResult.observe(activity as LifecycleOwner) {
            b.brainCompetition.visibility = GONE
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = QuestionsFragment()
    }
}