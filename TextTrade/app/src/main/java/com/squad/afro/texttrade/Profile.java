package com.squad.afro.texttrade;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {
    private static final String TAG = "Profile";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        //Setting up ViewPager with adapters
        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        image = findViewById(R.id.imageView);
    }


    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new BuyingFragment(), "BuyingFragment");
        adapter.addFragment(new SellingFragment(), "SellingFragment");
        adapter.addFragment(new NotificationsFragment(), "NotificationsFragment");
        viewPager.setAdapter(adapter);
    }
}
