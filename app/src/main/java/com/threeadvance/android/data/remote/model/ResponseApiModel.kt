package com.threeadvance.android.data.remote.model

import com.google.gson.annotations.SerializedName

class ResponseApiModel<T>(
    /**
     * Indicates the success or failure of the call. If code is 0, this indicates an HTTP 200 successful call.
     */
    val code: Int,

    /**
     * Contains object-specific attributes and data
     */
    val data: T,

    /**
     * ID of the account making the API call
     */
    @SerializedName("account_id")
    val accountId: Int
)