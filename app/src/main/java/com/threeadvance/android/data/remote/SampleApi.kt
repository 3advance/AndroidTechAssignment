package com.threeadvance.android.data.remote

import com.threeadvance.android.data.remote.model.CollectionInfoApiModel
import com.threeadvance.android.data.remote.model.CollectionMetaApiModel
import com.threeadvance.android.data.remote.model.ObjectApiModel
import com.threeadvance.android.data.remote.model.ResponseApiModel

class SampleApi(val resourceParser: ResourceParser) {

    fun getCollectionInfo(): ResponseApiModel<CollectionInfoApiModel> =
        resourceParser.getMappedData("collection_info")

    fun getCollectionMeta(): ResponseApiModel<CollectionMetaApiModel> =
        resourceParser.getMappedData("collection_meta")

    fun getCollectionObjects(): ResponseApiModel<List<ObjectApiModel>> =
        resourceParser.getMappedData("collection_objects")
}