package com.thoughtworks.homeworkminiweibo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ListAdapter
import com.thoughtworks.homeworkminiweibo.adapter.MomentListAdapter
import com.thoughtworks.homeworkminiweibo.databinding.FragmentListBinding
import com.thoughtworks.homeworkminiweibo.viewmodel.MomentViewModel


class ListFragment : Fragment() {
    private val momentViewModel by viewModels<MomentViewModel>()
    private lateinit var listFragmentBinding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listFragmentBinding = FragmentListBinding.inflate(inflater, container, false)
        subscribeUi()
        return listFragmentBinding.root
    }

    private fun subscribeUi() {
        val momentListAdapter = MomentListAdapter()
        listFragmentBinding.momentsView.adapter = momentListAdapter

        momentViewModel.moments.observe(viewLifecycleOwner, Observer { moments ->
            momentListAdapter.submitList(moments)
        })
    }
}
