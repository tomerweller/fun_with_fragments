package com.example.fun_with_fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.example.fun_with_fragments.events.IpsumDoneEvent;
import com.example.fun_with_fragments.events.IpsumSelectedEvent;
import com.example.fun_with_fragments.util.BusProvider;
import com.squareup.otto.Subscribe;

public class MainActivity extends Activity{

    public static final String IPSUM_FRAGMENT_TAG = "ipsum_fragment";

    private FragmentManager fragmentManager;
    private boolean isDualPane;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        fragmentManager = getFragmentManager();

        //check if this is a two pane (wide) setup
        isDualPane = findViewById(R.id.navigation_fragment) != null;

        //if not, place the navigation fragment in the container
        if (!isDualPane){
            NavigationFragment navigationFragment = new NavigationFragment();
            FragmentTransaction tx = fragmentManager.beginTransaction();
            tx.replace(R.id.fragment_container, navigationFragment);
            tx.commit();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getBus().register(this);
    }

    @Override
    protected void onPause() {
        BusProvider.getBus().unregister(this);
        super.onPause();
    }

    @Subscribe
    public void navigateToIpsum(IpsumSelectedEvent e) {
        Fragment newFragment;
        newFragment = (e.getIndex()==1) ?
                new Ipsum1Fragment() : (e.getIndex()==2) ?
                new Ipsum2Fragment() :
                new Ipsum3Fragment();

        FragmentTransaction tx = fragmentManager.beginTransaction();
        tx.replace(R.id.fragment_container, newFragment, IPSUM_FRAGMENT_TAG);
        tx.addToBackStack(null);
        tx.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        tx.commit();
    }

    @Subscribe
    public void onIpsumDone(IpsumDoneEvent e) {
        FragmentTransaction tx = fragmentManager.beginTransaction();
        if(isDualPane){
            tx.remove(fragmentManager.findFragmentByTag(IPSUM_FRAGMENT_TAG));
        }else {
            Fragment navigationFragment = new NavigationFragment();
            tx.replace(R.id.fragment_container, navigationFragment);
        }
        tx.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        tx.commit();
        fragmentManager.popBackStack();
    }


}