package com.claudis.proyecto2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);

        et1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        et2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }

    public void sumar(View v) {
        realizarOperacion(v, "sumar");
    }

    public void restar(View v) {
        realizarOperacion(v, "restar");
    }

    public void multiplicar(View v) {
        realizarOperacion(v, "multiplicar");
    }

    public void dividir(View v) {
        realizarOperacion(v, "dividir");
    }

    private void realizarOperacion(View v, String operacion) {
        String v1 = et1.getText().toString();
        String v2 = et2.getText().toString();
        if (!v1.isEmpty() && !v2.isEmpty()) {
            try {
                float valor1 = Float.parseFloat(v1);
                float valor2 = Float.parseFloat(v2);
                float resultado = 0;
                switch (operacion) {
                    case "sumar":
                        resultado = valor1 + valor2;
                        break;
                    case "restar":
                        resultado = valor1 - valor2;
                        break;
                    case "multiplicar":
                        resultado = valor1 * valor2;
                        break;
                    case "dividir":
                        if (valor2 != 0) {
                            resultado = valor1 / valor2;
                        } else {
                            tv1.setText("Resultado:\n El divisor no puede ser cero");
                            return;
                        }
                        break;
                }
                tv1.setText("Resultado:\n " + resultado);
            } catch (NumberFormatException e) {
                tv1.setText("Resultado:\n Ingrese números válidos");
            }
        } else {
            tv1.setText("Resultado:\n Ambos campos deben estar llenos");
        }
    }
}
