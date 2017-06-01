package com.lesly.chahuara.ejemploregistro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lesly.chahuara.ejemploregistro.bean.User;
import com.lesly.chahuara.ejemploregistro.dao.UserDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegistraUsuario extends AppCompatActivity {

    EditText txtName;

    EditText txtLastName;

    EditText txtUser;

    EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtName = (EditText) findViewById(R.id.txtName);
        txtLastName = (EditText) findViewById(R.id.txtLastName);
        txtUser = (EditText) findViewById(R.id.txtUser);
        Button btnSave = (Button)findViewById(R.id.btnSave);

        // para obtener valores enviados de la otra actividad
        Bundle parameters = getIntent().getExtras();
        final int userId = (int) parameters.getInt("userId");

        if(userId!=0){
            User user = getUserById(userId);
            txtName.setText(user.getName());
            txtLastName.setText(user.getLastName());
            txtUser.setText(user.getUser());
            txtPass.setText(user.getPass());
        }


        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(userId==0){
                    Random rn = new Random();
                    int answer = rn.nextInt(1000) + 1;
                    //MainActivity.listPerson.add(new Person(answer,txtNombre.getText().toString(),txtLastNameF.getText().toString(),txtLastNameM.getText().toString(),"www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca","2"));
                }else{
                    updateUser(userId,txtName.getText().toString(),txtLastName.getText().toString(),txtUser.getText().toString(),txtPass.getText().toString());
                }
                goMain();
            }
        });
    }

    public void updateUser(int userId, String name, String lastName, String lastUser,String pass) {
        List<User> listUser2=new ArrayList<User>();
        for (User user:Main.listUser){
            if(user.getId()==userId){
                user.setName(name);
                user.setLastName(lastName);
                user.setUser(lastUser);
                user.setPass(pass);
            }
            listUser2.add(user);
        }
    }

    public void goMain(){
        Intent i = new Intent(this,Main.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //cambiar
        getMenuInflater().inflate(R.menu.menu_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_back:
                Intent i = new Intent(this,Main.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public User getUserById(int personId){
        List<User> listUser = Main.listUser;

        for (User user:listUser){
            if(user.getId()==userId){
                return user;
            }
        }
        return null;
    }

}


