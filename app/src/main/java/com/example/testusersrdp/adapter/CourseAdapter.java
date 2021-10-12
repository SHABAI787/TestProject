package com.example.testusersrdp.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testusersrdp.CoursePage;
import com.example.testusersrdp.R;

import java.util.List;

import model.Course;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
   Context context;
   List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseAdapter.CourseViewHolder(courseItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {

        holder.courseBg.setCardBackgroundColor(Color.parseColor(courses.get(position).getColor()));

        int imageId = context.getResources().getIdentifier("ic_" + courses.get(position).getImg(), "drawable", context.getPackageName());
        holder.courseImage.setImageResource(imageId);

        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.courseDate.setText(courses.get(position).getDate());
        holder.courseLevel.setText(courses.get(position).getLevel());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(context, CoursePage.class);

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, new Pair<View, String>(holder.courseImage, "courseImage"));

                intent.putExtra("coursePageBg",Color.parseColor(courses.get(holder.getAdapterPosition()).getColor()));
                intent.putExtra("coursePageImage", imageId);
                intent.putExtra("coursePageTitle", courses.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("coursePageDate", courses.get(holder.getAdapterPosition()).getDate());
                intent.putExtra("coursePageLevel", courses.get(holder.getAdapterPosition()).getLevel());
                intent.putExtra("coursePageText", courses.get(holder.getAdapterPosition()).getText());
                context.startActivity(intent, activityOptions.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public  static final  class CourseViewHolder extends RecyclerView.ViewHolder{

        CardView courseBg;
        ImageView courseImage;
        TextView courseTitle, courseLevel, courseDate;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseBg = itemView.findViewById(R.id.courseBg);
            courseImage = itemView.findViewById(R.id.courseImage);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            courseLevel = itemView.findViewById(R.id.courseLevel);
            courseDate = itemView.findViewById(R.id.courseDate);
        }
    }
}
