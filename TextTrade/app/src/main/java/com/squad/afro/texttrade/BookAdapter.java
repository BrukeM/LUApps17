package com.squad.afro.texttrade;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by romeo on 11/25/2017.
 */

public class BookAdapter extends ArrayAdapter<Book> {
    Context mContext;
    int mResource;
    ArrayList<Book> mBooks = null;

    public BookAdapter(@NonNull Context context, int resource, ArrayList<Book> books) {
        super(context, resource, books);

        mContext = context;
        mResource = resource;
        mBooks = books;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Book curBook = mBooks.get(position);

        if (convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.book_view, parent, false);

        TextView bookName = convertView.findViewById(R.id.bookname);
        TextView bookISBN = convertView.findViewById(R.id.isbn);
        TextView bookEdition = convertView.findViewById(R.id.bookEdition);
        TextView Class = convertView.findViewById(R.id.Class);
        TextView bookPrice = convertView.findViewById(R.id.Price);
        TextView seller = convertView.findViewById(R.id.seller);
        ImageView bookPic = convertView.findViewById(R.id.bPic);

        bookName.setText(curBook.mBookTitle);
        bookISBN.setText(curBook.mISBN);
        bookEdition.setText(curBook.mBookEdition);
        Class.setText(curBook.mClass);
        bookPrice.setText(curBook.mBookprice.toString());
        String email = curBook.mUser;
        seller.setText(email);
        bookPic.setImageURI(curBook.mBookPic);

    return convertView;
    }
}
