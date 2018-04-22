package com.moon.beautygirlkotlin.doubanmeizi

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.TypedValue
import android.view.View
import com.moon.beautygirlkotlin.R
import com.moon.beautygirlkotlin.doubanmeizi.model.DoubanFragmentAdapter
import com.moon.mvpframework.view.BaseIdFragment
import kotlinx.android.synthetic.main.fragment_base_douban_meizi.*

/**
 * 豆瓣模块 base  fragment
 */
class DoubanMeiziFragment : BaseIdFragment<Nothing, Nothing>()
//        ,ViewPager.OnPageChangeListener
{


    lateinit var adapter: DoubanFragmentAdapter

    companion object {

        fun getInstance(id: Int): DoubanMeiziFragment {
            var fragment = DoubanMeiziFragment();
            var bundle = Bundle()
            bundle.putInt("id", id)

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_base_douban_meizi
    }


    /**
     * 初始化
     */
    override fun initData() {

        val pageMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1f, resources
                .displayMetrics).toInt()

        douban_viewpager.offscreenPageLimit = 5

        douban_viewpager.setPageMargin(pageMargin)
        adapter = DoubanFragmentAdapter(childFragmentManager)
        douban_viewpager.adapter = (adapter)
        douban_tablayout.setupWithViewPager(douban_viewpager)
//        douban_viewpager.addOnPageChangeListener(this)

    }

    override fun initViews(view: View?) {



    }

//    override fun onPageScrollStateChanged(state: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun onPageSelected(position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

}