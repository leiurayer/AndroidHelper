package cn.flyself.androidhelper.recyclerView

import android.view.View

/**
 * 按钮点击事件对应的接口
 */
interface ButtonLongOnClickListener {
    fun onLongClick(view: View, position: Int)
}