package com.example.admin.week4day3.booklist;

import android.util.Log;

import com.example.admin.week4day3.model.BookModel;
import com.example.admin.week4day3.util.RetfrofiteHelper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by  Admin on 11/29/2017.
 */

public class BookListPresenter implements BookListContract.Presenter {
    BookListContract.View view;
    List<BookModel> bookModelList = new ArrayList<>();
    @Override
    public void attachView(BookListContract.View view) {
        this.view= view;
    }

    @Override
    public void detachView() {
this.view= null;
    }

    @Override
    public void getBooks() {
        RetfrofiteHelper.getBooksHelper().observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).subscribe(new Observer<List<BookModel>>() {
            @Override
            public void onSubscribe(Disposable d) {
                view.showProgress("Books are Loading");
            }

            @Override
            public void onNext(List<BookModel> bookModels) {
                Log.d("TAG", "onNext: "+bookModels.size());
bookModelList.addAll(bookModels);
            }

            @Override
            public void onError(Throwable e) {
view.showError(e.toString());
            }

            @Override
            public void onComplete() {
view.showProgress("Check your log");
view.setBooks(bookModelList);
view.showProgress("Done");
            }
        });
    }
}
