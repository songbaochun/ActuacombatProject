package com.example.s.actuacombatproject.activitis;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.s.actuacombatproject.R;
import com.example.s.actuacombatproject.controlers.MainController;
import com.example.s.actuacombatproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        controller = new MainController(this, binding);
        binding.setController(controller);
    }

}
