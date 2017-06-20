package com.example.s.actuacombatproject.controlers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.s.actuacombatproject.databinding.FragmentExaminationBinding;
import com.example.s.actuacombatproject.fragments.CarBuyingFragment;
import com.example.s.actuacombatproject.fragments.CommunityFragment;
import com.example.s.actuacombatproject.fragments.ExaminationFragment;
import com.example.s.actuacombatproject.fragments.FindFragment;
import com.example.s.actuacombatproject.fragments.SignUpFragment;
import com.example.s.actuacombatproject.fragments.SubjectForFragment;
import com.example.s.actuacombatproject.fragments.SubjectOneFragment;
import com.example.s.actuacombatproject.fragments.SubjectThreeFragment;
import com.example.s.actuacombatproject.fragments.SubjectTwoFragment;
import com.example.s.actuacombatproject.fragments.TakeThisFragment;
import com.example.s.actuacombatproject.fragments.WelfareFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s on 17-6-19.
 */

public class ExaminationController implements ViewPager.OnPageChangeListener {
    private ExaminationFragment examinationFragment;
    private FragmentExaminationBinding binding;
    private FragmentManager fragmentManager;
    private List<Fragment> list = new ArrayList<>();
    private SignUpFragment signUpFragment;
    private SubjectOneFragment subjectOneFragment;
    private SubjectTwoFragment subjectTwoFragment;
    private SubjectThreeFragment subjectThreeFragment;
    private SubjectForFragment subjectForFragment;
    private TakeThisFragment takeThisFragment;

    public ExaminationController(ExaminationFragment examinationFragment, FragmentExaminationBinding binding) {
        this.examinationFragment = examinationFragment;
        this.binding = binding;
        initView();
        addFragment();
        binding.tabs.setupWithViewPager(binding.examinationViewPager);

    }

    /**
     * 初始化控件
     */
    private void initView() {
        fragmentManager = examinationFragment.getFragmentManager();
        signUpFragment = new SignUpFragment();
        subjectOneFragment = new SubjectOneFragment();
        subjectTwoFragment = new SubjectTwoFragment();
        subjectThreeFragment = new SubjectThreeFragment();
        subjectForFragment = new SubjectForFragment();
        takeThisFragment = new TakeThisFragment();


        binding.examinationViewPager.setOnPageChangeListener(this);

    }

    /**
     * 设置mainViewPager
     *
     * @param fragmentPagerAdapter
     */
    private void setMainViewPagerAdapter(FragmentPagerAdapter fragmentPagerAdapter) {
        binding.examinationViewPager.setAdapter(fragmentPagerAdapter);
        fragmentPagerAdapter.notifyDataSetChanged();
    }

    /**
     * 向ListView添加Fragment
     */
    private void addFragment() {
        list.add(signUpFragment);
        list.add(subjectOneFragment);
        list.add(subjectTwoFragment);
        list.add(subjectThreeFragment);
        list.add(subjectForFragment);
        list.add(takeThisFragment);
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
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public void notifyDataSetChanged() {
                getCount();
                super.notifyDataSetChanged();
            }

            @Override
            public int getItemPosition(Object object) {
                return super.getItemPosition(object);
            }
        };
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

//        if (position==0){
//            binding.buttonApplySelected.setVisibility(View.GONE);
//            binding.buttonApply.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionA.setVisibility(View.GONE);
//            binding.buttonSectionASelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionB.setVisibility(View.GONE);
//            binding.buttonSectionBSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionC.setVisibility(View.GONE);
//            binding.buttonSectionCSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionD.setVisibility(View.GONE);
//            binding.buttonSectionDSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionE.setVisibility(View.GONE);
//            binding.buttonSectionESelected.setVisibility(View.VISIBLE);
//
//        }else if (position==1){
//            binding.buttonApplySelected.setVisibility(View.VISIBLE);
//            binding.buttonApply.setVisibility(View.GONE);
//
//            binding.buttonSectionA.setVisibility(View.VISIBLE);
//            binding.buttonSectionASelected.setVisibility(View.GONE);
//
//            binding.buttonSectionB.setVisibility(View.GONE);
//            binding.buttonSectionBSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionC.setVisibility(View.GONE);
//            binding.buttonSectionCSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionD.setVisibility(View.GONE);
//            binding.buttonSectionDSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionE.setVisibility(View.GONE);
//            binding.buttonSectionESelected.setVisibility(View.VISIBLE);
//        }else if (position==2){
//            binding.buttonApplySelected.setVisibility(View.VISIBLE);
//            binding.buttonApply.setVisibility(View.GONE);
//
//            binding.buttonSectionA.setVisibility(View.GONE);
//            binding.buttonSectionASelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionB.setVisibility(View.VISIBLE);
//            binding.buttonSectionBSelected.setVisibility(View.GONE);
//
//            binding.buttonSectionC.setVisibility(View.GONE);
//            binding.buttonSectionCSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionD.setVisibility(View.GONE);
//            binding.buttonSectionDSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionE.setVisibility(View.GONE);
//            binding.buttonSectionESelected.setVisibility(View.VISIBLE);
//        }else if (position==3){
//            binding.buttonApplySelected.setVisibility(View.VISIBLE);
//            binding.buttonApply.setVisibility(View.GONE);
//
//            binding.buttonSectionA.setVisibility(View.GONE);
//            binding.buttonSectionASelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionB.setVisibility(View.GONE);
//            binding.buttonSectionBSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionC.setVisibility(View.VISIBLE);
//            binding.buttonSectionCSelected.setVisibility(View.GONE);
//
//            binding.buttonSectionD.setVisibility(View.GONE);
//            binding.buttonSectionDSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionE.setVisibility(View.GONE);
//            binding.buttonSectionESelected.setVisibility(View.VISIBLE);
//        } else if (position==4) {
//            binding.buttonApplySelected.setVisibility(View.VISIBLE);
//            binding.buttonApply.setVisibility(View.GONE);
//
//            binding.buttonSectionA.setVisibility(View.GONE);
//            binding.buttonSectionASelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionB.setVisibility(View.GONE);
//            binding.buttonSectionBSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionC.setVisibility(View.GONE);
//            binding.buttonSectionCSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionD.setVisibility(View.VISIBLE);
//            binding.buttonSectionDSelected.setVisibility(View.GONE);
//
//            binding.buttonSectionE.setVisibility(View.GONE);
//            binding.buttonSectionESelected.setVisibility(View.VISIBLE);
//        }else if (position==5){
//            binding.buttonApplySelected.setVisibility(View.VISIBLE);
//            binding.buttonApply.setVisibility(View.GONE);
//
//            binding.buttonSectionA.setVisibility(View.GONE);
//            binding.buttonSectionASelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionB.setVisibility(View.GONE);
//            binding.buttonSectionBSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionC.setVisibility(View.GONE);
//            binding.buttonSectionCSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionD.setVisibility(View.GONE);
//            binding.buttonSectionDSelected.setVisibility(View.VISIBLE);
//
//            binding.buttonSectionE.setVisibility(View.VISIBLE);
//            binding.buttonSectionESelected.setVisibility(View.GONE);
//        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void onResume() {
        setMainViewPagerAdapter(getFragmentPagerAdapter());
    }
}
