package com.squad.afro.texttrade;

import android.app.IntentService;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {
    private static final String TAG = "Profile";

    SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;
    Button listItem;
    Button feed;
    ImageView image;
    TextView mUsername;
    FirebaseUser mUser;
    TextView mEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mUser = FirebaseAuth.getInstance().getCurrentUser();

        mUsername = findViewById(R.id.user);
        mUsername.setText(mUser.getDisplayName());

        mEmail = findViewById(R.id.email);
        mEmail.setText(mUser.getEmail());

        image = findViewById(R.id.imageView);
        image.setImageURI(mUser.getPhotoUrl());

        Log.d(TAG, "onCreate: Got here");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        //Setting up ViewPager with adapters
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        listItem = findViewById(R.id.itemList);
        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, ListItemActivity.class);
                startActivity(i);

            }
        });

        feed = findViewById(R.id.feed);
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, FeedActivity .class);
                startActivity(i);
            }
        });

    }


    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new BuyingFragment(), "BuyingFragment");
        adapter.addFragment(new SellingFragment(), "SellingFragment");
        adapter.addFragment(new NotificationsFragment(), "NotificationsFragment");
        viewPager.setAdapter(adapter);
    }
}
