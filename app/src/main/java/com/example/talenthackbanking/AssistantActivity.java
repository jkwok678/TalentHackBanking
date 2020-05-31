package com.example.talenthackbanking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class AssistantActivity extends AppCompatActivity {
    static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assistant_screen);

        Map<String, Double> things = new HashMap<String, Double>();

        //Things to compare prices to subscription costs
        things.put("Tesco's meal deal", 3.00);
        things.put("Freddo bar", 0.25);
        things.put("Cheeseburger", 0.99);


        SubscriptionModel model1 = new SubscriptionModel("Netflix Premium"); // Object to represent Netflix
        model1.setPlanCost(9.99); // Set monthly Netflix price
        model1.setLast30Hours(80); // Set usage hours
        model1.setMoneySpentThisYear(49.55); // Set money spent this year
        String firstThing = "Tesco's meal deal";


        //ArrayList to hold all the text that the user will see
        final ArrayList<String> text = new ArrayList<String>();
        text.add("Here's some data I've compiled for you on your subscriptions!");
        for (Map.Entry<String, Double> thing : things.entrySet()) {
            double cal = model1.compareTo(thing.getValue());
            text.add("You could have bought " + cal + " " + thing.getKey() + (cal != 1 ? "s" : ""));
            text.add(" instead of " + (int) (model1.getMoneySpentThisYear() / model1.getPlanCost()) +
                    " months of " + model1.getPlanName() + "! \n");
        }


        SubscriptionModel model2 = new SubscriptionModel("Disney+");
        model2.setPlanCost(5.99);
        model2.setLast30Hours(13);
        model2.setMoneySpentThisYear(11.98);

        //Netflix cost per hour
        text.add("Netflix is costing you $" + String.format("%.2f", model1.costPerHour()) +
                " per hour");

        //Disney+ cost per hour
        text.add("Disney+ is costing you $" + String.format("%.2f", model2.costPerHour()) +
                " per hour");

        int difference = model1.compareHours(model2);
        // If the user uses model1 a lot more than 2 output text.
        if (difference > 10) {
            text.add("You have used " + model1.getPlanName() + " much more than "
                    + model2.getPlanName());
            text.add("Literally " + difference + " hours more!!!");
            text.add("Do you really need " + model2.getPlanName() + " when you have " +
                    model1.getPlanName() + "?");
        }
        // Button to advance to chatBot/AI
        final Button button = findViewById(R.id.continueButton);
        final TextView speechText = findViewById(R.id.speech);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                speechText.setText(text.get(counter % text.size()));
                counter++;


            }
        });


    }

}
