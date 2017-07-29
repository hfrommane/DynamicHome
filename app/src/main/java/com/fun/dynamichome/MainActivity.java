package com.fun.dynamichome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.fun.dynamichome.fragment.BusinessFragment;
import com.fun.dynamichome.fragment.ExpoFragment;
import com.fun.dynamichome.fragment.HomeFragment;
import com.fun.dynamichome.fragment.MineFragment;
import com.fun.dynamichome.fragment.NoticeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup contentRadioGroup;
    private List<Fragment> fragments;
    private FragmentManager fragmentManager;
    private FragmentTransaction transition;
    private HomeFragment homeFragment;
    private BusinessFragment businessFragment;
    private ExpoFragment expoFragment;
    private NoticeFragment noticeFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        contentRadioGroup = (RadioGroup) findViewById(R.id.content_rg);

        fragmentManager = getSupportFragmentManager();
        fragments = new ArrayList<>();

        // 添加首页
        contentRadioGroup.check(R.id.content_rb_home);
        homeFragment = new HomeFragment();
        fragments.add(homeFragment);
        hideOthersFragment(homeFragment, true);

        contentRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.content_rb_home:       // 首页
                        hideOthersFragment(homeFragment, false);
                        break;
                    case R.id.content_rb_expo:       // 展会
                        if (expoFragment == null) {
                            expoFragment = new ExpoFragment();
                            fragments.add(expoFragment);
                            hideOthersFragment(expoFragment, true);
                        } else {
                            hideOthersFragment(expoFragment, false);
                        }
                        break;
                    case R.id.content_rb_notice:     // 活动
                        if (noticeFragment == null) {
                            noticeFragment = new NoticeFragment();
                            fragments.add(noticeFragment);
                            hideOthersFragment(noticeFragment, true);
                        } else {
                            hideOthersFragment(noticeFragment, false);
                        }
                        break;
                    case R.id.content_rb_business:    // 业务
                        if (businessFragment == null) {
                            businessFragment = new BusinessFragment();
                            fragments.add(businessFragment);
                            hideOthersFragment(businessFragment, true);
                        } else {
                            hideOthersFragment(businessFragment, false);
                        }
                        break;
                    case R.id.content_rb_mine:       // 我的
                        if (mineFragment == null) {
                            mineFragment = new MineFragment();
                            fragments.add(mineFragment);
                            hideOthersFragment(mineFragment, true);
                        } else {
                            hideOthersFragment(mineFragment, false);
                        }
                        break;
                    default:
                        break;
                }
            }
        });
    }

    /**
     * 动态显示Fragment
     *
     * @param showFragment 要增加的fragment
     * @param add          true：增加fragment；false：切换fragment
     */
    private void hideOthersFragment(Fragment showFragment, boolean add) {
        transition = fragmentManager.beginTransaction();
        if (add)
            transition.add(R.id.main_container_content, showFragment);
        for (Fragment fragment : fragments) {
            if (showFragment.equals(fragment)) {
                transition.show(fragment);
            } else {
                transition.hide(fragment);
            }
        }
        transition.commit();
    }

}
