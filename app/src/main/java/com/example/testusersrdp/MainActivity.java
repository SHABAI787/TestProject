package com.example.testusersrdp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.testusersrdp.adapter.CategoryAdapter;
import com.example.testusersrdp.adapter.CourseAdapter;

import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Course;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter  courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCourseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));
        setCategoruRecycler(categoryList);

        courseList.add(new Course(1, "course1", "Профессия Java\nразработчик", "1 января", "начальный", "#424345", "Описание курса", 1));
        courseList.add(new Course(2, "ccharp_1", "Профессия C#\nразрботчик", "1 января", "начальный", "#611884", "Описание курса", 2));
        courseList.add(new Course(3, "python", "Профессия Python\nразрботчик", "1 января", "начальный", "#9FA52D", "Описание курса", 3));

        fullCourseList.addAll(courseList);
        setCourseRecycler(courseList);
    }

    public void openShopingCart(View view){
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);

    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);
        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoruRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showCoursesByCategory(int category){
        List<Course>  filterCourses = new ArrayList<>();

        for (Course c: fullCourseList){
            if(c.getCategory() == category)
                filterCourses.add(c);
        }
        setChangedCourseList(filterCourses);
    }

    public static void setChangedCourseList(List<Course>  filterCourses){
        courseList.clear();
        courseList.addAll(filterCourses);
        courseAdapter.notifyDataSetChanged();
    }

    public void onFilterOff(View view)
    {
        setChangedCourseList(fullCourseList);
        // выводим сообщение
        Toast.makeText(this, "Фильтер выключен", Toast.LENGTH_SHORT).show();
    }
}