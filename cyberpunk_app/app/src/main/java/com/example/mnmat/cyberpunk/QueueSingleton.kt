package com.example.mnmat.cyberpunk

import android.content.Context

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley

/**
 * Created by mnmat on 14/10/2017.
 */
class QueueSingleton private constructor(context: Context) {
    private var mRequestQueue: RequestQueue? = null

    // getApplicationContext() is key, it keeps you from leaking the
    // Activity or BroadcastReceiver if someone passes one in.
    val requestQueue: RequestQueue?
        get() {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(mCtx?.applicationContext)
            }
            return mRequestQueue
        }

    init {
        mCtx = context
        mRequestQueue = requestQueue
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        requestQueue?.add(req)
    }

    companion object {
        private var mInstance: QueueSingleton? = null
        private var mCtx: Context? = null

        @Synchronized
        fun getInstance(context: Context): QueueSingleton? {
            if (mInstance == null) {
                mInstance = QueueSingleton(context)
            }
            return mInstance
        }
    }
}
