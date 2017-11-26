package com.squad.afro.texttrade;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by romeo on 11/24/2017.
 */

public class SellingFragment extends Fragment {
    private static final String TAG = "SellingFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.selling_fragment, container, false);
        ListView listView = view.findViewById(R.id.listview);

        ArrayList<Book> mBooks = new ArrayList<Book>();
        return view;
    }
}
