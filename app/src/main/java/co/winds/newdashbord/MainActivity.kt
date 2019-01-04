package co.winds.newdashbord

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.adapter_home.view.*
import android.widget.AbsListView
import android.graphics.Color.parseColor
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue





class MainActivity : AppCompatActivity() {

    private lateinit var mContext:Context
    private lateinit var list: ArrayList<Model>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this
        list = ArrayList()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        list.add(Model(R.drawable.ic_sllide_help, "Help"))
        list.add(Model(R.drawable.ic_sllide_my_prospective_partner, "My Prospective\nPartner"))
        list.add(Model(R.drawable.ic_sllide_my_collection, "My Collection"))
        list.add(Model(R.drawable.ic_sllide_my_deposit, "My Deposite"))
        list.add(Model(R.drawable.ic_sllide_my_profile, "My Profile"))
        list.add(Model(R.drawable.ic_sllide_category_list, "Category List"))
        list.add(Model(R.drawable.ic_sllide_setting, "Setting"))




        recyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayout.HORIZONTAL, false)
        recyclerView.adapter = ListAdapter(list)
        circleIndicator!!.attachTo(recyclerView)
        circleIndicator!!.count=2

        val pieData = ArrayList<SliceValue>()
        pieData.add(SliceValue(15f, Color.BLUE).setLabel("Q1: $10"))
        pieData.add(SliceValue(25f, Color.GRAY).setLabel("Q2: $4"))
        pieData.add(SliceValue(10f, Color.RED).setLabel("Q3: $18"))
        pieData.add(SliceValue(60f, Color.MAGENTA).setLabel("Q4: $28"))

        val pieChartData = PieChartData(pieData)
        pieChartData.setHasLabels(true).valueLabelTextSize = 14
        pieChartData.setHasCenterCircle(true)
                   .setCenterText1("")
                   .setCenterText1FontSize(20)
                   .centerText1Color = Color.parseColor("#0097A7")
        chart.pieChartData = pieChartData

    }


    private inner class ListAdapter(val list:ArrayList<Model>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_home, parent, false))
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindItem(list[position])
        }

        override fun getItemCount(): Int {
            return list.size
        }

        internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
              fun bindItem(m:Model){
                itemView.tv_title.text=m.name
                  itemView.iv_icon.setImageResource(m.icon)
            }
        }
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
//                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
//                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_nearyby -> {
              //  message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
               // message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}
