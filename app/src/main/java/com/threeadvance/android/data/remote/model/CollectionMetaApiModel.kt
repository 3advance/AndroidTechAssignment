package com.threeadvance.android.data.remote.model

import com.google.gson.annotations.SerializedName

data class CollectionMetaApiModel(
    val id: Int, // To be changed to string later.
    val name: String?,
    val fields: FieldMetasApiModel, // meta data on fields for this object
    val label: String?,
    val alias: String?,
    val singular: String?,
    val plural: String?,
    val possessive: String?,
    @SerializedName("plural_possessive")
    val pluralPossessive: String?,
    val icon: String?,
    val theme: String?,
    val key: String?,
    @SerializedName("external_key")
    val externalKey: String?
)

class FieldMetasApiModel : HashMap<String, FieldMetaApiModel>()

class FieldMetaApiModel(
    val alias: String,
    val field: String?,
    val type: String,
    val required: Int,
    val viewable: Int,
    val editable: Int,
    val deletable: Int,
    @SerializedName("parent_object")
    val parentObject: String?,
    val options: LinkedHashMap<String, String>?,
    val colors: LinkedHashMap<String, ColorApiModel>?,
    @SerializedName("extra_data")
    val extraData: String?
)

class ColorApiModel(
    val color: String
)