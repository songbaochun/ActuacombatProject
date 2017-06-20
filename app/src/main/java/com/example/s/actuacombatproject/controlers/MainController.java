package com.example.s.actuacombatproject.controlers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.example.s.actuacombatproject.R;
import com.example.s.actuacombatproject.activitis.MainActivity;
import com.example.s.actuacombatproject.databinding.ActivityMainBinding;
import com.example.s.actuacombatproject.fragments.CarBuyingFragment;
import com.example.s.actuacombatproject.fragments.CommunityFragment;
import com.example.s.actuacombatproject.fragments.ExaminationFragment;
import com.example.s.actuacombatproject.fragments.FindFragment;
import com.example.s.actuacombatproject.fragments.SignUpFragment;
import com.example.s.actuacombatproject.fragments.WelfareFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s on 17-6-19.
 */

public class MainController implements View.OnClickListener {
    private FragmentManager fragmentManager;
    private ActivityMainBinding binding;
    private MainActivity mainActivity;
    private ExaminationFragment examinationFragment;//考试
    private CommunityFragment communityFragment;//社区
    private CarBuyingFragment carBuyingFragment;//购车
    private FindFragment findFragment;//发现
    private SignUpController signUpController;//报名
    private WelfareFragment welfareFragment;// 福利
    // private List<Fragment> fragmentList = new ArrayList<>();

    public MainController(MainActivity mainActivity, ActivityMainBinding binding) {
        this.mainActivity = mainActivity;
        this.binding = binding;
        initView();
        addExamFragment();
        binding.radioButtonExamNormal.setOnClickListener(this);
        binding.radioButtonCommunity.setOnClickListener(this);
        binding.radioButtonWelfare.setOnClickListener(this);
        binding.radioButtonFind.setOnClickListener(this);
        binding.radioButtonNewCar.setOnClickListener(this);




    }

    /**
     * 初始化控件
     */
    private void initView() {
        fragmentManager = mainActivity.getSupportFragmentManager();
        examinationFragment = new ExaminationFragment();
        welfareFragment = new WelfareFragment();
        communityFragment = new CommunityFragment();
        findFragment = new FindFragment();
        carBuyingFragment = new CarBuyingFragment();


    }


    /**
     *
     */
    private void addExamFragment() {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainfragment, new ExaminationFragment())
                .commit();

    }

    private void addWelfareFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.mainfragment.getId(), welfareFragment)
                .commit();

    }

    private void addSchoolFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.mainfragment.getId(), communityFragment)
                .commit();

    }

    private void addFindFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.mainfragment.getId(), findFragment)
                .commit();

    }

    private void addNewCarFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.mainfragment.getId(), carBuyingFragment)
                .commit();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioButtonExamNormal:
                addExamFragment();
                break;
            case R.id.radioButtonWelfare:
                addWelfareFragment();
                break;
            case R.id.radioButtonCommunity:
                addSchoolFragment();
                break;
            case R.id.radioButtonFind:
                addFindFragment();
                break;
            case R.id.radioButtonNewCar:
                addNewCarFragment();
                break;

        }
    }
}
