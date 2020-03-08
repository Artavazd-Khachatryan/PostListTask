package com.task.postlisttask.view.fragments.allPostFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.task.postlisttask.databinding.FragmentAllPostListBinding
import org.koin.android.ext.android.inject


class AllPostListFragment : Fragment() {

    private val viewModel by inject<AllPostListViewModel>()
    private lateinit var binding: FragmentAllPostListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAllPostListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    companion object{

        val TAG = "AllListFragment"

        fun newInstance(args: Bundle? = null) = AllPostListFragment()
            .apply {
            arguments = args
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadData()
    }

}
