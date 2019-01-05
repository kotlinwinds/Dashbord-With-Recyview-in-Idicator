package co.winds.newdashbord.sliderviewpager

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import co.winds.newdashbord.R
import kotlinx.android.synthetic.main.slide_one.view.*
import kotlinx.android.synthetic.main.slide_two.view.*


class MainActivity : AppCompatActivity(), OnSliderItemClickListener {

    val TAG = MainActivity::class.java.simpleName
    private lateinit var dotsLayout: LinearLayout
    lateinit var dots: Array<ImageView?>
    val layouts = arrayOf(R.layout.slide_one, R.layout.slide_two)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dotsLayout = findViewById(R.id.layoutDots)
        dotsLayout.orientation = LinearLayout.HORIZONTAL
        addBottomDots(0)

        val sliderViewPagerAdapter = SliderViewPagerAdapter(layouts)
        sliderViewPagerAdapter.setOnSliderItemClickListener(this)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = sliderViewPagerAdapter


        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {
            }
            override fun onPageScrolled(position: Int, p1: Float, p2: Int) {
            }
            override fun onPageSelected(position: Int) {
                addBottomDots(position)
            }
        })
    }

    fun addBottomDots(currentPosition: Int) {
        Log.d(TAG, "addBottomDots $currentPosition")
        dotsLayout.removeAllViews()
        dots = arrayOfNulls<ImageView>(layouts.size)        // IMPORTANT - arrayOfNulls
        dots.forEachIndexed { index, imageView ->
            dots[index] = ImageView(this)
            if (index == currentPosition) {
                dots[index]!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dots_default))
            } else {
                dots[index]!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dots_active))
            }

            val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(8, 0, 8, 0)
            dotsLayout.addView(dots[index], layoutParams)
        }
    }



    override fun onSliderItemClick(slidePosition: Int, view: View) {
        Log.d(TAG, "onSliderItemClick -- Position : $slidePosition")
        when (slidePosition) {
            0 -> {
                view.tv_help.setOnClickListener {
                    Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show()
                }
                view.tv_myprospective.setOnClickListener {
                    Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show()
                }

                view.tv_collection.setOnClickListener {
                    Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show()
                }

                view.tv_deposite.setOnClickListener {
                    Toast.makeText(this, "Star", Toast.LENGTH_SHORT).show()
                }

            }
            1 -> {
                view.tv_Profile.setOnClickListener {
                    Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show()
                }
                view.tv_category_list.setOnClickListener {
                    Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show()
                }

                view.tv_setting.setOnClickListener {
                    Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}