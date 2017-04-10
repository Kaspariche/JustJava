package com.example.android.justjava;


import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.android.justjava.R.*;

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
        String whippedCreamYesOrNo = withWhippedCream ? getString(R.string.whipped_cream_is_added) : getString(string.whipped_cream_is_not_added);


        priceMessage = getString(string.order_summary_name, name) +
                "\n" + getString(string.order_summary_quantity_unit, NumberFormat.getCurrencyInstance().format(quantity * 5), quantity)
                + "\n" + whippedCreamYesOrNo;
        displayPrice(priceMessage);
    }
    public void confirmMail(View view) {
        submitOrders(view);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"keynovaholding@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail_subject) + name);
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