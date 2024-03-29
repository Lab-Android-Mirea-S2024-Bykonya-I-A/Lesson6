package com.mirea.bykonyaia.internalfilestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mirea.bykonyaia.internalfilestorage.databinding.ActivityMainBinding;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void OnSaveTextButtonClicked(View v) {
        try {

            final FileOutputStream raw_stream = openFileOutput("data.txt", Context.MODE_PRIVATE);
            raw_stream.write(binding.inputTextPanel.getText().toString().getBytes());
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, String.format("Error: %s", e.toString()), Toast.LENGTH_LONG).show();
        }
    }
}