package com.squad.afro.texttrade;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import io.realm.Realm;


public class ListItemActivity extends AppCompatActivity {
    static int id = 0;
    private static final String TAG = "AddingtoDatabase";
    private EditText mBookName;
    private EditText mBookEdition;
    private EditText mBookISBN;
    private EditText mBookPrice;
    private EditText mClass;
    private EditText mAuthor;
    Button mSubmit;
    FirebaseUser mUser;
    String userId;
    Realm realm = Realm.getDefaultInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);


        mUser = FirebaseAuth.getInstance().getCurrentUser();
        userId = mUser.getUid();

        mBookEdition = findViewById(R.id.bookEdition);
        mBookISBN = findViewById(R.id.isbn);
        mBookPrice = findViewById(R.id.Price);
        mClass = findViewById(R.id.Class);
        mSubmit = findViewById(R.id.submit);
        mAuthor = findViewById(R.id.author);


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick, submit pressed");

                String bName = mBookName.getText().toString();
                String author = mAuthor.getText().toString();
                Double bPrice = 0.0;
                String Price = mBookPrice.getText().toString();
                try {
                    bPrice = Double.parseDouble(Price);
                } catch (NumberFormatException e) {
                    Log.i("", Price + " is not an amount");
                    Toast.makeText(ListItemActivity.this, "Enter a number",
                            Toast.LENGTH_SHORT).show();
                }

                String bEdition = mBookEdition.getText().toString();
                String bClass = mClass.getText().toString();
                int bISBN = 0;
                String ISBN = mBookISBN.getText().toString();
                try {
                    bISBN = Integer.parseInt(ISBN);
                } catch (NumberFormatException e) {
                    Log.i("", Price + " is an Invalid ISBN");
                    Toast.makeText(ListItemActivity.this, "Enter a number",
                            Toast.LENGTH_SHORT).show();
                }
                String user = mUser.getEmail();

                //Check for empty for fields
                if (!bName.equals("") && !author.equals("") && !bEdition.equals("")
                        && !bClass.equals("") && bISBN != 0) {
                    Book book = new Book(bName, author, bPrice, bEdition, bClass, bISBN, user);
                    submitData(book);
                    Intent i = new Intent(ListItemActivity.this, Profile.class);
                    startActivity(i);
                } else {
                    Toast.makeText(ListItemActivity.this, "One or More field Empty! fill the fields",
                           Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void submitData(final Book book) {
        book.setBookId(id);
        book.setStatus(true);
        //True means for sale
        //false means not for sale
        id =+1;
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Book mBook = realm.copyToRealm(book);
            }
        });

    }
}
