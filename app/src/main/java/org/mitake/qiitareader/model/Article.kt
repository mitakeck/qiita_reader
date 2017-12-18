package org.mitake.qiitareader.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by mitake on 2017/12/17.
 */
data class Article(val id: String, val title: String, val url: String, val user: User): Parcelable {

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Article> = object: Parcelable.Creator<Article> {
            override fun createFromParcel(p0: Parcel?): Article? =
                p0?.run {
                    Article(readString(), readString(), readString(), readParcelable(Article::class.java.classLoader))
                }


            override fun newArray(p0: Int): Array<Article?> = arrayOfNulls<Article>(p0)
        }
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.run {
            writeString(id)
            writeString(title)
            writeString(url)
            writeParcelable(user, flags)
        }
    }

    override fun describeContents(): Int = 0
}