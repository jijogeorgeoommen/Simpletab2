package com.example.simpletab;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;      //Toolbar selected for intilasation must be with v7
    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.tool_bar);
        toolbar.setTitle("Chat-mate");       // to display app name on toolbar
        setSupportActionBar(toolbar); //to convert actionbar to toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //enable back button on toolbar
        viewpager=findViewById(R.id.view_pagerxml);

        setupViewpager(viewpager);  //create method
        tablayout=findViewById(R.id.tab_layoutxml);
        tablayout.setupWithViewPager(viewpager); //connect viewpager with tablayout
    }

    private void setupViewpager(ViewPager viewpager) {

        viewpageradapter adapter=new viewpageradapter(getSupportFragmentManager()); //setting adapter for enabling data transferring in fragment
        viewpager.setAdapter(adapter);

    }
    class viewpageradapter extends FragmentPagerAdapter {

        //impliment methods and after that "create constructer matching super"

        public viewpageradapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {

                case 0:
                    chats chatobj=new chats();
                    return chatobj;
                case 1:
                    status statusobj=new status();
                    return statusobj;
                case 2:
                     calls callsobj=new calls();
                     return callsobj;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){

                case 0:
                    return "Chats";
                case 1:
                    return "Status";
                case 2:
                    return "calls";
                 default:
                     return null;
            }
        }
    }
    }

