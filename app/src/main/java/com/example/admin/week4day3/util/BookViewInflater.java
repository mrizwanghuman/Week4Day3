package com.example.admin.week4day3.util;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.week4day3.R;
import com.example.admin.week4day3.model.BookModel;

import java.util.List;

/**
 * Created by  Admin on 11/29/2017.
 */

public class BookViewInflater extends RecyclerView.Adapter<BookViewInflater.ViewHolder> {
    Context context;
    List<BookModel> bookModels;
    private String bookTitle;
    private String bookAuthore;
    private String bookImage;

    public BookViewInflater(List<BookModel> stringList) {
        this.bookModels = stringList;
    }

    @Override
    public BookViewInflater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_recyle_view, parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewInflater.ViewHolder holder, int position) {
        bookTitle = bookModels.get(position).getTitle();
        bookAuthore = bookModels.get(position).getAuthor();
        bookImage = bookModels.get(position).getImageURL();
        Glide.with(context).load(bookImage).into(holder.ivimageView);
        holder.tvbookTile.setText(bookTitle);
//        holder.tvbookAuthore.setText(bookAuthore);
        // holder.ivimageView.setImageURI(bookImage);
    }

    @Override
    public int getItemCount() {
        return bookModels.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvbookTile;
        TextView tvbookAuthore;
        ImageView ivimageView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvbookTile = itemView.findViewById(R.id.book_title_view);
//            tvbookAuthore = itemView.findViewById(R.id.book_author_view);
            ivimageView = itemView.findViewById(R.id.book_image_view);
        }
    }
}
