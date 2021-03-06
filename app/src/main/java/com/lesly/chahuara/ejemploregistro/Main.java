package com.lesly.chahuara.ejemploregistro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lesly.chahuara.ejemploregistro.dao.UserDao;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnRegistrar = (Button) findViewById(R.id.btnregistrar);



        btnRegistrar.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick (View view){

                Intent newform = new Intent(Main.this,Tab.class);

                startActivity(newform);

            }});


    }
    public void login(View view){
        EditText user = (EditText) findViewById(R.id.user);

        EditText passsword = (EditText) findViewById(R.id.passsword);

        UserDao userDao = new UserDao();


// modificar
        if(userDao.validateUser(user.getText().toString(),passsword.getText().toString())){

            Intent intent = new Intent(this,Tab.class);

            startActivity(intent);

        }else{

            user.setText("");

            passsword.setText("");

            Toast.makeText(getApplicationContext(),"Usuario o clave incorrecto", Toast.LENGTH_SHORT).show();

        }

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
