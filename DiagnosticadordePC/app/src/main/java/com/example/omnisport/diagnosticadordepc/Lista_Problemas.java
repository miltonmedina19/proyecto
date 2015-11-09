package com.example.omnisport.diagnosticadordepc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

public class Lista_Problemas extends AppCompatActivity {
    String c1;
    String c2;
    String c3;
    String c4;
    String c5;
    public Spinner problema;
    ArrayAdapter<String>Diagnostico;
    String[] opciones = new String[]{"Determine su problema", "La PC disminuyó su rendimiento ", "Aparecen pantallas de error, los programas se tildan y se cierran", "La computadora se reinicia automáticamente o se apaga", "Ruidos extraños y vibraciones provenientes del gabinete", "La página de inicio o el buscador se cambió solo ", ""};
     private Button btncontinuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__problemas);
        problema=(Spinner) findViewById(R.id.spinner);
        btncontinuar = (Button) findViewById(R.id.button2);
        final ArrayAdapter<String>Diagnostico = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        problema.setAdapter(Diagnostico);
        problema.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                switch (i) {

                    case 1:
                        c1 = "Éste es el problema más habitual entre los usuarios. Pueden haber muchas razones que expliquen una baja en el rendimiento de la PC. La más común es la presencia de datos fragmentados, presencia de spyware, registro corrupto, y programas innecesarios";
                        break;
                    case 2:
                        c2 = "El posible que nuestra PC tenga spyware o programas espía, y que ésa sea la causa de que los programas no respondan y se deban finalizar.Tambien esta la de que el programa no funciona bien. Otra es que haya archivos de Windows necesarios para ejecutarlos y estan corruptos. Otra causa puede ser la falta de memoria RAM";
                        break;
                    case 3:
                        c3 = "Pueden ser dos. La presencia de un “gusano” (un tipo de virus), o alguna obstrucción ( basura, mala coneccion ) dentro del gabinete o el cooler. Esto último sucede cuando la PC no puede refrescarse: antes de recalentarse, sencillamente se apaga.";
                        break;
                    case 4:
                        c4 = " Algún componente del gabinete o hardware está fallando, ya sea el cooler, la fuente, cables mal conectados, o placas mal colocadas. Aquí las causas pueden ser múltiples.";
                        break;
                    case 5:
                        c5 = "Es probable que hayamos sido víctimas del “high-jacking”. Esto quiere decir que tenemos un spyware instalado en nuestra PC, que pudo haber provenido tanto de un archivo descargado y ejecutado tanto como de una red socia o lun mail. ";
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btncontinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String arreglo[] = new String[5];
                arreglo[0] = String.valueOf(c1);
                arreglo[1] = String.valueOf(c2);
                arreglo[2] = String.valueOf(c3);
                arreglo[3] = String.valueOf(c4);
                arreglo[4] = String.valueOf(c5);

                Intent I = new Intent(Lista_Problemas.this, Analisis.class);
                I.putExtra("problem", arreglo);
                startActivity(I);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista__problemas, menu);
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
