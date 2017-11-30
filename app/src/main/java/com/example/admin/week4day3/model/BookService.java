package com.example.admin.week4day3.model;



import java.util.List;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by  Admin on 11/29/2017.
 */

public interface BookService {
    @GET("books.json")
    Observable<List<BookModel>> getBooks();
}
