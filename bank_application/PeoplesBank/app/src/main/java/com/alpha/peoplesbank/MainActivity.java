package com.alpha.peoplesbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alpha.peoplesbank.Util.SliderAdapterExample;
import com.alpha.peoplesbank.fragment.FundTransferFragment;
import com.alpha.peoplesbank.fragment.HomeFragment;
import com.alpha.peoplesbank.fragment.SecondFragment;
import com.alpha.peoplesbank.fragment.TransactionFragment;
import com.alpha.peoplesbank.fragment.payment.PaymentService;
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
    private Button payment;
    public BottomNavigationView bottomNavigationView;
    public int selectedBottomNav;
    private Fragment fragment = null;



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


        ivProfile1 = navHeaderView.findViewById(R.id.civ_profileImage);
        tvTitle = navHeaderView.findViewById(R.id.tv_navHeaderTitle);
        tvUserName  = navHeaderView.findViewById(R.id.tv_navHeaderUsername);
        bottomMenu();

        loadFragment(new HomeFragment());
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

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        loadFragment(new HomeFragment());
                        break;
                    case R.id.nav_calculator:
                        loadFragment(new SecondFragment());
                        break;
                    case R.id.nav_transactionIcon:
                        loadFragment(new TransactionFragment());
                        break;

                    case R.id.nav_payment:
                        loadFragment(new PaymentService());
                        break;
                }
                return true;
            }
        });


        bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }



    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}