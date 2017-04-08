package com.example.android.justjava;


import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.justjava.R;

import java.util.List;

import static android.R.id.message;
import static android.content.Intent.*;
import static android.content.Intent.ACTION_SENDTO;
import static com.example.android.justjava.R.*;
import static java.net.Proxy.Type.HTTP;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 0;
    String name;
    boolean withWhippedCream = false;
    String priceMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrders(View view) {
        EditText nameField = (EditText) findViewById(id.name_field);
        name = nameField.getText().toString();

        withWhippedCream = ((CheckBox) findViewById(id.with_whipped_cream)).isChecked();
        String whippedCreamYesOrNo= withWhippedCream? "Whipped cream is added":"Whipped cream is not added";
        priceMessage = "Name: " + name + "\n" + quantity * 5 + "$ for " + quantity + " cups" + "\n" + whippedCreamYesOrNo;
        displayPrice(priceMessage);
    }


    public void confirmMail(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:47.6,-122.3"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
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
        ;
    /**
     * This method displays the given price on the screen.
     * @param priceMessage
     */
    private void displayPrice(String priceMessage) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(priceMessage);
        }
        ;
}