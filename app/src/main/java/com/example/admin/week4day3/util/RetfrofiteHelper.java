package com.example.admin.week4day3.util;

import com.example.admin.week4day3.model.BookModel;
import com.example.admin.week4day3.model.BookService;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by  Admin on 11/29/2017.
 */

public class RetfrofiteHelper {
    public static final String BASE_URL ="http://de-coding-test.s3.amazonaws.com/";
    public static Retrofit retrofitConfig(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
    public  static Observable<List<BookModel>> getBooksHelper(){
        Retrofit retrofit = retrofitConfig();
        BookService bookService = retrofit.create(BookService.class);
        return bookService.getBooks();
    }
}
