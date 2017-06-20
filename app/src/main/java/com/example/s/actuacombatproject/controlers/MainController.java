package com.example.s.actuacombatproject.controlers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.s.actuacombatproject.activitis.MainActivity;
import com.example.s.actuacombatproject.databinding.ActivityMainBinding;
import com.example.s.actuacombatproject.fragments.ExaminationFragment;
import com.example.s.actuacombatproject.fragments.SignUpFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s on 17-6-19.
 */

public class MainController {
    private FragmentManager fragmentManager;
    private ActivityMainBinding binding;
    private MainActivity mainActivity;
    private ExaminationFragment examinationFragment;//考试
    private List<Fragment> fragmentList = new ArrayList<>();

    public MainController(MainActivity mainActivity, ActivityMainBinding binding) {
        this.mainActivity = mainActivity;
        this.binding = binding;
        initView();
        addFragment();
        setMainViewPagerAdapter(getFragmentPagerAdapter());
    }

    /**
     * 初始化控件
     */
    private void initView() {
        fragmentManager = mainActivity.getSupportFragmentManager();
        examinationFragment = new ExaminationFragment();


    }

    /**
     * 设置mainViewPager
     *
     * @param fragmentPagerAdapter
     */
    private void setMainViewPagerAdapter(FragmentPagerAdapter fragmentPagerAdapter) {
        binding.mainviewpager.setAdapter(fragmentPagerAdapter);

    }

    /**
     * 向ListView添加Fragment
     */
    private void addFragment() {
        fragmentList.add(examinationFragment);

    }


    /**
     * 返回FragmentPagerAdapter
     *
     * @return
     */
    private FragmentPagerAdapter getFragmentPagerAdapter() {

        return new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                //设置当前页面 等同于跳转 true 平滑滚动到指定下标页面  false 立即过渡到指定下标页面 默认false
                binding.mainviewpager.setCurrentItem(position, true);
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
    }
}
