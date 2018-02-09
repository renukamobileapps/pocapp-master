package com.poc.app;

import com.poc.app.model.Deal;


public class AppSingleton {
    private static final AppSingleton ourInstance = new AppSingleton();

    private Deal selectedDeal;

    public static AppSingleton getInstance() {
        return ourInstance;
    }

    private AppSingleton() {
    }

    public Deal getSelectedDeal() {
        return selectedDeal;
    }

    public void setSelectedDeal(Deal selectedDeal) {
        this.selectedDeal = selectedDeal;
    }
}
