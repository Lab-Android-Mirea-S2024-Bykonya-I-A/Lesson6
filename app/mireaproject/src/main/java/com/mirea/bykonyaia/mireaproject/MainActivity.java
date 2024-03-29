package com.mirea.bykonyaia.mireaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import com.mirea.bykonyaia.mireaproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private boolean is_permissions_granted = false;
    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fragmentsTab.setup();
        final TabHost.TabSpec profile_spec = binding.fragmentsTab.newTabSpec("Profile");
        profile_spec.setContent(R.id.user_settings_fragment);
        profile_spec.setIndicator("Profile");
        binding.fragmentsTab.addTab(profile_spec);

        final TabHost.TabSpec files_spec = binding.fragmentsTab.newTabSpec("Files");
        files_spec.setContent(R.id.user_file_fragment);
        files_spec.setIndicator("Files");
        binding.fragmentsTab.addTab(files_spec);
    }


    private void MakePermissionsRequest() {
        final boolean storage_enabled = PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        final boolean camera_enabled = PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA);

        if(storage_enabled && camera_enabled) {
            is_permissions_granted = true;
        } else {
            is_permissions_granted = false;
            ActivityCompat.requestPermissions(this,
                new	String[] { android.Manifest.permission.CAMERA,
                        android.Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                },	200);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.i("", "onRequestPermissionsResult: " + String.valueOf(requestCode));
        if(requestCode != 200) {
            Log.i("he-he", String.format("Code no 200: %d", requestCode));
            finish();
        }
        if(grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            Log.i("he-he", String.format("No granted: %d", grantResults[0]));
            finish();
        }
    }
}