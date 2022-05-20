package binar.andlima.news_daggerhilt_retrofit.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import binar.andlima.news_daggerhilt_retrofit.R
import binar.andlima.news_daggerhilt_retrofit.view.NewsDetail.Companion.EXTRA_ID
import binar.andlima.news_daggerhilt_retrofit.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDataNews()
    }

    fun  getDataNews(){

        val newsadapter = NewsAdapter(){
            val pindahdata = Intent(applicationContext, NewsDetail::class.java)
            pindahdata.putExtra("detailnews", it)
            pindahdata.putExtra(NewsDetail.EXTRA_ID, it.id)
            startActivity(pindahdata)
        }

        rvNews.layoutManager = LinearLayoutManager(this)
        rvNews.adapter = newsadapter

        val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.new.observe(this, {
            if ( it != null){
                newsadapter.setDataNews(it)
                newsadapter.notifyDataSetChanged()
            }
        })
    }
}