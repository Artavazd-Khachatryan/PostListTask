package com.task.postlisttask.view.fragments.checkedPostListFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.task.postlisttask.databinding.FragmentCheckPostListBinding

import org.koin.android.ext.android.inject


class CheckPostListFragment : Fragment() {

    private val viewModel by inject<CheckPostListViewModel>()
    private lateinit var binding: FragmentCheckPostListBinding



    override fun onStart() {
        super.onStart()
        viewModel.loadData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCheckPostListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    companion object{

        val TAG = "CheckPostListFragment"

        fun newInstance(args: Bundle? = null) = CheckPostListFragment()
            .apply {
            arguments = args
        }
    }


}
