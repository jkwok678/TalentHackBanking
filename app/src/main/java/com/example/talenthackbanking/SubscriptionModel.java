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


    public double compareTo(double costOfThing) {


        int tempCal = (int) (moneySpentThisYear / costOfThing);

        return tempCal;

    }

    public void setMoneySpentThisYear(double moneySpentThisYear) {
        this.moneySpentThisYear = moneySpentThisYear;
    }

    public double getMoneySpentThisYear(){
        return moneySpentThisYear;
    }


    public double cost_per_hour() {
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

    public int compareHours(SubscriptionModel m2) {
        int difference = (int) last30Hours - (int) m2.getLast30Hours();
        return difference;
        }

}
