package cn.flyself.androidhelper.recyclerView

import android.view.View

abstract class BaseModel {
    private var itemOnClickListener: ItemOnClickListener? = null
    private var itemLongOnClickListener: ItemLongOnClickListener? = null
    private var buttonOnClickListener: ButtonOnClickListener? = null
    private var buttonLongOnClickListener: ButtonLongOnClickListener? = null

    abstract fun getLayout(): Int
    abstract fun createViewHolder(itemView: View): BaseViewHolder<in Any?>

    /**
     * item点击事件需要的方法
     */
    fun setOnClickListener(listener: ItemOnClickListener) {
        this.itemOnClickListener = listener
    }

    fun getOnClickListener(): ItemOnClickListener? {
        return itemOnClickListener
    }

    /**
     * item长按事件需要的方法
     */
    fun setOnLongClickListener(listener: ItemLongOnClickListener) {
        this.itemLongOnClickListener = listener
    }

    fun getOnLongClickListener(): ItemLongOnClickListener? {
        return itemLongOnClickListener
    }

    /**
     * button点击事件需要的方法
     */
    fun setButtonOnClickListener(listener: ButtonOnClickListener) {
        this.buttonOnClickListener = listener
    }

    fun getButtonOnClickListener(): ButtonOnClickListener? {
        return buttonOnClickListener
    }

    /**
     * button长按事件需要的方法
     */
    fun setOnButtonLongClickListener(listener: ButtonLongOnClickListener) {
        this.buttonLongOnClickListener = listener
    }

    fun getOnButtonLongClickListener(): ButtonLongOnClickListener? {
        return buttonLongOnClickListener
    }
}