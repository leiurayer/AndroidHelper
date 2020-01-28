package cn.flyself.androidhelper.recyclerView

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater

class AdaptiveAdapter(models: List<BaseModel>, context: Context) :
    RecyclerView.Adapter<BaseViewHolder<in Any?>>() {
    private var models: List<BaseModel>? = null
    private var context: Context? = null
    private var currentPosition = -1

    private var itemOnClickListener: ItemOnClickListener? = null
    private var itemLongOnClickListener: ItemLongOnClickListener? = null
    private var buttonOnClickListener: ButtonOnClickListener? = null
    private var buttonLongOnClickListener: ButtonLongOnClickListener? = null

    init {
        this.models = models
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<in Any?> {
        context = parent.context
        val itemView = LayoutInflater.from(context).inflate(viewType, parent, false)
        return models!![currentPosition].createViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<in Any?>, position: Int) {
        holder.begin(models!![position], context!!)

        holder.setOnClickListener(itemOnClickListener, position)
        holder.setOnLongClickListener(itemLongOnClickListener, position)
        holder.setButtonOnClickListener(buttonOnClickListener, position)
        holder.setOnButtonLongClickListener(buttonLongOnClickListener, position)
    }

    override fun getItemCount(): Int {
        return if (models == null || models!!.isEmpty()) {
            0
        } else {
            models!!.size
        }
    }

    override fun getItemViewType(position: Int): Int {
        currentPosition = position
        return models!![position].getLayout()
    }

    /**
     * item点击事件需要的方法
     */
    fun setOnClickListener(listener: ItemOnClickListener) {
        this.itemOnClickListener = listener
    }

    /**
     * item长按事件需要的方法
     */
    fun setOnLongClickListener(listener: ItemLongOnClickListener) {
        this.itemLongOnClickListener = listener
    }

    /**
     * button点击事件需要的方法
     */
    fun setOnButtonClickListener(listener: ButtonOnClickListener) {
        this.buttonOnClickListener = listener
    }

    /**
     * button长按事件需要的方法
     */
    fun setOnButtonLongClickListener(listener: ButtonLongOnClickListener) {
        this.buttonLongOnClickListener = listener
    }
}