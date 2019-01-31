package com.example.sertac.renkbelirleyici

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener,View.OnClickListener {

    private var red: Int = 0
    private var green: Int = 0
    private var blue: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        redColorSeekbar.max = 255
        greenColorSeekbar.max = 255
        blueColorSeekbar.max = 255

        init()
    }

    private fun init() {
        redColorValue.setText(redColorSeekbar.progress.toString())
        greenColorValue.setText(greenColorSeekbar.progress.toString())
        blueColorValue.setText(blueColorSeekbar.progress.toString())
        actionEvent()
    }

    private fun actionEvent() {
        redColorSeekbar.setOnSeekBarChangeListener(this)
        blueColorSeekbar.setOnSeekBarChangeListener(this)
        greenColorSeekbar.setOnSeekBarChangeListener(this)
        redColorValue.setOnClickListener(this)
        greenColorValue.setOnClickListener(this)
        blueColorValue.setOnClickListener(this)

        redColorValue.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                red = Integer.parseInt(if (TextUtils.isEmpty(s)) "0" else s.toString())
                redColorSeekbar.progress = red
                backgroundChanger(red, green, blue)
            }
        })
        greenColorValue.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                green = Integer.parseInt(if (TextUtils.isEmpty(s)) "0" else s.toString())
                greenColorSeekbar.progress = green
                backgroundChanger(red, green, blue)
            }
        })
        blueColorValue.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                blue = Integer.parseInt(if (TextUtils.isEmpty(s)) "0" else s.toString())
                blueColorSeekbar.progress = blue
                backgroundChanger(red, green, blue)
            }
        })
        backgroundChanger(red, green, blue)
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        when (seekBar.id) {
            R.id.redColorSeekbar -> {
                redColorValue.setText(progress.toString())
            }
            R.id.greenColorSeekbar -> {
                greenColorValue.setText(progress.toString())
            }
            R.id.blueColorSeekbar -> {
                blueColorValue.setText(progress.toString())
            }
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {
        when (seekBar.id){
            R.id.redColorSeekbar -> if (redColorValue.isFocusable) redColorValue.isFocusableInTouchMode=false

            R.id.greenColorSeekbar ->if (greenColorValue.isFocusable) greenColorValue.isFocusableInTouchMode=false

            R.id.blueColorSeekbar ->if (blueColorValue.isFocusable) blueColorValue.isFocusableInTouchMode=false

        }
    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {

    }

    private fun backgroundChanger(red: Int, green: Int, blue: Int) {
        colorShower.setBackgroundColor(Color.rgb(red, green, blue))
        val value="# ${hexValue(red)}${hexValue(green)}${hexValue(blue)}"
        hex_color_value.text=value
    }

    override fun onClick(v: View) {
        if (!v.isFocusable) v.isFocusableInTouchMode=true
    }

    private fun hexValue(value:Int):String{
        return ""
    }
}
