package com.threeadvance.android.data.remote

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.ref.WeakReference
import java.lang.reflect.Type
import java.nio.charset.Charset
import java.util.stream.Collectors

class ResourceParser private constructor(context: Context) {

    private val weakContext: WeakReference<Context> = WeakReference(context)
    val gson: Gson = GsonBuilder().create()

    companion object {
        @Volatile
        private var INSTANCE: ResourceParser? = null

        fun getInstance(context: Context): ResourceParser {
            return INSTANCE ?: synchronized(this) {
                return INSTANCE ?: run { ResourceParser(context) }.also { INSTANCE = it }
            }
        }
    }

    inline fun <reified T> getMappedData(name: String): T = gson.fromJson(getData(name), type<T>())

    inline fun <reified T> type(): Type = object : TypeToken<T>() {}.type

    fun getData(name: String): String? {
        return weakContext.get()?.let {
            val rawRes = it.resources.getIdentifier(name, "raw", it.packageName)
            val stream = it.resources.openRawResource(rawRes)
            BufferedReader(InputStreamReader(stream, Charset.defaultCharset()))
                .lines()
                .collect(Collectors.joining(System.lineSeparator()))
        }
    }
}