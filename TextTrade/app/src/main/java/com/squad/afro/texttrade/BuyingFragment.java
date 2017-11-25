package com.squad.afro.texttrade;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by romeo on 11/24/2017.
 */

public class BuyingFragment extends Fragment {
    private static final String TAG = "BuyingFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.Buying_fragment, container, false);

        return view;
    }
}
