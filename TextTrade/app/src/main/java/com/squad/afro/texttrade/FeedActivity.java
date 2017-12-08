package com.squad.afro.texttrade;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class FeedActivity extends AppCompatActivity {
    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNav_view;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        mDrawerlayout = findViewById(R.id.feed_activity);

        mToggle = new ActionBarDrawerToggle(
                this, mDrawerlayout, R.string.open, R.string.close);
        realm = Realm.getDefaultInstance();

        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNav_view = findViewById(R.id.nav_view);
        mNav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.nav_profile:
                        startActivity(new Intent(FeedActivity.this, Profile.class));
                        finish();
                        return true;
                    case R.id.nav_sell:
                        startActivity(new Intent(FeedActivity.this, ListItemActivity.class));
                        finish();
                        return true;
                    case R.id.nav_buy:
                        Toast.makeText(
                                FeedActivity.this, "You are already on the page", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_settings:
                        //TODO Implement a setting acitivity
                        break;
                    case R.id.nav_logout:
                        FirebaseAuth.getInstance().signOut();
                        return true;
                }
                return true;
            }
        });

        Books().addChangeListener(new RealmChangeListener<RealmResults<Book>>() {
            @Override
            public void onChange(RealmResults<Book> books) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public RealmResults<Book> Books() {
        RealmResults<Book> books = realm.where(Book.class).equalTo("mStatus", true).findAllAsync();
        return books;
    }
}
