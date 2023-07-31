package com.example.appforresume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appforresume.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var b: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        b = FragmentStartBinding.inflate(inflater)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        b.bPlay.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main, QuestionsFragment())
                ?.commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = StartFragment()
    }
}