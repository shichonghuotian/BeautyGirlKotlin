package com.moon.beautygirlkotlin.my_collect.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.moon.beautygirlkotlin.R
import com.moon.beautygirlkotlin.listener.ViewItemListener
import com.moon.beautygirlkotlin.my_collect.model.MyCollectBody
import com.moon.beautygirlkotlin.utils.ImageLoader
import java.util.*

/**
 * author: moon
 * created on: 18/4/4 下午4:37
 * description: 我的收藏 adapt
 */
class MyCollectAdapter( ) : RecyclerView.Adapter<MyCollectAdapter.MyCollectViewHolder>(), View.OnClickListener {

    lateinit var context: Context

    private val AD_ITEM_TYPE = 0

    private val COMMON_ITEM_TYPE = 1

    override fun onClick(v: View?) {
        var position : Int = v?.getTag() as Int
        itemListener?.itemClick(v,position)
    }

    var list: ArrayList<MyCollectBody>? = null

    lateinit var itemListener : ViewItemListener

    init {
        this.list = ArrayList()
    }

    fun loadMoreData(list:List<MyCollectBody>){
        this.list?.addAll(list)
        notifyDataSetChanged()
    }

    fun refreshData(list:List<MyCollectBody>){

        if (this.list?.size!! > 0){
            this.list?.clear()
            notifyDataSetChanged()
        }

        this.list?.addAll(list)
        notifyDataSetChanged()
    }


//    override fun getItemViewType(position: Int): Int {
//        val type = list?.get(position)?.itemType
//        if (type == 0){
//
//            return AD_ITEM_TYPE
//        }else
//
//            return COMMON_ITEM_TYPE
//    }


    override fun onBindViewHolder(holder: MyCollectViewHolder?, position: Int) {

        var body : MyCollectBody = list?.get(position)!!


        ImageLoader.load(context, body.url, R.drawable.placeholder_image, holder!!.item_img)


        holder?.item_title?.setText(body.title)


        holder?.item_layout?.setTag(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyCollectViewHolder {
        var v : View = LayoutInflater.from(parent?.context)?.inflate(R.layout.item_meng_meizi,parent,false)!!

        var holder = MyCollectViewHolder(v)

        context = parent?.context!!

        holder?.item_layout?.setOnClickListener(this)

        return holder
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }


    class GankAdViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){

    }


    class MyCollectViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){

        var item_img : ImageView = itemView!!.findViewById<ImageView>(R.id.item_img) as ImageView

        var item_title: TextView = itemView!!.findViewById<View>(R.id.item_title) as TextView

        var item_layout: LinearLayout = itemView!!.findViewById<View>(R.id.item_layout) as LinearLayout
    }


}