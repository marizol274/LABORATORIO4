package com.example.mary.dados;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayAdapter<String> adapter; // DECLARACION DE (ADAPTER)
    private ArrayList<String> datos; // DECLARACION  DE (DATOS)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }

        });*/

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);//INICIALIZAMOS EL ARRAYA DAPTER
        datos = new ArrayList<String>();//INICIALIZAMOS EL datos
        datos.add("1");//PERMITE INTRODCIR UN ELEMENTO AL ARRAYLIST datos
        datos.add("2");
        adapter.addAll(datos);//permite conectar los datos al adaptador creado
        LoadComponets();
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
    public void LoadComponets(){
        GridView container =(GridView)this.findViewById(R.id.container);  // PERMITE RECUPERARAR EL ID DE GRIDVIEW
        container.setAdapter((adapter));//PERMITE LLENAR CON ELEMENTOS EL GRIDVIEW CON LOS DATOS QUE TIENE ADAPTER
        Button add= this.findViewById(R.id.add);
        add.setOnClickListener(this);
        Button remove= this.findViewById(R.id.remove);
        remove.setOnClickListener(this);
        Button roll= this.findViewById(R.id.ro);
        roll.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.add){
            datos.add("1");
        }else if (v.getId() == R.id.remove) {
            datos.remove(datos.size() - 1);
        }else if (v.getId() == R.id.ro) {
            int size = datos.size();
            datos.clear();
            int suma = 0;
            for(int i = 0; i< size; i++){
                int number = ThreadLocalRandom.current().nextInt(1,6); // PERMITE GENERAR NUMEROS ALEATORIOS ENTEROS ENTRE 1 Y6
                suma +=number;
                datos.add(number + " ");
            }
            TextView txt =(TextView)this.findViewById(R.id.results);
            txt.setText("El total es" +  suma  );
        }
        adapter.clear();
        adapter.addAll((datos));

    }


}
