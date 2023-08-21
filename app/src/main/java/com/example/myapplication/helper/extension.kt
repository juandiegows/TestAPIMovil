package com.example.myapplication.helper

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

fun String.toImage(): Bitmap? {
    var byte = Base64.decode(this, Base64.DEFAULT)

    return BitmapFactory.decodeByteArray(byte, 0,byte.size )
}