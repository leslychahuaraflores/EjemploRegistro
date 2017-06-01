package com.lesly.chahuara.ejemploregistro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lesly.chahuara.ejemploregistro.bean.User;
import com.lesly.chahuara.ejemploregistro.dao.UserDao;

/**
 * Created by Asus on 26/05/2017.
 */

public class Usuario extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){

        View view = inflater.inflate(R.layout.user,viewGroup,true);

        ListView list = (ListView) view.findViewById(R.id.listUser);



        User user = new User (1,"Omar", "Calsin","ocalsin","123456");



        UserDao.listUser.add(user);



        ArrayAdapter<User> arrayAdapter = new ArrayAdapter<User>(getActivity().getApplicationContext() ,android.R.layout.simple_list_item_1, UserDao.listUser);

        list.setAdapter(arrayAdapter);

        return view;

    }
}
