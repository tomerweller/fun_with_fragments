package com.example.fun_with_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.fun_with_fragments.events.IpsumDoneEvent;
import com.example.fun_with_fragments.util.BusProvider;

public class Ipsum1Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ipsum_1_fragment, container, false);
        Button doneButton = (Button)view.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusProvider.getBus().post(new IpsumDoneEvent());
            }
        });
        return view;
    }

}
