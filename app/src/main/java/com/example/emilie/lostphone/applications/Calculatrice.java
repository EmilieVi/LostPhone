package com.example.emilie.lostphone.applications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.emilie.lostphone.R;

public class Calculatrice extends AppCompatActivity implements View.OnClickListener{

    TextView ecran;

    String display;

    int previousNumber;

    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);
        ecran = (TextView) findViewById(R.id.ecran);
        setTitle("Calculatrice");
        display = "";
        previousNumber = 0;
        operator = ' ';

        Button un = (Button)findViewById(R.id.un);
        un.setOnClickListener(this);

        Button deux = (Button)findViewById(R.id.deux);
        deux.setOnClickListener(this);

        Button trois = (Button)findViewById(R.id.trois);
        trois.setOnClickListener(this);

        Button quatre = (Button)findViewById(R.id.quatre);
        quatre.setOnClickListener(this);

        Button cinq = (Button)findViewById(R.id.cinq);
        cinq.setOnClickListener(this);

        Button six = (Button)findViewById(R.id.six);
        six.setOnClickListener(this);

        Button sept = (Button)findViewById(R.id.sept);
        sept.setOnClickListener(this);

        Button huit = (Button)findViewById(R.id.huit);
        huit.setOnClickListener(this);

        Button neuf = (Button)findViewById(R.id.neuf);
        neuf.setOnClickListener(this);

        Button add = (Button)findViewById(R.id.add);
        add.setOnClickListener(this);

        Button sub = (Button)findViewById(R.id.sub);
        sub.setOnClickListener(this);

        Button mul = (Button)findViewById(R.id.mul);
        mul.setOnClickListener(this);

        Button div = (Button)findViewById(R.id.div);
        div.setOnClickListener(this);

        Button egal = (Button)findViewById(R.id.egal);
        egal.setOnClickListener(this);

        Button zero = (Button)findViewById(R.id.zero);
        zero.setOnClickListener(this);

        Button clear = (Button)findViewById(R.id.clear);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.un: display+="1";
                break;
            case R.id.deux: display+="2";
                break;
            case R.id.trois: display+="3";
                break;
            case R.id.quatre: display+="4";
                break;
            case R.id.cinq: display+="5";
                break;
            case R.id.six: display+="6";
                break;
            case R.id.sept: display+="7";
                break;
            case R.id.huit: display+="8";
                break;
            case R.id.neuf: display+="9";
                break;
            case R.id.zero: display+="0";
                break;
            case R.id.clear:
                display = "";
                ecran.setText(display);
                break;
            case R.id.add:
                if(display!=""){
                    previousNumber = Integer.parseInt(display);
                    operator = '+';
                    display = "";
                }
                break;
            case R.id.mul:
                if(display!=""){
                    previousNumber = Integer.parseInt(display);
                    operator = '*';
                    display = "";
                }
                break;
            case R.id.div:
                if(display!=""){
                    previousNumber = Integer.parseInt(display);
                    operator = '/';
                    display = "";
                }
                break;
            case R.id.sub:
                if(display!=""){
                    previousNumber = Integer.parseInt(display);
                    operator = '-';
                    display = "";
                }
                break;
            case R.id.egal:
                if(previousNumber!=0){
                    int number = Integer.parseInt(display);
                    int result;
                    switch(operator) {
                        case '+':
                            result = number+previousNumber;
                            display = result+"";
                            break;
                        case '-':
                            result = previousNumber-number;
                            display = result+"";
                            break;
                        case '*':
                            result = previousNumber*number;
                            display = result+"";
                            break;
                        case '/':
                            result = previousNumber/number;
                            display = result+"";
                            break;
                        default:
                            break;
                    }
                    previousNumber = 0;
                }
        }
        ecran.setText(display);
    }
}
