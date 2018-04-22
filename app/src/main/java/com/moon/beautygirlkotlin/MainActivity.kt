package com.moon.beautygirlkotlin

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.moon.beautygirlkotlin.admeizi.AdMeiziFragment
import com.moon.beautygirlkotlin.doubanmeizi.DoubanMeiziFragment
import com.moon.beautygirlkotlin.glide.GlideCircleTransform
import com.moon.beautygirlkotlin.mengmeizi.GankFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 主页
 */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var mCircleImageView: ImageView

    var fragmentList: ArrayList<Fragment> = java.util.ArrayList()

    var currentTabIndex : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        initData()
    }

    fun initViews() {
        nav_view.setNavigationItemSelectedListener(this)

        var headView: View = nav_view.inflateHeaderView(R.layout.nav_header_main);

        mCircleImageView = headView.findViewById<View>(R.id.nav_head_avatar) as ImageView

        toolbar.setTitle(getString(R.string.gank_meizi))

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)

        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    fun initData() {

        fragmentList.add(GankFragment.getInstance(0)) // 萌妹子
        fragmentList.add(AdMeiziFragment.getInstance(0))  // 含有广告帖的妹子
        fragmentList.add(DoubanMeiziFragment.getInstance(0))  // 豆瓣妹子

        Glide.with(this).load(R.drawable.ic_avatar1).transform(GlideCircleTransform(this)).into(mCircleImageView)

        // 添加 Fragment 萌妹子
        supportFragmentManager.beginTransaction()
                .replace(R.id.content, fragmentList.get(0))
                .commit()

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_home -> {
                navigationFragment(0, getString(R.string.gank_meizi),item)
            }

            R.id.nav_ad_meizi -> {
                navigationFragment(1,getString(R.string.ad_meizitu),item)
            }

            R.id.nav_douban -> {
                navigationFragment(2,getString(R.string.douban_meizi),item)
            }
        }

        return true
    }


    /**
     * 切换主页各个fragment
     */
    fun navigationFragment(index : Int, title : String ,item: MenuItem ){

        var trx = supportFragmentManager.beginTransaction()
        trx.hide(fragmentList.get(currentTabIndex))

        if (!fragmentList.get(index).isAdded){
            trx.add(R.id.content,fragmentList.get(index))
        }

        trx.show(fragmentList.get(index)).commit()

        currentTabIndex = index

        item.isChecked = (true)

        toolbar.setTitle(title)
        drawer_layout.closeDrawers()

    }


}
