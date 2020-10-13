package com.example.evcilhayvanim;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class CatFragment extends Fragment {
    View view;
    TextView resource;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_cat,container,false);
        resource=view.findViewById(R.id.p191);
        resource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hillspet.com.tr/cat-care/routine-care"));
                startActivity(browser);
            }
        });
        return view;
    }
}