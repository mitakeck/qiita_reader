package org.mitake.qiitareader.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by mitake on 2017/12/17.
 */
data class User(val id: String, val name: String, val profileImageUri: String): Parcelable {

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object: Parcelable.Creator<User> {
            override fun newArray(size: Int): Array<User?> {
                return arrayOfNulls<User>(size)
            }

            override fun createFromParcel(source: Parcel?): User? = source?.run {
                User(readString(), readString(), readString())
            }
        }
    }
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.run {
            writeString(id)
            writeString(name)
            writeString(profileImageUri)
        }
    }

    override fun describeContents(): Int = 0
}