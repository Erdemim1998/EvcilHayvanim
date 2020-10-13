package com.example.evcilhayvanim;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class HamsterFragment extends Fragment {
    View view;
    TextView resource;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_hamster,container,false);
        resource=view.findViewById(R.id.p48);
        resource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser=new Intent(Intent.ACTION_VIEW, Uri.parse("https://seyler.eksisozluk.com/hamster-beslemek-isteyenler-icin-detayli-bir-tavsiye-listesi"));
                startActivity(browser);
            }
        });
        return view;
    }
}