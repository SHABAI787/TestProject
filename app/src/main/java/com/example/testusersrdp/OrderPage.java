package com.example.testusersrdp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Order;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list = findViewById(R.id.orders_list);

        List<String> coursesTitle = new ArrayList<>();

        for (Course c : MainActivity.fullCourseList){
            if(Order.items_id.contains(c.getId()))
                coursesTitle.add(c.getTitle());
        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle));

    }

    public void Buy(View view){
        Toast.makeText(this, "Запуск онлайн оплаты", Toast.LENGTH_SHORT).show();
    }

    public void Info(View view){
        Toast.makeText(this, "Информация о компании", Toast.LENGTH_SHORT).show();
    }

    public  void Contacts(View view){
        Toast.makeText(this, "Вывод контактов компании", Toast.LENGTH_SHORT).show();
    }

    public void Exit(View view){
        finish();
    }
}