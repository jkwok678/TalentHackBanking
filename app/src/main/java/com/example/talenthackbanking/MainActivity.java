package com.example.talenthackbanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static final String API_KEY = "USE_YOUR_OWN_API_KEY";
    static final String API_URL = "https://auth.truelayer.com/?response_type=code" +
            "&client_id=jkwok789-2a07d4&scope=info%20accounts%20balance%20cards%20" +
            "transactions%20direct_debits%20standing_orders%20offline_access&redirect_uri" +
            "=https://console.truelayer.com/redirect-page&providers=uk-ob-all%20uk-oauth-all";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.goAssist);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AssistantActivity.class));
                // Code here executes on main thread after user presses button
            }
        });

        final Button button2 = findViewById(R.id.goVisualise);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View c) {
                startActivity(new Intent(MainActivity.this, BreakdownActivity.class));
                // Code here executes on main thread after user presses button
            }
        });

        final Button button3 = findViewById(R.id.goVisualise2);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View c) {
                startActivity(new Intent(MainActivity.this, Breakdown2Activity.class));
                // Code here executes on main thread after user presses button
            }
        });

    }
}