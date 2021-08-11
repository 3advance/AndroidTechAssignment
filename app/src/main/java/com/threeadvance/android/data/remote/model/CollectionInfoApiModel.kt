package com.threeadvance.android.data.remote.model

data class CollectionInfoApiModel(
    /**
     * List of field IDs that should be displayed on the UI.
     */
    val listFields: List<String>,
    val count: String // Total count of objects in a collection
)
