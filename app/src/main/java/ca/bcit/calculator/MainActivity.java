package ca.bcit.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;


public class
MainActivity
        extends AppCompatActivity implements View.OnClickListener
{

    Button
            button0, button1, button2, button3, button4, button5,
            button6, button7, button8, button9,
            div, multi, add, sub,
            equal, clear;

    TextView screen;
    DecimalFormat formatter;
    String num_for_cal = "";
    double num1 , num2;
    double answer = -1;
    boolean addition, subtraction, multiplication, division,
            addtion_2 = false, subtraction_2 = false,
            multiplication_2 = false, division_2 = false;
    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        div = findViewById(R.id.div);
        multi = findViewById(R.id.multi);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        equal = findViewById(R.id.equal);
        clear = findViewById(R.id.clear);
        screen = findViewById(R.id.result);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        div.setOnClickListener(this);
        multi.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.button0:
                screen.setText(screen.getText() + "0");
                num_for_cal += "0";
                break;
            case R.id.button1:
                screen.setText(screen.getText() + "1");
                num_for_cal += "1";
                break;
            case R.id.button2:
                screen.setText(screen.getText() + "2");
                num_for_cal += "2";
                break;
            case R.id.button3:
                screen.setText(screen.getText() + "3");
                num_for_cal += "3";
                break;
            case R.id.button4:
                screen.setText(screen.getText() + "4");
                num_for_cal += "4";
                break;
            case R.id.button5:
                screen.setText(screen.getText() + "5");
                num_for_cal += "5";
                break;
            case R.id.button6:
                screen.setText(screen.getText() + "6");
                num_for_cal += "6";
                break;
            case R.id.button7:
                screen.setText(screen.getText() + "7");
                num_for_cal += "7";
                break;
            case R.id.button8:
                screen.setText(screen.getText() + "8");
            num_for_cal += "8";
            break;
            case R.id.button9:
                screen.setText(screen.getText() + "9");
                num_for_cal += "9";
                break;
            case R.id.div:
                div_cal();
                break;
            case R.id.multi:
                multi_cal();
                break;
            case R.id.add:
                add_cal();
                break;
            case R.id.sub:
                sub_cal();
                break;
            case R.id.equal:
                equal_cal();
                break;
            case R.id.clear:
                clear_all();
                break;
            default: break;
        }
    }


    public void div_cal()
    {
        if(division == false)
        {
            num1 = Double.parseDouble(screen.getText() + "");
            screen.setText(screen.getText() + " ÷ ");
            division = true;
            num_for_cal = "";
        } else {
            equal_cal();
            division = false;
            div.callOnClick();
        }
    }

    public void multi_cal()
    {
        if(multiplication == false)
        {
            num1 = Double.parseDouble(screen.getText() + "");
            screen.setText(screen.getText() + " x ");
            multiplication = true;
            num_for_cal = "";
        } else {
            equal_cal();
            multiplication = false;
            multi.callOnClick();
        }
    }

    public void add_cal()
    {
        if(addition == false)
        {
            num1 = Double.parseDouble(screen.getText() + "");
            screen.setText(screen.getText() + " + ");
            addition = true;
            num_for_cal = "";
        } else {
            equal_cal();
            addition = false;
            add.callOnClick();
        }
    }

    public void sub_cal()
    {
        if(subtraction == false)
        {
            num1 = Double.parseDouble(screen.getText() + "");
            screen.setText(screen.getText() + " - ");
            subtraction = true;
            num_for_cal = "";
        } else {
            equal_cal();
            subtraction = false;
            sub.callOnClick();
        }

    }

    public void equal_cal()
    {
        formatter = new DecimalFormat("#.##");

        if(division)
        {
            num2 = Double.parseDouble(num_for_cal + "");
            answer = (num1 / num2);
            division = false;
        }

        if(multiplication)
        {
            num2 = Double.parseDouble(num_for_cal + "");
            answer = (num1 * num2);
            multiplication = false;
        }

        if(addition)
        {
            num2 = Double.parseDouble(num_for_cal + "");
            answer = (num1 + num2);
            addition = false;
        }


        if(subtraction)
        {
            num2 = Double.parseDouble(num_for_cal + "");
            answer = (num1 - num2);
            subtraction = false;
        }

        screen.setText("");
        screen.setText(formatter.format(answer));
    }

    public void clear_all()
    {
        screen.setText("");
        num_for_cal = "";
        addition = subtraction = division = multiplication = false;
        num1 = num2 = 0;
    }


}
