package com.thoughtworks.homeworkminiweibo.data

import com.google.gson.annotations.SerializedName

data class Moment(
    val id: String,
    @field:SerializedName("create_at")
    val createTime: String,
    val text: String,
    @field:SerializedName("pic_url")
    val picUrl: String
)
