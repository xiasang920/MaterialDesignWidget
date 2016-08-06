package com.mdw.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.mdw.adapter.MyPagerAdapter;
import com.mdw.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.image_header)
    ImageView imageHeader;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing)
    CollapsingToolbarLayout collapsing;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.navView)
    NavigationView navView;
    @BindView(R.id.drawer)
    DrawerLayout drawer;
  /*  @BindView(R.id.rv)
    RecyclerView rv;*/

    private List<Fragment> fragmentList;
    private MyPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //设置标题相关
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsing.setTitle("MyApp");

        //设置抽屉导航
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.app_name,R.string.app_name);
        toggle.setDrawerIndicatorEnabled(true);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new PagerOneFragment());
        fragmentList.add(new PagerTwoFragment());
        fragmentList.add(new PagerThreeFragment());

        tabLayout.setupWithViewPager(pager);

        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),fragmentList);

        pager.setAdapter(pagerAdapter);



      /*  MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this,initData());
        rv.setAdapter(adapter);*/




    }

   /* private List<String> initData() {
        List<String> list = new ArrayList<String>();
        for (int i = 0;i<30;i++){
            list.add("item:"+i);
        }

        return list;
    }*/

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}
