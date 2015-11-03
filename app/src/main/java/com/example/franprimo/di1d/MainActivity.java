package com.example.franprimo.di1d;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaracion de objetos de distintos tipos.
        final ToggleButton button = (ToggleButton) findViewById(R.id.toggleButton);
        final ToggleButton button2 = (ToggleButton) findViewById(R.id.toggleButton2);
        final CheckBox cb = (CheckBox) findViewById(R.id.checkBox);
        final TextView tv = (TextView) findViewById(R.id.textView2); //Contador del ranking
        final TextView tvcb = (TextView) findViewById(R.id.textView3); //TextView del checkBox
        final LinearLayout mensajeLayout = (LinearLayout) findViewById(R.id.mensajeLayout);
        final RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);
        final TextView pulsacionLargaText = (TextView) findViewById(R.id.textView4);

        //Listener del toggleButton que cambia el color de fondo del mensajeLayout
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.isChecked()) {
                    String mensaje = "FONDO BLANCO";
                    button.setText(mensaje);
                    mensajeLayout.setBackgroundColor(Color.RED);
                } else {
                    String mensaje = "FONDO ROJO";
                    button.setText(mensaje);
                    mensajeLayout.setBackgroundColor(Color.WHITE);
                }

            }
        });


        //Listener del checkBox que muestra un mensaje u otro dependendiendo de si esta
        //seleccionado o no.
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb.isChecked()) {
                    cb.setText("Ahora si, buena elección!");
                } else {
                    cb.setText("Mostar");
                }

            }
        });

        //Listener del ratingBar con el que podemos dar una puntuación.
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tv.setText("Puntuacion: " + rating);
                Toast.makeText(getBaseContext(), "Gracias", Toast.LENGTH_SHORT).show();
            }
        });

        //Intento poner un listener al textView para que me muestre un mensaje cuando la pulsacion
        //sea larga, pero no me funciona.
        pulsacionLargaText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(), "Gracias por la pulsación larga", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
