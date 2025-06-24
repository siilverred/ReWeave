package edu.uph.m23si2.reweave_charlene;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import edu.uph.m23si2.reweave_charlene.ui.login.reweave_login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cek apakah fragment sudah ada, jika belum, tampilkan LoginFragment
        if (savedInstanceState == null) {
            // Membuat instance dari LoginFragment
            reweave_login loginFragment = new reweave_login();
            // Memulai transaksi fragment untuk menggantikan layout container dengan fragment
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, loginFragment); // Ganti dengan container fragment di layout
            transaction.commit();
        }
    }
}