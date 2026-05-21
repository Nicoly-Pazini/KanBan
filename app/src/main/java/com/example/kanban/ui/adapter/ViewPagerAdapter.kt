package com.example.kanban.ui.adapter
import androidx.constraintlayout.motion.widget.KeyPosition
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.ArrayList
class ViewPagerAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val fragmentList: MutableList<Fragment> = ArrayList()
    private val titlelist: MutableList<Int> = ArrayList()


    fun getTitle(position: Int): Int{
        return titlelist[position]
    }
    fun addFragment(fragment: Fragment,title:Int){
        fragmentList.add(fragment)
        titlelist.add(title)
    }
    override fun createFragment(position: Int): Fragment{
        return fragmentList[position]
    }
    override fun getItemCount(): Int{
        return fragmentList.size
    }

}