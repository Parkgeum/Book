package com.gjpark.goldbook

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FragmentA : Fragment() {

    private val Database = Firebase.firestore
    lateinit var recyclerView: RecyclerView
    var userList : ArrayList<DataVo> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_a, container, false)

        Database.collection("UserInfo").addSnapshotListener{ querySnapshot, firebaseFirestoreException ->
            userList.clear()
            for (snapshot in querySnapshot!!.documents) {
                var item = snapshot.toObject(DataVo::class.java)
                userList.add(item!!)
            }
            recyclerView.adapter?.notifyDataSetChanged()

        }

        recyclerView = rootView.findViewById(R.id.RecyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RecyclerListAdapter(requireContext(), userList)

        return rootView
    }


}