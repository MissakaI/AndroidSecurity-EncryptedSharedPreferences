package com.example.androidsecurity.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * This class provides helper functions for shared preferences
 */
class SharedPreferenceHelper private constructor(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE)

    companion object {
        @Volatile
        private var instance: SharedPreferenceHelper? = null

        fun getInstance(context: Context): SharedPreferenceHelper {
            val currInstance = instance
            if (currInstance != null) {
                return currInstance
            }

            synchronized(this) {
                val createdInstance = SharedPreferenceHelper(context)
                instance = createdInstance
                return createdInstance
            }
        }
    }

    /**
     * This function saves a string value with the specified [key] to the shared preferences
     */
    fun saveString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    /**
     * This function retrieves a string value with the specified [key] from the shared preferences
     */
    fun getString(key: String): String? {
        return prefs.getString(key, null)
    }
}