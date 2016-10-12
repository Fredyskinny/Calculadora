package com.example.fredy.calculadoraclases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity implements OnClickListener {

    TextView myTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);


        View v1=findViewById(R.id.txt1);
        myTextView=(TextView) v1;
        myTextView.setText("");

        View boton1=findViewById(R.id.btn1);
        boton1.setOnClickListener(this);
        View boton2=findViewById(R.id.btn2);
        boton2.setOnClickListener(this);
        View boton3=findViewById(R.id.btn3);
        boton3.setOnClickListener(this);
        View boton4=findViewById(R.id.btn4);
        boton4.setOnClickListener(this);
        View boton5=findViewById(R.id.btn5);
        boton5.setOnClickListener(this);
        View boton6=findViewById(R.id.btn6);
        boton6.setOnClickListener(this);
        View boton7=findViewById(R.id.btn7);
        boton7.setOnClickListener(this);
        View boton8=findViewById(R.id.btn8);
        boton8.setOnClickListener(this);
        View boton9=findViewById(R.id.btn9);
        boton9.setOnClickListener(this);
        View boton0=findViewById(R.id.btn0);
        boton0.setOnClickListener(this);
        View botonSuma=findViewById(R.id.btnsuma);
        botonSuma.setOnClickListener(this);
        View botonResta=findViewById(R.id.btnMenos);
        botonResta.setOnClickListener(this);
        View botonMultiplica=findViewById(R.id.btnX);
        botonMultiplica.setOnClickListener(this);
        View botonDivide=findViewById(R.id.btnDivision);
        botonDivide.setOnClickListener(this);
        View botonPunto=findViewById(R.id.btnPunto);
        botonPunto.setOnClickListener(this);
        View botonBorra=findViewById(R.id.btnBorrar);
        botonBorra.setOnClickListener(this);
        View botonIgual=findViewById(R.id.btnIgual);
        botonIgual.setOnClickListener(this);
        View por=findViewById(R.id.btnPorc);
        por.setOnClickListener(this);
        View cam=findViewById(R.id.btnCambioSigno);
        cam.setOnClickListener(this);

    }

    double result,m1=0,m2=0;
    char opAnterior='+';

    public void onClick(View v){

        if(v.getId()==R.id.btn1)      myTextView.append("1");
        else if(v.getId()==R.id.btn2) myTextView.append("2");
        else if(v.getId()==R.id.btn3) myTextView.append("3");
        else if(v.getId()==R.id.btn4) myTextView.append("4");
        else if(v.getId()==R.id.btn5) myTextView.append("5");
        else if(v.getId()==R.id.btn6) myTextView.append("6");
        else if(v.getId()==R.id.btn7) myTextView.append("7");
        else if(v.getId()==R.id.btn8) myTextView.append("8");
        else if(v.getId()==R.id.btn9) myTextView.append("9");
        else if(v.getId()==R.id.btn0) myTextView.append("0");
        else if(v.getId()==R.id.btnPunto) myTextView.append(".");
        else if(v.getId()==R.id.btnBorrar){
            myTextView.setText("");
            m1=0;
            opAnterior='+';
        }
        else if(v.getId()==R.id.btnsuma) calcula('+');
        else if(v.getId()==R.id.btnMenos) calcula('-');
        else if(v.getId()==R.id.btnX) calcula('*');
        else if(v.getId()==R.id.btnDivision) calcula('/');
        else if(v.getId()==R.id.btnIgual) calcula('=');
        else if (v.getId()==R.id.btnPorc) calcula('%');
        else if (v.getId()==R.id.btnCambioSigno) calcula ('a');
    }

    public void calcula(char op){

        double result=m1;
        String cadena= myTextView.getText().toString();
        try{
            m2=Double.parseDouble(cadena);
            if(opAnterior=='+') result=m1+m2;
            else if(opAnterior=='-') result=m1-m2;
            else if(opAnterior=='*') result=m1*m2;
            else if(opAnterior=='/') result=m1/m2;
            else if(opAnterior=='%') result=(m1*m2)/100;
            else if(opAnterior=='a') result=(-m1);
            m1=result;
            opAnterior=op;
            if(op == '='){
                myTextView.setText(""+m1);
            }else{
                myTextView.setText("");
            }

        } catch(NumberFormatException nfe){
            Toast.makeText(this,"Número Incorrecto",Toast.LENGTH_SHORT).show();
        }

    }


}