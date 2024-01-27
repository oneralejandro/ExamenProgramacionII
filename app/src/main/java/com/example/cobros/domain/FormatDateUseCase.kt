package com.example.cobros.domain

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField

class FormatDateUseCase {
    @RequiresApi(Build.VERSION_CODES.O)
    val formatter = DateTimeFormatterBuilder()
                        .appendValue(ChronoField.YEAR)
                        .appendLiteral("-")
                        .appendValue(ChronoField.MONTH_OF_YEAR)
                        .appendLiteral("-")
                        .appendValue(ChronoField.DAY_OF_MONTH)
                        .toFormatter()

    @RequiresApi(Build.VERSION_CODES.O)
    operator fun invoke(fecha:LocalDate):String {
        return fecha.format(formatter)
    }
}