package com.example.android.justjava;


import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.android.justjava.R;

import static com.example.android.justjava.R.*;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 0;

    boolean withWhippedCream = false;




    public void submitOrders(View view) {
        withWhippedCream = ((CheckBox) findViewById(id.with_whipped_cream)).isChecked();
        String whippedCreamYesOrNo= withWhippedCream? "Whipped cream is added":"Whipped cream is not added";
        String priceMessage= quantity*5+"$ for "+quantity+" cups"+ "\n"+whippedCreamYesOrNo;
        displayPrice(priceMessage);
    }
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);

    }
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     * @param priceMessage
     */
    private void displayPrice(String priceMessage) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(priceMessage);
    }
}