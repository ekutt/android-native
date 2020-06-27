package ekutt.example.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    GPACalculator  gpaCalc = new GPACalculator();
    static {
        System.loadLibrary("gpaCalc-jni");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clickButton = (Button) findViewById(R.id.calc_gpa_button);
        clickButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calculateGPAs();
            }
        });
    }

    private void calculateGPAs()
    {
        gpaCalc.addGrade("Susan", 4.0f, 4);
        gpaCalc.addGrade("Susan", 2.5f, 2);
        gpaCalc.addGrade("Susan", 3.0f, 3);
        gpaCalc.addGrade("Bob", 4.0f, 4);
        gpaCalc.addGrade("Bob", 2.5f, 2);
        gpaCalc.addGrade("Bob", 2.0f, 4);
        gpaCalc.addGrade("Philip", 4.0f, 4);
        gpaCalc.addGrade("Philip", 3.5f, 2);
        gpaCalc.addGrade("Philip", 3.0f, 1);

        List<Result> gpaList= gpaCalc.calculateGPAs();

        TableLayout tableLayout = (TableLayout) findViewById(R.id.main_table);

        gpaCalc.clearData();
        tableLayout.removeAllViews();

        TableRow tr_head = new TableRow(this);
        tr_head.setId(View.generateViewId());
        tr_head.setBackgroundColor(Color.GRAY);
        tr_head.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView label_name = new TextView(this);
        label_name.setId(View.generateViewId());
        label_name.setText("Name");
        label_name.setTextColor(Color.RED);
        label_name.setPadding(20, 5, 5, 5);
        tr_head.addView(label_name);

        TextView label_credits = new TextView(this);
        label_credits.setId(View.generateViewId());
        label_credits.setText("Total Credits");
        label_credits.setTextColor(Color.RED);
        label_credits.setPadding(20, 5, 5, 5);
        tr_head.addView(label_credits);

        TextView label_gpa = new TextView(this);
        label_gpa.setId(View.generateViewId());
        label_gpa.setText("GPA");
        label_gpa.setTextColor(Color.RED);
        label_gpa.setPadding(5, 5, 5, 5);
        tr_head.addView(label_gpa);

        tableLayout.addView(tr_head, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        for(int index=0; index<gpaList.size(); index++)
        {
            TableRow row = new TableRow(this);
            row.setId(View.generateViewId());
            row.setBackgroundColor(Color.GRAY);
            row.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            TextView tvName = new TextView(this);
            tvName.setText(gpaList.get(index).name);
            tvName.setPadding(5, 5, 5, 5);
            row.addView(tvName);
            TextView tvCredits = new TextView(this);
            tvCredits.setText(Integer.toString(gpaList.get(index).totalCredits));
            tvCredits.setPadding(20, 5, 5, 5);
            row.addView(tvCredits);
            TextView tvGPA = new TextView(this);
            tvGPA.setText(Float.toString(gpaList.get(index).gpa));
            tvGPA.setPadding(20, 5, 5, 5);
            row.addView(tvGPA);

            tableLayout.addView(row, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }
}
