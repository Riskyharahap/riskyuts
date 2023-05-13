package com.example.riskyuts

class FoodAdapter(private val foodList : ArrayList<Food>)
    : androidx.recyclerview.widget.RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)
    }

    fun setOnItemClikListener(listener: onItemClickListener){

        mListener = listener
    }


    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = android.view.LayoutInflater.from(parent.context).inflate(R.layout.item_food,
            parent, false)

        return FoodViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val currentItem = foodList[position]
        holder.imageFood.setImageResource(currentItem.imageFood)
        holder.nameFood.text = (currentItem.nameFood)
        holder.descFood.text = (currentItem.descFood)

    }

    class FoodViewHolder(itemView: android.view.View, listener: onItemClickListener) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView){
        val imageFood : android.widget.ImageView = itemView.findViewById(R.id.img_photo)
        val nameFood : android.widget.TextView = itemView.findViewById(R.id.tv_name)
        val descFood : android.widget.TextView = itemView.findViewById(R.id.tv_desc)

        init {
            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)
            }
        }
    }
}