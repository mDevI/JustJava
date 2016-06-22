package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int numberOfCoffees;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOfCoffees = 0;
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        numberOfCoffees += 1;
        displayQuantity(numberOfCoffees);
        displayPrice(numberOfCoffees * 5);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        if (numberOfCoffees != 0) {
            numberOfCoffees -= 1;
            displayQuantity(numberOfCoffees);
            displayPrice(numberOfCoffees * 5);
        }

    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        message = "\nThank you!";
        displayMessage(message, numberOfCoffees*5 );
        // display(numberOfCoffees);
        // displayPrice(numberOfCoffees*5);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText("Total: " + NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given message on the screen.
     */
    private void displayMessage(String message, int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText("Total: " + NumberFormat.getCurrencyInstance().format(number) + message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}