package com.example.colorpicker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.graphics.Color
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import android.text.Editable
import android.text.TextWatcher

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonColorSelected.setOnClickListener{
           // colorSelector.visibility = View.VISIBLE
        }
        
        seekBarRed.max = 255
        seekBarRed.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val colorStr= getColorString()
                strColor.setText(colorStr.replace("#","").toUpperCase())
                buttonColorSelected.setBackgroundColor(Color.parseColor(colorStr))
                redProgress.text="$progress"
            }
        })
        seekBarGreen.max = 255
        seekBarGreen.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                val colorStr = getColorString()
                strColor.setText(colorStr.replace("#","").toUpperCase())
                buttonColorSelected.setBackgroundColor(Color.parseColor(colorStr))
                greenProgress.text="$progress"

            }
        })

        seekBarBlue.max = 255
        seekBarBlue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                val colorStr = getColorString()
                strColor.setText(colorStr.replace("#","").toUpperCase())
                buttonColorSelected.setBackgroundColor(Color.parseColor(colorStr))
                blueProgress.text="$progress"
            }
        })
    }
    fun getColorString(): String {
        var r = Integer.toHexString(((255*seekBarRed.progress)/seekBarRed.max))
        if(r.length==1) r = "0"+r
        var g = Integer.toHexString(((255*seekBarGreen.progress)/seekBarGreen.max))
        if(g.length==1) g = "0"+g
        var b = Integer.toHexString(((255*seekBarBlue.progress)/seekBarBlue.max))
        if(b.length==1) b = "0"+b
        return "#" + r + g + b
    }
}
