package com.lesly.chahuara.ejemploregistro;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lesly.chahuara.ejemploregistro.bean.User;

import java.util.List;

/**
 * Created by Asus on 31/05/2017.
 */

public class UserListAdapter extends ArrayAdapter<User> {
    private Context contextGeneral;

    private class ViewHolder{
        TextView name;
        TextView lastName;
        TextView user;
        TextView pass;
    }

    public UserListAdapter(Context context, List<User> rowItem){
        super(context,R.layout.list_user, rowItem);
    }

    public View getView(int position, View contentView, ViewGroup parent){
        User user = getItem(position);

        ViewHolder viewHolder;
        if(contentView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.list_user,null);
            viewHolder.name = (TextView)contentView.findViewById(R.id.name);
            viewHolder.lastName = (TextView)contentView.findViewById(R.id.lastName);
            viewHolder.user = (TextView)contentView.findViewById(R.id.user);
            viewHolder.pass = (TextView)contentView.findViewById(R.id.pass);
            contentView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)contentView.getTag();
        }
        viewHolder.name.setText(user.getName());
        viewHolder.lastName.setText(user.getLastName());
        viewHolder.user.setText(user.getUser());
        viewHolder.pass.setText(user.getPass());
        return  contentView;
    }



    public UserListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public UserListAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public UserListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull User[] objects) {
        super(context, resource, objects);
    }

    public UserListAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull User[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public UserListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
    }

    public UserListAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<User> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
