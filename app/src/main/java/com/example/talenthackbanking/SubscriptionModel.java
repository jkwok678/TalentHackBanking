package com.example.talenthackbanking;


import java.util.Map;

public class SubscriptionModel {

    private String planName;
    private double planCost;
    private double moneySpentThisYear;

    private double last30Hours;

    public SubscriptionModel(String planName) {
        this.planName = planName;
    }


    public void makeComparisions(Map<String, Double> things) {


        for (Map.Entry<String, Double> thing : things.entrySet()) {
            compareTo(thing.getKey(), thing.getValue());
        }

    }

    private double compareTo(String thing, double costOfThing) {
        int tempCal = (int) (moneySpentThisYear / costOfThing);
        System.out.print("You could have bought " + tempCal + " " + thing + (tempCal != 1 ? "s" : ""));
        System.out.println(" instead of " + (int) (moneySpentThisYear / planCost) +
                " months of " + planName + "! \n");
        return tempCal;
    }


    public void setMoneySpentThisYear(double moneySpentThisYear) {
        this.moneySpentThisYear = moneySpentThisYear;
    }

    public double getMoneySpentThisYear(double moneySpentThisYear) {
        return moneySpentThisYear;
    }


    public double cost_per_min() {
        return (this.planCost / this.last30Hours);
    }

    public String getPlanName() {
        return planName;

    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }


    public double getLast30Hours() {
        return last30Hours;

    }

    public void setLast30Hours(double last30Hours) {
        this.last30Hours = last30Hours;
    }

    public double getPlanCost() {
        return planCost;

    }

    public void setPlanCost(double planCost) {
        this.planCost = planCost;
    }

    public void compareHours(SubscriptionModel m2) {
        int difference = (int) last30Hours - (int) m2.getLast30Hours();
        if (difference > 10) {
            System.out.println("You have used " + planName + " much more than "
                    + m2.getPlanName());
            System.out.println("Literally " + difference + " hours more!!!");
            System.out.println("Do you really need " + m2.getPlanName());
        }
    }
}
