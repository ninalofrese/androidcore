package com.example.comfragmentscars.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.comfragmentscars.R;
import com.example.comfragmentscars.interfaces.Comunicator;
import com.example.comfragmentscars.model.Car;

public class CarsActivity extends AppCompatActivity implements Comunicator {
    public static final String CAR_KEY = "car";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        replaceFragment(R.id.container2, new ButtonsFragment());
    }

    @Override
    public void getMessage(Car car) {
        setBundleToFragment(car, CAR_KEY);
    }

    public void replaceFragment(int container, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    public void setBundleToFragment(Car car, String CHAVE) {
        Bundle bundle = new Bundle();

        bundle.putParcelable(CHAVE, car);

        Fragment carsFragment = new CarsFragment();

        carsFragment.setArguments(bundle);

        replaceFragment(R.id.container1, carsFragment);
    }
}
