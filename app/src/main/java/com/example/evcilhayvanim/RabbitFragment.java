package com.example.evcilhayvanim;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RabbitFragment extends Fragment {
    View view;
    TextView resource;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_rabbit,container,false);
        resource=view.findViewById(R.id.p21);
        resource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bilgiustam.com/evde-tavsan-bakimi-icin-temel-bilgiler"));
                startActivity(browser);
            }
        });
        return view;
    }
}