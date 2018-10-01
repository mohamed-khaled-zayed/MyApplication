package com.binarycase.mohamed.myapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.binarycase.mohamed.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setHandlers(new MyHandlers());

        User user=new User("mohamed","123456");
        binding.setUser(user);
        binding.setClick(new Presenter());

    }

    public class MyHandlers {
        public void onClickFriend(View view) {
            Log.e("kk","fff");
            binding.text.setText("Mohamed Khaled");
        }
    }

    public class Presenter {
        public void onSaveClick(User user){
            Log.e("name",user.name);
            Log.e("pass",user.pass);
        }
    }

    public class User{

        String name;
        String pass;

        public User(String name, String pass) {
            this.name = name;
            this.pass = pass;
        }
    }
}
