package com.gjpark.goldbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.gjpark.goldbook.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapterlist = listOf(FragmentA(), FragmentB(), FragmentC(), FragmentD())
        val pageAdapter = FragmentPagerAdapter(adapterlist, this)

        binding.ViewPager.adapter = pageAdapter

        val titles = listOf("A", "B", "C", "D")
        TabLayoutMediator(binding.tabLayout, binding.ViewPager) { tab, position->
            tab.text = titles.get(position)
        }.attach()

    }
}