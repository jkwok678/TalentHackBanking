package com.example.talenthackbanking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class assistantActivity extends AppCompatActivity {
    static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assistant_screen);

        Map<String, Double> things = new HashMap<String, Double>();

        things.put("Tesco's meal deal", 3.00);
        things.put("Freddo bar", 0.25);
        things.put("Cheeseburger", 0.99);


        SubscriptionModel model1 = new SubscriptionModel("Netflix Premium");
        model1.setPlanCost(9.99);
        model1.setLast30Hours(80);
        model1.setMoneySpentThisYear(49.55);
        String firstThing = "Tesco's meal deal";
        double firstPrice = things.get("Tesco's meal deal");
        double cal = model1.compareTo(firstPrice);
        final String text0 = ("Here's some data I've compiled for you on your subscriptions!");
        final String text1 = ("You could have bought " + cal + " " + firstThing + (cal != 1 ? "s" : ""));
        final String text2 = (" instead of " + (int) (model1.getMoneySpentThisYear() / model1.getPlanCost()) +
                " months of " + model1.getPlanName() + "! \n");

        double secondPrice = things.get("Cheeseburger");
        cal = model1.compareTo(secondPrice);

        final String text3 = ("You could have bought " + cal + " " + firstThing + (cal != 1 ? "s" : ""));
        final String text4 = (" instead of " + (int) (model1.getMoneySpentThisYear() / model1.getPlanCost()) +
                " months of " + model1.getPlanName() + "! \n");

        SubscriptionModel model2 = new SubscriptionModel("Disney+");
        model2.setPlanCost(5.99);
        model2.setLast30Hours(13);
        model2.setMoneySpentThisYear(11.98);

        final String text5 = ("Netflix is costing you $" + String.format("%.2f", model1.cost_per_min()) +
                " per hour");
        final String text6 = ("Disney+ is costing you $" + String.format("%.2f", model2.cost_per_min()) +
                " per hour");
        final String text7;
        final String text8;
        final String text9;
        int difference = model1.compareHours(model2);
        if (difference > 10) {
            text7 = ("You have used " + model1.getPlanName() + " much more than "
                    + model2.getPlanName());
            text8 = ("Literally " + difference + " hours more!!!");
            text9 = ("Do you really need " + model2.getPlanName() + " when you have " +
                    model1.getPlanName() + "?");

            final Button button = findViewById(R.id.continueButton);
            final TextView speechText = findViewById(R.id.speech);

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    switch (counter) {
                        case 0:
                            speechText.setText(text0);
                            counter++;
                            break;
                        case 1:
                            speechText.setText(text1);
                            counter++;
                            break;
                        case 2:
                            speechText.setText(text2);
                            counter++;
                            break;
                        case 3:
                            speechText.setText(text3);
                            counter++;
                            break;
                        case 4:
                            speechText.setText(text4);
                            counter++;
                            break;
                        case 5:
                            speechText.setText(text5);
                            counter++;
                            break;
                        case 6:
                            speechText.setText(text6);
                            counter++;
                            break;
                        case 7:
                            speechText.setText(text7);
                            counter++;
                            break;
                        case 8:
                            speechText.setText(text8);
                            counter++;
                            break;
                        case 9:
                            speechText.setText(text9);
                            counter++;
                            break;
                    }

                }
            });
        }


    }

}
