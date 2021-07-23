package com.gjpark.goldbook

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerListAdapter(private val context: Context, private val dataList: ArrayList<DataVo>):
    RecyclerView.Adapter<RecyclerListAdapter.ItemViewHolder>(){


        inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            private val userPhoto = itemView.findViewById<ImageView>(R.id.category_img)
            private val userName = itemView.findViewById<TextView>(R.id.UserNameTxt)
            private val userPay = itemView.findViewById<TextView>(R.id.PayTxt)
            private val userAdress = itemView.findViewById<TextView>(R.id.AdressTxt)


            fun bind(dataVo: DataVo, context: Context){

                //사진 처리
                if (dataVo.photo != ""){
                    val resourceld = context.resources.getIdentifier(dataVo.photo, "drawable", context.packageName)

                    if (resourceld > 0)
                        userPhoto.setImageResource(resourceld)
                    else
                        userPhoto.setImageResource(R.mipmap.ic_launcher_round)
                }
                else
                    userPhoto.setImageResource(R.mipmap.ic_launcher_round)


                //textview data setting
                userName.text = dataVo.name
                userPay.text = dataVo.pay.toString()
                userAdress.text = dataVo.address
            }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_view_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}