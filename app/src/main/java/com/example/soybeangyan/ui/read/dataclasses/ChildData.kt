package com.example.soybeangyan.ui.read.dataclasses

import android.os.Parcel
import android.os.Parcelable


data class ChildData(
    var title: String,
    var image: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChildData> {
        override fun createFromParcel(parcel: Parcel): ChildData {
            return ChildData(parcel)
        }

        override fun newArray(size: Int): Array<ChildData?> {
            return arrayOfNulls(size)
        }
    }
    fun getChildName(): String {
        return title
    }
}