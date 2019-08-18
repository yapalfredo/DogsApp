package com.example.dogsapp.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dogsapp.R;
import com.example.dogsapp.model.DogBreed;
import com.example.dogsapp.util.Util;
import com.example.dogsapp.viewmodel.DetailViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;


public class DetailFragment extends Fragment {

    private int dogUuid;
    private DetailViewModel viewModel;

    @BindView(R.id.dogImage)
    ImageView dogImage;

    @BindView(R.id.dogName)
    TextView dogName;

    @BindView(R.id.dogPurpose)
    TextView dogPurpose;

    @BindView(R.id.dogTemperament)
    TextView dogTemperament;

    @BindView(R.id.dogLifespan)
    TextView dogLifespan;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            dogUuid = DetailFragmentArgs.fromBundle(getArguments()).getDogUuid();
        }

        viewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        viewModel.fetch(dogUuid);

        observeViewModel();
    }

    private void observeViewModel() {
        //New Observer (in Lambda)
        viewModel.dogLiveData.observe(this, dogBreed -> {
            if (dogBreed != null && dogBreed instanceof DogBreed) {
                dogName.setText(dogBreed.dogBreed);
                dogPurpose.setText(dogBreed.bredFor);
                dogTemperament.setText(dogBreed.temperament);
                dogLifespan.setText(dogBreed.lifeSpan);

                if (dogBreed.imageUrl != null) {
                    Util.loadImage(dogImage, dogBreed.imageUrl, new CircularProgressDrawable(getContext()));
                }
            }
        });
    }

}
