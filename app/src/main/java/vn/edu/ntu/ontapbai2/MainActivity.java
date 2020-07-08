package vn.edu.ntu.ontapbai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.edu.ntu.ontapbai2.controller.Controller;
import vn.edu.ntu.ontapbai2.controller.Icartcontroller;

public class MainActivity extends AppCompatActivity {

    Icartcontroller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new Controller();
        controller = (Icartcontroller) getApplication();
    }
}