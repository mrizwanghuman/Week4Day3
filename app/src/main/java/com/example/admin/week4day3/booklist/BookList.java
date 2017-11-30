package com.example.admin.week4day3.booklist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.week4day3.util.BookViewInflater;
import com.example.admin.week4day3.R;
import com.example.admin.week4day3.util.RetfrofiteHelper;
import com.example.admin.week4day3.model.BookModel;
import com.example.admin.week4day3.model.BookService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BookList extends AppCompatActivity implements BookListContract.View{

RecyclerView recyclerView;
    BookListPresenter presenter;
    private static final String TAG = "BokList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter= new BookListPresenter();
presenter.attachView(this);
presenter.getBooks();
        recyclerView = findViewById(R.id.book_rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: "+error);
    }

    @Override
    public void setBooks(List<BookModel> bookModels) {
        BookViewInflater recyleviewAdapter = new BookViewInflater(bookModels);

//        for (int i = 0; i < bookModels.size(); i++) {
//            Log.d(TAG, "setBooks: "+bookModels.get(i).getTitle());
            recyclerView.setAdapter(recyleviewAdapter);


    }

    @Override
    public void showProgress(String progress) {
        Toast.makeText(this, progress, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
