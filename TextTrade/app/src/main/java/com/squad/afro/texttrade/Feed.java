package com.squad.afro.texttrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Feed extends AppCompatActivity {
    private final static String TAG = "Error";
    private DatabaseReference books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        books = FirebaseDatabase.getInstance().getReference().child("books");

        books.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Book> allbooks = new ArrayList<>();
                allbooks = dataSnapshot.getValue(ArrayList.class);

                ListView listView = findViewById(R.id.listview);
                BookAdapter adapter = new BookAdapter(getApplicationContext(), R.layout.book_view, allbooks);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "getUser:onCancelled", databaseError.toException());
            }
        });


    }
}
