package com.example.fun_with_fragments.events;

public class IpsumSelectedEvent {
    private int index;
    public IpsumSelectedEvent(int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }
}
