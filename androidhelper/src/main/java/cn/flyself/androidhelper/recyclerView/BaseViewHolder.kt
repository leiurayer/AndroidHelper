package cn.flyself.androidhelper.recyclerView

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.annotation.IdRes
import android.util.SparseArray
import android.view.View

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var views: SparseArray<View> = SparseArray()

    protected var pos = 0
    protected var itemOnClickListener: ItemOnClickListener? = null
    protected var itemLongOnClickListener: ItemLongOnClickListener? = null
    protected var buttonOnClickListener: ButtonOnClickListener? = null
    protected var buttonLongOnClickListener: ButtonLongOnClickListener? = null

    fun getViewById(@IdRes resID: Int): View? {
        var view: View? = views.get(resID)
        if (view == null) {
            view = itemView.findViewById(resID)
            views.put(resID, view)
        }
        return view
    }

    fun begin(model: T, context: Context) {
        findView()
        setViewData(model, context)
    }

    abstract fun findView()

    abstract fun setViewData(model: T, context: Context)

    fun setOnClickListener(listener: ItemOnClickListener?, position: Int) {
        this.itemOnClickListener = listener
        this.pos = position
    }

    fun setOnLongClickListener(listener: ItemLongOnClickListener?, position: Int) {
        this.itemLongOnClickListener = listener
        this.pos = position
    }

    fun setButtonOnClickListener(listener: ButtonOnClickListener?, position: Int) {
        this.buttonOnClickListener = listener
        this.pos = position
    }

    fun setOnButtonLongClickListener(listener: ButtonLongOnClickListener?, position: Int) {
        this.buttonLongOnClickListener = listener
        this.pos = position
    }

}