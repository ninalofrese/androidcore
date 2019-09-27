package com.example.comfragmentscars.views;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.comfragmentscars.R;
import com.example.comfragmentscars.model.Car;

import static com.example.comfragmentscars.views.CarsActivity.CAR_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarsFragment extends Fragment {
    private ImageView image;
    private TextView brand;
    private TextView description;

    public CarsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cars, container, false);

        initViews(view);

        if (!getArguments().isEmpty()) {
            Car carro = getArguments().getParcelable(CAR_KEY);

            if (carro != null) {
                Drawable drawable = getResources().getDrawable(carro.getImage());

                image.setImageDrawable(drawable);
                brand.setText(carro.getModel());
                description.setText(carro.getDescription());
            }
        }

        return view;
    }

    public void initViews(View view) {
        image = view.findViewById(R.id.imageView_cars);
        brand = view.findViewById(R.id.textView_cars_name);
        description = view.findViewById(R.id.textView_cars_description);
    }

}
