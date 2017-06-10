package com.example.h94hu.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    TextView tvQuantity;
    TextView tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuantity = (TextView) findViewById(R.id.tvQuantity);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvQuantity.setText(0 + "");
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        toastMessage("Your order is submitted!");
    }

    private void display_price(int number){
        tvPrice.setText("$"+ number * 5);
    }

    public void increaseQuantity(View view) {
        int currentQuantity = Integer.parseInt(tvQuantity.getText().toString());
        int newQuantity = currentQuantity + 1;
        tvQuantity.setText( newQuantity + "");

        display_price(newQuantity);
    }

    /*
    * Toast a message
    * */
    public void toastMessage (String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }

    public void decreaseQuantity(View view) {
        int currentQuantity = Integer.parseInt(tvQuantity.getText().toString());
        int newQuantity;
        if(currentQuantity == 0){
            newQuantity = 0;
            toastMessage("Don't you like to order one?");
        }else{
            newQuantity = currentQuantity - 1;
        }
        tvQuantity.setText( newQuantity + "");

        display_price(newQuantity);
    }
}
