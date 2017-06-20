package com.example.s.actuacombatproject.activitis;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.example.s.actuacombatproject.MyApplication;
import com.example.s.actuacombatproject.R;
import com.example.s.actuacombatproject.controlers.CityChoiceController;
import com.example.s.actuacombatproject.databinding.ActivityCityChoiceBinding;
import com.example.s.actuacombatproject.service.LocationService;

/**
 * 城市选择
 */
public class CityChoiceActivity extends AppCompatActivity{
    private ActivityCityChoiceBinding binding;
    private CityChoiceController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(CityChoiceActivity.this,R.layout.activity_city_choice);
         controller=new CityChoiceController(this,binding);
        binding.setContorller(controller);

    }






}
