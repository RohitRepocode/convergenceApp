package com.example.convergenceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.convergenceapp.Auth.LoginFragment;
import com.example.convergenceapp.utils.PreferenceFactory;
import com.example.convergenceapp.utils.PreferenceKeyManager;

public class LoginActivity extends AppCompatActivity {

    NavController navController;
    Toolbar tollBar;




    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);


        NavHostFragment navHostFragment=(NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentlogin);
        navController=navHostFragment.getNavController();
        NavInflater navInflater=navController.getNavInflater();
        NavGraph navGraph=navInflater.inflate(R.navigation.login_nav_graph);


        if(!PreferenceFactory.getInstance().getSharedPrefrencesData(PreferenceKeyManager.getPrefKeyMpin(),LoginActivity.this).equalsIgnoreCase(""))   // which fragment has to be reflect will decide on this variable(set Mpin fragmnet, Verify Mpin fragmet)
        { navGraph.setStartDestination(R.id.homeFragment);
        }else{
            navGraph.setStartDestination(R.id.loginFragment);
        }
        navController.setGraph(navGraph);

    }
/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean status = false;


        switch (item.getItemId()) {
            case R.id.logOut:
                //navController.navigate(R.id.loginFragment);
                Toast.makeText(this, "working", Toast.LENGTH_SHORT).show();
                break;

            case R.id.changeLanguage:
                navController.navigate(R.id.changeLanguage);
        }
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }*/

}