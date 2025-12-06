package com.example.homework_23.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.homework_23.domain.ProductModel

class ProductsDiffUtilCallback(
    private val oldList: List<ProductModel>,
    private val newList: List<ProductModel>
) :
    DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}