package com.squad.afro.texttrade;

import android.widget.ImageView;

import com.google.firebase.auth.FirebaseUser;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by romeo on 11/25/2017.
 * This class represents the book class, everysingle time somebody
 * wants to sell a new book, an object of this class is createds
 */

public class Book extends RealmObject {
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @PrimaryKey
    private int bookId;
    private String mBookTitle;
    private String mAuthor;
    private Double mBookprice;
    private int mISBN;
    private String mBookEdition;
    private String mClass;
    private String mUser;
    private Boolean mStatus;


    public Book(String bookTitle, String author, Double bookprice, String bookEdition,
                String Class,  int ISBN,  String user ) {
        this.setBookId(0);
        this.setmBookTitle(bookTitle);
        this.setmAuthor(author);
        this.setmBookEdition(bookEdition);
        this.setmClass(Class);
        this.setmBookprice(bookprice);
        this.setmISBN(ISBN);
        this.setmUser(user);
        this.setStatus(true); //False is sold, True is for sale

    }

    public String getmBookTitle() {
        return mBookTitle;
    }

    public void setmBookTitle(String mBookTitle) {
        this.mBookTitle = mBookTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public Double getmBookprice() {
        return mBookprice;
    }

    public void setmBookprice(Double mBookprice) {
        this.mBookprice = mBookprice;
    }

    public int getmISBN() {
        return mISBN;
    }

    public void setmISBN(int mISBN) {
        this.mISBN = mISBN;
    }


    public String getmBookEdition() {
        return mBookEdition;
    }

    public void setmBookEdition(String mBookEdition) {
        this.mBookEdition = mBookEdition;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }

    public String getmUser() {
        return mUser;
    }

    public void setmUser(String mUser) {
        this.mUser = mUser;
    }

    public Boolean getmStatus() {
        return mStatus;
    }

    public void setmStatus(Boolean mStatus) {
        this.mStatus = mStatus;
    }


    public Book() {

    }


    public void setStatus (boolean state) {
        mStatus = state;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("title", mBookTitle);
        result.put("author", mAuthor);
        result.put("edition", mBookEdition);
        result.put("isbn", mISBN);
        result.put("class", mClass);
        result.put("userid", mUser);
        result.put("price", mBookprice);
        result.put("status", mStatus);

        return result;
    }
}
