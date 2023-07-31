package com.example.appforresume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.appforresume.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var b: FragmentResultBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        b = FragmentResultBinding.inflate(inflater)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.scoreToResult.observe(activity as LifecycleOwner) {
            val result = "You scored $it/10 points!"
            b.result.text = result
            when {
                it < 5 -> {
                    b.congratulation.text = getString(R.string.bad)
                    b.congratulationImage.setImageResource(R.drawable.bad)
                }

                it in 5..7 -> {
                    b.congratulation.text = getString(R.string.normal)
                    b.congratulationImage.setImageResource(R.drawable.normal)
                }

                else -> {
                    b.congratulation.text = getString(R.string.congratulations)
                    b.congratulationImage.setImageResource(R.drawable.firework)
                }
            }
        }
        b.toNext.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main, StartFragment.newInstance())?.commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ResultFragment()
    }
}