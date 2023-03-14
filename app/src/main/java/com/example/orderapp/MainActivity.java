package com.example.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.example.orderapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    String name;
    private boolean whippedCream = false;
    private boolean chocolatte = false;
    private int chocolattePrice = 1;
    private int whippedCreamPrice = 2;
    private int quantity;
    private int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.whippedCreamCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (binding.whippedCreamCheckBox.isChecked()){
                    whippedCream = true;
                }
            }
        });

        binding.chocolatte.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (binding.chocolatte.isChecked()){
                    chocolatte = true;
                }
            }
        });

        binding.increaseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int qty = Integer.parseInt(binding.quantityTextView.getText().toString());
                qty++;
                String qtyString = String.valueOf(qty);
                binding.quantityTextView.setText(qtyString);
            }
        });

        binding.decreaseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int qty = Integer.parseInt(binding.quantityTextView.getText().toString());
                if (qty != 0) {
                    qty--;
                }
                String qtyString = String.valueOf(qty);
                binding.quantityTextView.setText(qtyString);
            }
        });


        binding.orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.summaryTextView.setVisibility(View.VISIBLE);
                name = binding.editText.getText().toString();
                if (whippedCream == true){
                    total = whippedCreamPrice* (Integer.parseInt(binding.quantityTextView.getText().toString()));
                } else if (chocolatte == true) {
                    total = chocolattePrice * (Integer.parseInt(binding.quantityTextView.getText().toString()));
                } else if (whippedCream == true && chocolatte == true) {
                    total = (chocolattePrice * (Integer.parseInt(binding.quantityTextView.getText().toString()))) + (whippedCreamPrice* (Integer.parseInt(binding.quantityTextView.getText().toString())));
                }
                else
                    total = 0;

                if (total== 0){
                    binding.summaryTextView.setText("");
                }
                quantity = Integer.parseInt(binding.quantityTextView.getText().toString());
                binding.summaryTextView.setText("Name: " + name+"\n" + "Add Whipped cream?: " + whippedCream+"\n" + "Add Chocolatte?: " +chocolatte+"\n" + "Quantity: " + quantity+"\n" + "Total: "+ "$" +total+"\n" );
            }
        });
    }
}