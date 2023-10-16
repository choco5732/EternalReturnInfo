package com.erionna.eternalreturninfo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import org.w3c.dom.Comment
import java.util.Date

@Parcelize
data class BoardModel (
    val id: String = "",
    val title: String = "",
    val content: String = "",
    val author: String = "",
    val date: Long = 0,
    @field:JvmField
    val comments: Map<String, @RawValue CommentModel> = mapOf()
) : Parcelable

data class CommentModel(
    val id: String = "",
    val author: String = "",
    val content: String = "",
    val date: Long = 0,
)