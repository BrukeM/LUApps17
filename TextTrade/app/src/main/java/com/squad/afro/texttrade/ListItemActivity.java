package com.squad.afro.texttrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class ListItemActivity extends AppCompatActivity {
    EditText mBookName;
    EditText mBookEdition;
    EditText mBookISBN;
    EditText mBookPrice;
    EditText mClass;
    EditText mAuthor;
    Button mSubmit;
    FirebaseUser mUser;

    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        mDatabase = FirebaseDatabase.getInstance("https://fir-texttrade.firebaseio.com/").getReference();

        mUser = FirebaseAuth.getInstance().getCurrentUser();

        mBookName = findViewById(R.id.bookname);
        mBookEdition = findViewById(R.id.bookEdition);
        mBookISBN = findViewById(R.id.isbn);
        mBookPrice = findViewById(R.id.Price);
        mClass = findViewById(R.id.Class);
        mSubmit = findViewById(R.id.submit);
        mAuthor = findViewById(R.id.author);


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bName = mBookName.getText().toString();
                String author = mAuthor.getText().toString();
                Double bPrice = Double.parseDouble(mBookPrice.getText().toString());
                String bEdition = mBookEdition.getText().toString();
                String bClass = mClass.getText().toString();
                int bISBN = Integer.parseInt(mBookISBN.getText().toString());
                String user = mUser.getEmail();

                Book book = new Book(bName, author, bPrice, bEdition, bClass, bISBN, null, user);
                submitData(book);
                Toast.makeText(ListItemActivity.this,
                        "Susccessful Submission",
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ListItemActivity.this, Profile.class);
                startActivity(i);

            }
        });

    }

    private void submitData(Book book) {
        String key = mDatabase.child("books").push().getKey();
        Map<String, Object> bookValues = book.toMap();

        Map<String, Object> childUpdates = new HashMap<>();

        childUpdates.put("/books/" + key, bookValues);
        childUpdates.put("/user-books/" + book.mUser + "/" + key, bookValues);

        mDatabase.updateChildren(childUpdates);

    }
}
