package com.jakewharton.sdksearch.ui

import android.app.Activity
import android.support.v4.app.ShareCompat.IntentBuilder
import com.jakewharton.sdksearch.R
import com.jakewharton.sdksearch.search.ui.ItemHandler
import com.jakewharton.sdksearch.store.item.Item
import okhttp3.HttpUrl

internal class ShareItemHandler(
  private val activity: Activity,
  private val baseUrl: HttpUrl
) : ItemHandler {
  override fun invoke(item: Item) {
    val uri = baseUrl.resolve(item.link)!!
    IntentBuilder.from(activity)
        .setType("text/plain")
        .setChooserTitle(activity.getString(R.string.share_title, item.className))
        .setText(uri.toString())
        .startChooser()
  }
}
