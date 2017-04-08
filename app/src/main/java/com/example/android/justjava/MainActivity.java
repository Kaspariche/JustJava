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

    public static final String COFFEE_ORDER_FOR = "Coffee order for ";
    public static final String KEYNOVAHOLDING_GMAIL_COM = "keynovaholding@gmail.com";
    public static final String MAILTO = "mailto:";
    public static final String CUPS = " cups";
    public static final String $_FOR = "$ for ";
    public static final String NAME = "Name: ";
    public static final String WHIPPED_CREAM_IS_NOT_ADDED = "Whipped cream is not added";
    public static final String WHIPPED_CREAM_IS_ADDED = "Whipped cream is added";
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
        String whippedCreamYesOrNo = withWhippedCream ? WHIPPED_CREAM_IS_ADDED : WHIPPED_CREAM_IS_NOT_ADDED;
        priceMessage = NAME + name + "\n" + quantity * 5 + $_FOR + quantity + CUPS + "\n" + whippedCreamYesOrNo;
        displayPrice(priceMessage);
    }


    public void confirmMail(View view) {
        submitOrders(view);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(MAILTO)); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{KEYNOVAHOLDING_GMAIL_COM});
        intent.putExtra(Intent.EXTRA_SUBJECT, COFFEE_ORDER_FOR + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
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