package com.squad.afro.texttrade;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by romeo on 11/24/2017.
 */

public class GoogleSignOut {

    private static void signOut() {
        // Firebase sign out
        FirebaseAuth.getInstance().signOut();

    }
}
