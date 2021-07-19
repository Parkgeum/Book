package com.gjpark.goldbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gjpark.goldbook.databinding.ActivityMainBinding

class FragmentA : Fragment() {

    val userList = arrayListOf<DataVo>(
        DataVo("IU", "test1", "전주시", "3000000") ,
        DataVo("홍길동", "test2", "서울시", "100000"),
        DataVo("김영수", "test3", "광주광역시", "2000000")
    )
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_a, container, false)

        recyclerView = rootView.findViewById(R.id.RecyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RecyclerListAdapter(requireContext(), userList)

        return rootView
    }

}