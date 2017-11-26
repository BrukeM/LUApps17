package com.squad.afro.texttrade;

import android.net.Uri;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseUser;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by romeo on 11/25/2017.
 * This class represents the book class, everysingle time somebody
 * wants to sell a new book, an object of this class is createds
 */

public class Book {
    public String mBookTitle;
    public String mAuthor;
    public Double mBookprice;
    public int mISBN;
    public Uri mBookPic;
    public String mBookEdition;
    public String mClass;
    public String mUser;
    public Boolean mStatus;

    public Book() {
        //
    }

    public Book(String bookTitle, String author, Double bookprice, String bookEdition,
                String Class,  int ISBN, Uri BookPic, String user ) {

        mBookTitle = bookTitle;
        mAuthor = author;
        mBookEdition = bookEdition;
        mClass = Class;
        mBookprice = bookprice;
        mISBN = ISBN;
        mBookPic = BookPic;
        mUser = user;
        mStatus = false;

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
        result.put("picture", mBookPic);
        result.put("class", mClass);
        result.put("userid", mUser);
        result.put("price", mBookprice);
        result.put("status", mStatus);

        return result;
    }
}
