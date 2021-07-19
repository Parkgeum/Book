package com.gjpark.goldbook

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPagerAdapter (val fragmentlist:List<Fragment>, fragmentActivity: FragmentActivity)
                                                        :FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return fragmentlist.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentlist.get(position)
    }

}