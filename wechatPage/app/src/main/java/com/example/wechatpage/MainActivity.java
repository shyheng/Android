package com.example.wechatpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager2 viewPager2;

    private LinearLayout lChat,lContacts,lFind,lProfile;
    private ImageView iChat,iContacts,iFind,iProfile,ivCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPage();
        initTabView();
    }

    private void initTabView() {
        lChat = findViewById(R.id.id_tab_1);
        lChat.setOnClickListener(this::onClick);
        lContacts = findViewById(R.id.id_tab_2);
        lContacts.setOnClickListener(this::onClick);
        lFind = findViewById(R.id.id_tab_3);
        lFind.setOnClickListener(this::onClick);
        lProfile = findViewById(R.id.id_tab_4);
        lProfile.setOnClickListener(this::onClick);
        iChat = findViewById(R.id.tab_iv_1);
        iContacts = findViewById(R.id.tab_iv_2);
        iFind = findViewById(R.id.tab_iv_3);
        iProfile = findViewById(R.id.tab_iv_4);

        iChat.setSelected(true);

        ivCurrent = iChat;
    }

    private void initPage(){
        viewPager2 = findViewById(R.id.id_vp);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance("微信聊天"));
        fragments.add(BlankFragment.newInstance("通讯录"));
        fragments.add(BlankFragment.newInstance("发现"));
        fragments.add(BlankFragment.newInstance("我"));
        MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager2.setAdapter(fragmentPagerAdapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changTab(int position) {
        ivCurrent.setSelected(false);
        switch (position){
            case R.id.id_tab_1:
                viewPager2.setCurrentItem(0);
            case 0:
                iChat.setSelected(true);
                ivCurrent = iChat;
                break;
            case R.id.id_tab_2:
                viewPager2.setCurrentItem(1);
            case 1:
                iContacts.setSelected(true);
                ivCurrent = iContacts;
                break;
            case R.id.id_tab_3:
                viewPager2.setCurrentItem(2);
            case 2:
                iFind.setSelected(true);
                ivCurrent = iFind;
                break;
            case R.id.id_tab_4:
                viewPager2.setCurrentItem(3);
            case 3:
                iProfile.setSelected(true);
                ivCurrent = iProfile;
                break;
        }
    }

    @Override
    public void onClick(View v) {
        changTab(v.getId());
    }
}