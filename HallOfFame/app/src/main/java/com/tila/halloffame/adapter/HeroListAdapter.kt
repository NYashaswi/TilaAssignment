package com.tila.halloffame.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tila.halloffame.R
import com.tila.halloffame.data.Result
import com.tila.halloffame.databinding.HeroListItemBinding
import com.tila.halloffame.util.ItemClickListener

class HeroListAdapter : RecyclerView.Adapter<HeroListAdapter.HeroViewHolder>() {

    private var data: List<Result> = ArrayList()
    var clickListener : ItemClickListener<Result>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val heroListItemBinding: HeroListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.hero_list_item, parent, false
        )
        return HeroViewHolder(heroListItemBinding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) =
        holder.bind(data[position])

    fun updateData(newList: List<Result>) {
        val oldList = data
        val diffResult: DiffUtil.DiffResult =
            DiffUtil.calculateDiff(HeroDiffUtil(oldList, newList))
        data = newList
        diffResult.dispatchUpdatesTo(this)
    }


    inner class HeroViewHolder(private var heroListItemBinding: HeroListItemBinding) : RecyclerView.ViewHolder(heroListItemBinding.root) {
        fun bind(hero : Result) = with(heroListItemBinding) {
            this.root.setOnClickListener { clickListener?.onItemClicked(hero) }
            this.hero = hero
        }
    }

    inner class HeroDiffUtil(var oldList: List<Result>, var newList: List<Result>) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }
}