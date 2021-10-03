package com.alpha.peoplesbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alpha.peoplesbank.Util.SliderAdapterExample;
import com.alpha.peoplesbank.fragment.HomeFragment;
import com.alpha.peoplesbank.fragment.SecondFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    public static View navHeaderView;
    NavigationView navigationView;

    public ImageView ivProfile1;
    public TextView tvTitle, tvUserName;
    public BottomNavigationView bottomNavigationView;
    public int selectedBottomNav;
    private Fragment fragment = null;

    public SliderView sliderView;
    public SliderAdapterExample sliderAdapter;
    public String[] addImagesArray = {};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    public void initialize(){

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.post(new Runnable() {
            @Override
            public void run() {
                Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_ham, null);// set custom image instead drawer hamburger icon

                toolbar.setNavigationIcon(d);
            }
        });
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);



        navigationView.setNavigationItemSelectedListener(this);

        navHeaderView = navigationView.getHeaderView(0);

        bottomMenu();

        NavController navController = Navigation.findNavController(this,R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        ivProfile1 = navHeaderView.findViewById(R.id.civ_profileImage);
        tvTitle = navHeaderView.findViewById(R.id.tv_navHeaderTitle);
        tvUserName  = navHeaderView.findViewById(R.id.tv_navHeaderUsername);
        sliderView = findViewById(R.id.imageSlider);

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            // set the event
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void bottomMenu(){

        bottomNavigationView.setOnItemSelectedListener(item -> {
            selectedBottomNav = item.getItemId();

            switch (item.getItemId()){
                case R.id.nav_home:
                    fragment = new HomeFragment();
                    break;

                case R.id.nav_calculator:
                    fragment = new SecondFragment();
                    break;


            }

            if(fragment != null){
                getSupportFragmentManager().beginTransaction().replace(R.id.navHostFragment, fragment).commit();
            }

            return true;
        });
    }

    public void setImagesToImageSlider() {

        sliderAdapter = new SliderAdapterExample(MainActivity.this, addImagesArray);
        sliderView.setSliderAdapter(sliderAdapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(getResources().getColor(R.color.accent_white));
        sliderView.setIndicatorUnselectedColor(getResources().getColor(R.color.white));
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }
}