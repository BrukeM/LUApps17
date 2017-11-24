package com.squad.afro.texttrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListingItem extends AppCompatActivity {

    EditText mBookName;
    EditText mEdition;
    Button mSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_item);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRefbn = database.getReference("Bookname");
        final DatabaseReference myRefet = database.getReference("edition");


        mBookName = (EditText) findViewById(R.id.bookname);
        mEdition = (EditText) findViewById(R.id.edition);
        mSubmit = (Button) findViewById(R.id.mSubmit);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bookname = mBookName.getText().toString();
                String edition = mEdition.getText().toString();

                myRefbn.setValue(bookname);
                myRefet.setValue(edition);


            }
        });
    }
}
