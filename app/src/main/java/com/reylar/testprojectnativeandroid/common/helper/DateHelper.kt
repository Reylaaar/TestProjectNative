package com.reylar.testprojectnativeandroid.common.helper

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object DateHelper {


    fun currentTime(date: Date): String {
        val df = SimpleDateFormat("MM/dd/yyyy h:mm a", Locale.ENGLISH)
        df.timeZone = TimeZone.getTimeZone(TimeZone.getDefault().id)
        return df.format(date)
    }
}