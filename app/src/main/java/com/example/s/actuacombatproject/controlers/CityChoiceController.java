package com.example.s.actuacombatproject.controlers;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.example.s.actuacombatproject.MyApplication;
import com.example.s.actuacombatproject.R;
import com.example.s.actuacombatproject.activitis.CityChoiceActivity;
import com.example.s.actuacombatproject.databinding.ActivityCityChoiceBinding;
import com.example.s.actuacombatproject.service.LocationService;

/**
 * Created by s on 17-6-19.
 */

public class CityChoiceController {
    private ActivityCityChoiceBinding binding;
    private CityChoiceActivity cityChoiceActivity;
    private MyApplication application;
    private LocationService locationService;

    public CityChoiceController(CityChoiceActivity cityChoiceActivity, ActivityCityChoiceBinding binding) {
        this.cityChoiceActivity = cityChoiceActivity;
        this.binding = binding;
        setScrollViewTextColor();
        setCityText();
    }

    private void setScrollViewTextColor() {
        // 设置该SearchView默认是否自动缩小为图标
        binding.scrollView.setIconifiedByDefault(false);
        // 为该SearchView组件设置事件监听器
        setScrollViewOnClick();
        // 设置该SearchView显示搜索按钮
        binding.scrollView.setSubmitButtonEnabled(true);

        int id = binding.scrollView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView viewById = (TextView) binding.scrollView.findViewById(id);
        viewById.setTextColor(Color.BLACK);
        SpannableString spanText = new SpannableString("请输入城市名字或首字母查找");
        spanText.setSpan(
                new ForegroundColorSpan(Color.GRAY),
                0,
                spanText.length(),
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        binding.scrollView.setQueryHint(spanText);
    }

    /**
     * 为该SearchView组件设置事件监听器
     */
    private void setScrollViewOnClick() {
        binding.scrollView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    /**
     * 设置城市定位文本
     */
    private void setCityText() {
        application = (MyApplication) cityChoiceActivity.getApplication();

        locationService = application.getLocationService();
        setBDLocationListener();
        locationService.start();
    }

    /**
     * 百度地图的监听事件
     */
    private void setBDLocationListener() {
        locationService.registerListener(new BDLocationListener() {
            @Override
            public void onReceiveLocation(final BDLocation bdLocation) {
                cityChoiceActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        binding.city.setText(bdLocation.getCity());
                    }
                });
            }

            @Override
            public void onConnectHotSpotMessage(String s, int i) {

            }
        });
    }

}
