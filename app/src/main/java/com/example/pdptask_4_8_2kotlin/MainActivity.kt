package com.example.pdptask_4_8_2kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pdptask_4_8_2kotlin.data.DataClass
import com.example.pdptask_4_8_2kotlin.fragment.FirstFragment
import com.example.pdptask_4_8_2kotlin.fragment.SecondFragment

class MainActivity : AppCompatActivity(), FirstFragment.FirstListener{


    var fragmentFirst: FirstFragment? = null
    var fragmentSecond: SecondFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intiViews()
    }

    private fun intiViews() {
        fragmentFirst = FirstFragment()
        fragmentSecond = SecondFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_first, fragmentFirst!!)
            .replace(R.id.frame_second, fragmentSecond!!)
            .commit()
    }

    override fun onFirstSend(dataClass: DataClass) {
        fragmentSecond?.updateSecondFragment(dataClass)
    }
}