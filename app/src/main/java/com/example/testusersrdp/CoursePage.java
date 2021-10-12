package com.example.testusersrdp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import model.Order;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout courseBg = findViewById(R.id.coursePageBg);
        ImageView courseImage = findViewById(R.id.coursePageImage);
        TextView courseTitle = findViewById(R.id.coursePageTitle);
        TextView courseDate = findViewById(R.id.coursePageDate);
        TextView courseLevel = findViewById(R.id.coursePageLevel);
        TextView courseText = findViewById(R.id.coursePageText);

        courseBg.setBackgroundColor(getIntent().getIntExtra("coursePageBg", 0));
        courseImage.setImageResource(getIntent().getIntExtra("coursePageImage", 0));
        courseTitle.setText(getIntent().getStringExtra("coursePageTitle"));
        courseDate.setText(getIntent().getStringExtra("coursePageDate"));
        courseLevel.setText(getIntent().getStringExtra("coursePageLevel"));
        courseText.setText(getIntent().getStringExtra("coursePageText"));
    }

    public void addToCart(View view){
        int item_id = getIntent().getIntExtra("coursePageId", 0);
        if(Order.items_id.contains(item_id))
            Toast.makeText(this, "Уже было добавлено", Toast.LENGTH_SHORT).show();
        else {
            Order.items_id.add(item_id);
            Toast.makeText(this, "Добавлено!", Toast.LENGTH_SHORT).show();
        }
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