package com.example.fun_with_fragments.util;

import com.squareup.otto.Bus;

public class BusProvider {
    private BusProvider(){};

    private static Bus bus=null;
    public static Bus getBus(){
        if (bus==null){
            bus = new Bus();
        }
        return bus;
    }
}