package com.example.evcilhayvanim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import java.util.Objects;

public class HomeFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home,container,false);
        ImageView btnDog = view.findViewById(R.id.btnDog);
        ImageView btnCat = view.findViewById(R.id.btnCat);
        ImageView btnBird = view.findViewById(R.id.btnBird);
        ImageView btnFish = view.findViewById(R.id.btnFish);
        ImageView btnHamster = view.findViewById(R.id.btnHamster);
        ImageView btnRabbit = view.findViewById(R.id.btnRabbit);
        btnDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new DogFragment()).commit();
                Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle("Köpek Bakımı");
            }
        });
        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new CatFragment()).commit();
                Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle("Kedi Bakımı");
                //catItem.setChecked(true);
            }
        });
        btnBird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new BirdFragment()).commit();
                Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle("Kuş Bakımı");
                //birdItem.setChecked(true);
            }
        });
        btnFish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new FishFragment()).commit();
                Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle("Akvaryum Canlıları");
                //fishItem.setChecked(true);
            }
        });
        btnHamster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HamsterFragment()).commit();
                Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle("Hamster Bakımı");
                //hamsterItem.setChecked(true);
            }
        });
        btnRabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new RabbitFragment()).commit();
                Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle("Tavşan Bakımı");
                //rabbitItem.setChecked(true);
            }
        });
        return view;
    }
}