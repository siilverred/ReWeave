package edu.uph.m23si2.reweave_charlene;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if the fragment is already added, if not, show FormulirDonasi fragment
        if (savedInstanceState == null) {
            // Create an instance of FormulirDonasi fragment
            FormulirDonasi formulirDonasiFragment = new FormulirDonasi();
            // Start a fragment transaction to replace the layout container with the FormulirDonasi fragment
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, formulirDonasiFragment); // Replace with the fragment container in the layout
            transaction.commit();
        }
    }
}
