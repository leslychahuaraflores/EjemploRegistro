package com.lesly.chahuara.ejemploregistro;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Contacts extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){

        View view = inflater.inflate(R.layout.content_contacts,container,false);

//        String [] nombres={"Omar Calsin Curo","David Mamani Pari","Juan Perez Perez","Maria Diaz Origuela"};
//
//        ListView listView = (ListView)view.findViewById(R.id.listView);
//
//        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(getActivity().getApplicationContext(),MainActivity.simple,nombres);
//
//        listView.setAdapter(arrayAdapter);



        return view;

    }
}
