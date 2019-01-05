package co.winds.newdashbord.sliderviewpager


import android.view.View

interface OnSliderItemClickListener {
    fun onSliderItemClick(slidePosition: Int, view: View)
}