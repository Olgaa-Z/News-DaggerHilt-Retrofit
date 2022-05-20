package binar.andlima.news_daggerhilt_retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.andlima.news_daggerhilt_retrofit.R
import binar.andlima.news_daggerhilt_retrofit.model.ResponseNewsItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetail : AppCompatActivity() {

    companion object{
        const val  EXTRA_ID = "extra_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val detailnews = intent.getParcelableExtra("detailnews") as ResponseNewsItem?
        tvDetailjudul.text = detailnews?.title
        tvDetailAuthor.text = detailnews?.author
        tvDetailDate.text= detailnews?.createdAt
        tvDetailDescription.text = detailnews?.description
        Glide.with(this).load(detailnews?.image).into(imgDetail)
    }
}