package dev.gustavodahora.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_calculator;
    private TextView txt_weight;
    private TextView txt_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_calculator = findViewById(R.id.btn_calculator);
        txt_weight = findViewById(R.id.edit_weight);
        txt_height = findViewById(R.id.edit_height);

    }

    @Override
    protected void onStart() {
        super.onStart();

        btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txt_weight.getText().toString().isEmpty() && !txt_height.getText().toString().isEmpty()) {
                    double weight = Double.parseDouble(txt_weight.getText().toString());
                    double height = Double.parseDouble(txt_height.getText().toString()) / 100;

                    TextView txt_imc_number = findViewById(R.id.txt_imc_number);
                    TextView txt_classification = findViewById(R.id.txt_classification);


                    double imc = weight / (height * height);
                    txt_imc_number.setText(String.format("%.2f", imc));

                    String classification;

                    if (imc < 18.5) {
                        classification = "Abaixo do peso";
                    } else if (imc > 18.5 && imc < 24.9) {
                        classification = "Peso normal";
                    } else if (imc > 25 && imc < 29.9) {
                        classification = "Sobrepeso";
                    } else if (imc > 30 && imc < 34.9) {
                        classification = "Obesidade grau I";
                    } else if (imc > 35 && imc < 39.9) {
                        classification = "Obesidade grau II";
                    } else {
                        classification = "Obesidade grau III ou Mórbida";
                    }

                    txt_classification.setText(classification);

                } else {
                    Toast.makeText(getApplicationContext(), "The text is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}