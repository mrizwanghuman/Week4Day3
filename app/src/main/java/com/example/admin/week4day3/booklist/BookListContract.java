package com.example.admin.week4day3.booklist;

import com.example.admin.week4day3.model.BookModel;
import com.example.admin.week4day3.util.BasePresenter;
import com.example.admin.week4day3.util.BaseView;

import java.util.List;

/**
 * Created by  Admin on 11/29/2017.
 */

public class BookListContract {
    interface View extends BaseView{
        void setBooks(List<BookModel> bookModels);
        void showProgress(String progress);
    }
    interface Presenter extends BasePresenter<View>{
        void getBooks();

    }
}
