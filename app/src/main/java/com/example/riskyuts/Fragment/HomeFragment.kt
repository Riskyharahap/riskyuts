package com.example.riskyuts.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.riskyuts.R
import com.example.riskyuts.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: FoodAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodArrayList : ArrayList<Food>

    lateinit var image : Array<Int>
    lateinit var name : Array<String>
    lateinit var desc: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }

            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_food)
        recyclerView.layoutManager  = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = FoodAdapter(foodArrayList)
        recyclerView.adapter = adapter

        foodArrayList = arrayListOf<Food>()
        getUserdata()

    }

    private fun getUserdata() {
        for (i in image.indices) {

            val food = Food(image[i], name[i], desc[i])
            foodArrayList.add(food)
        }

        var adapter = FoodAdapter(foodArrayList)
        recyclerView.adapter = adapter
        adapter.setOnItemClikListener(object : FoodAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                // Toast.makeText(requireActivity(), "You Clicked on Item no. $position", Toast.LENGTH_SHORT).show()

                val intent = Intent(requireActivity(),DetailFoodActivity::class.java)
                intent.putExtra("image", foodArrayList[position].imageFood)
                intent.putExtra("name", foodArrayList[position].nameFood)
                intent.putExtra("desc", desc[position])
                startActivity(intent)

            }

        })
    }

    private fun dataInitialize(){
        foodArrayList = arrayListOf<Food>()

        image = arrayOf(
            R.drawable.ayambakar,
            R.drawable.ikanbakar,
            R.drawable.gulaiayam,
            R.drawable.gulaiikan,
            R.drawable.capcay,
            R.drawable.rendang,
            R.drawable.dendeng,
            R.drawable.soto,
            R.drawable.sayurasam,
            R.drawable.ayampenyet,
        )
        name = arrayOf(
            "Ayam Bakar",
            "Ikan Bakar",
            "Gulai Ayam",
            "Gulai Ikan",
            "CapCay",
            "Rendang",
            "Dendeng",
            "Soto",
            "Sayur Asam",
            "Ayam Penyet",
        )
        desc = arrayOf(
            "Ayam bakar merupakan khas Indonesia yang sering dikonsumsi sebagai menu makan siang hingga malam",
            "Ikan bakar adalah hidangan ikan yang dibakar atau dipanggang di atas api atau bara api",
            "Gulai ayam adalah makanan yang berasal dari berbagai rempah khas nusantara yang disajikan oleh nasi hangat",
            "Gulai ikan adalah masakan yang diolah menggunakan tempoyak, namun dapat digantikan juga dengan santan untuk menghindari bau dan rasa tempoyak yang cukup menyengat",
            "Capcay adalah masakan yang terbuat dari campuran aneka sayuran dengan tambahan bakso, daging atau seafood",
            "Rendang adalah salah satu masakan tradisional Minangkabau yang menggunakan daging dan santan kelapa sebagai bahan utama dengan kandungan yang kaya akan rempah-rempah",
            "Dendeng adalah daging yang dipotong tipis menjadi serpihan yang lemaknya dipangkas, dibumbui dengan saus asam, asin atau manis dengan dikeringkan dengan api kecil atau diasinkan dan dijemur",
            "Soto (juga dikenal dengan beberapa nama lokal seperti, sroto, sauto, tauto, atau coto) adalah makanan khas Indonesia seperti sop yang terbuat dari kaldu daging dan sayuran",
            "Sayur asam adalah masakan sejenis sup yang berisi sayur-sayuran lokal khas Indonesia. Masakan ini memiliki cita rasa pedas dan asam manis yang khas",
            "Ayam penyet adalah hidangan Ayam goreng Indonesia, khususnya Jawa, yang terdiri dari ayam goreng yang diulek memakai ulekan untuk melembutkannya, disajikan dengan sambal, potongan-potongan timun, tahu goreng dan tempe",
        )
    }
}