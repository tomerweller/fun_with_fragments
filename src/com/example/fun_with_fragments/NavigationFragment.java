package com.example.fun_with_fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NavigationFragment extends Fragment {

    public static interface Listener {
        public void navigateToIpsum(int i);
    }

    Button ipsumBtn1, ipsumBtn2, ipsumBtn3;
    NavigationFragment.Listener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            listener = (Listener)activity;
        }catch(ClassCastException e){
            throw new ClassCastException(
                    "Activity must implement NavigationFragment.Listener");
        }
    }

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
                listener.navigateToIpsum(1);
            } else if (v.equals(ipsumBtn2)){
                listener.navigateToIpsum(2);
            } else if (v.equals(ipsumBtn3)){
                listener.navigateToIpsum(3);
            }
        }
    };

}
