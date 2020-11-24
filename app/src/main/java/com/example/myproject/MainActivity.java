package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myproject.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import FunctionFragment.CategoryFragment.CategoryFragment;
import FunctionFragment.HomeFragment.HomeFragment;
import FunctionFragment.NewsFeedFragment.NewsFeedFragment;
import FunctionFragment.NotificationFragment.NotificationFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    private int Request_Permission_Code = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.INTERNET}, Request_Permission_Code);

        getFragment(HomeFragment.newInstance());
        mainBinding.mainFunctionBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.function_home: {
                        getFragment(HomeFragment.newInstance());
                        break;
                    }
                    case R.id.function_category: {
                        getFragment(CategoryFragment.newInstance());
                        break;
                    }
                    case R.id.function_News: {
                        getFragment(NewsFeedFragment.newInstance());
                        break;
                    }
                    case R.id.function_Notification: {
                        getFragment(NotificationFragment.newInstance());
                        break;
                    }
                    case R.id.function_User: {
                        Toast.makeText(getBaseContext(),getString(R.string.function_user),Toast.LENGTH_SHORT).show();
                        break;
                    }
                    default:break;
                }
                return true;
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == Request_Permission_Code) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void getFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).commit();
    }
}