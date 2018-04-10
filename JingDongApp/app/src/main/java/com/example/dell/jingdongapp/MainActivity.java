package com.example.dell.jingdongapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.dell.jingdongapp.view.Fragment1;
import com.example.dell.jingdongapp.view.Fragment2;
import com.example.dell.jingdongapp.view.Fragment3;
import com.example.dell.jingdongapp.view.Fragment4;
import com.example.dell.jingdongapp.view.Fragment5;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private RadioGroup mRg;
    private List<Fragment> list;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private Fragment5 fragment5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        list=new ArrayList<>();
        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();
        fragment5=new Fragment5();

        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);
        list.add(fragment5);

        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mRg.check(R.id.btn1);
                        break;
                    case 1:
                        mRg.check(R.id.btn2);
                        break;
                    case 2:
                        mRg.check(R.id.btn3);
                        break;
                    case 3:
                        mRg.check(R.id.btn4);
                        break;
                    case 4:
                        mRg.check(R.id.btn5);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.btn1:
                        mVp.setCurrentItem(0);
                        break;
                    case R.id.btn2:
                        mVp.setCurrentItem(1);
                        break;
                    case R.id.btn3:
                        mVp.setCurrentItem(2);
                        break;
                    case R.id.btn4:
                        mVp.setCurrentItem(3);
                        break;
                    case R.id.btn5:
                        mVp.setCurrentItem(5);
                        break;
                }
            }
        });

        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mRg = (RadioGroup) findViewById(R.id.rg);
    }
}
