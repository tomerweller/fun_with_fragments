package com.example.fun_with_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.fun_with_fragments.events.IpsumSelectedEvent;
import com.example.fun_with_fragments.util.BusProvider;

public class NavigationFragment extends Fragment {

    Button ipsumBtn1, ipsumBtn2, ipsumBtn3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_fragment, container, false);
        ipsumBtn1 = (Button)view.findViewById(R.id.btn_lorem_1);
        ipsumBtn2 = (Button)view.findViewById(R.id.btn_lorem_2);
        ipsumBtn3 = (Button)view.findViewById(R.id.btn_lorem_3);
        ipsumBtn1.setOnClickListener(ipsumClickListener);
        ipsumBtn2.setOnClickListener(ipsumClickListener);
        ipsumBtn3.setOnClickListener(ipsumClickListener);
        return view;
    }

    View.OnClickListener ipsumClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if (v.equals(ipsumBtn1)){
                BusProvider.getBus().post(new IpsumSelectedEvent(1));
            } else if (v.equals(ipsumBtn2)){
                BusProvider.getBus().post(new IpsumSelectedEvent(2));
            } else if (v.equals(ipsumBtn3)){
                BusProvider.getBus().post(new IpsumSelectedEvent(3));
            }
        }
    };

}
