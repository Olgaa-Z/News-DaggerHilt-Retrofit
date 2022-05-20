package binar.andlima.news_daggerhilt_retrofit.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.andlima.news_daggerhilt_retrofit.R
import binar.andlima.news_daggerhilt_retrofit.model.ResponseNewsItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private var onClick : (ResponseNewsItem)->Unit) :RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var datanews : List<ResponseNewsItem>? = null

    fun setDataNews(news : List<ResponseNewsItem>){
        this.datanews = news
    }
    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val  tampilanui = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)

        return ViewHolder(tampilanui)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.itemView.titleNews.text = datanews!![position].title
        holder.itemView.dateNews.text= datanews!![position].createdAt
        holder.itemView.authorNews.text = datanews!![position].author
        Glide.with(holder.itemView.context).load(datanews!![position].image).into(holder.itemView.imgNews)
        holder.itemView.cardNews.setOnClickListener {
            onClick(datanews!![position])
        }
    }

    override fun getItemCount(): Int {
        if (datanews == null){
            return  0
        }else{
            return datanews!!.size
        }
    }

}