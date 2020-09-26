package android.teste.matheusaguilar.calculadora2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickNumberButton(View view){
        EditText visorView = (EditText) findViewById(R.id.visor);
        TextView errorsView = (TextView) findViewById(R.id.errorsText);

        String[] parts = visorView.getText().toString().split(" ");
        String digit = view.getTag().toString();

        errorsView.setText("");


        if(parts[0].length() == 0)
            visorView.setText(digit);
        else if(parts.length == 1)
            visorView.setText(parts[0] + digit);
        else if(parts.length == 2)
            visorView.setText(parts[0] + ' ' + parts[1] + ' ' + digit);
        else if(parts.length == 3)
            visorView.setText(parts[0] + ' ' + parts[1] + ' ' + parts[2] + digit);
        else
            errorsView.setText("Erro desconhecido");
    }

    public void clickOperatorButton(View view){
        EditText visorView = (EditText) findViewById(R.id.visor);
        TextView errorsView = (TextView) findViewById(R.id.errorsText);

        String[] parts = visorView.getText().toString().split(" ");
        String op = view.getTag().toString();

        errorsView.setText("");

        if(parts[0].length() == 0) {
            if(op.equals("-"))
                visorView.setText(op);
        }
        else if(parts.length == 1) {
            if(parts[0].charAt(parts[0].length() - 1) != '-' && parts[0].charAt(parts[0].length() - 1) != '.')
                visorView.setText(parts[0] + ' ' + op);
        }
        else if(parts.length == 2) {
            if(op.equals("-"))
                visorView.setText(parts[0] + ' ' + parts[1] + ' ' + op);
        }
        else if(parts.length == 3)
            return;
        else
            errorsView.setText("Erro desconhecido");
    }

    public void clickPointButton(View view){
        EditText visorView = (EditText) findViewById(R.id.visor);
        TextView errorsView = (TextView) findViewById(R.id.errorsText);

        String[] parts = visorView.getText().toString().split(" ");

        errorsView.setText("");


        if(parts[0].length() == 0)
            return;
        else if(parts.length == 1) {
            if(parts[0].indexOf('.') == -1 && parts[0].length() > 0)
                visorView.setText(parts[0] + '.');
        }
        else if(parts.length == 2)
            return;
        else if(parts.length == 3) {
            if (parts[2].indexOf('.') == -1)
                visorView.setText(parts[0] + ' ' + parts[1] + ' ' + parts[2] + '.');
        }
        else
            errorsView.setText("Erro desconhecido");
    }

    public void clickEqualButton(View view){
        EditText visorView = (EditText) findViewById(R.id.visor);
        TextView errorsView = (TextView) findViewById(R.id.errorsText);

        String[] parts = visorView.getText().toString().split(" ");

        errorsView.setText("");

        if(parts.length == 3){

            if(parts[0].charAt(parts[0].length() - 1) == '-' || parts[0].charAt(parts[0].length() - 1) == '.')
                return;

            if(parts[2].charAt(parts[2].length() - 1) == '-' || parts[2].charAt(parts[2].length() - 1) == '.')
                return;

            double n1, n2;

            try{
                n1 = Double.parseDouble(parts[0]);
                n2 = Double.parseDouble(parts[2]);
            }
            catch(NumberFormatException e){
                return;
            }

            if(parts[1].equals("+"))
                visorView.setText(Double.toString(n1 + n2));
            else if(parts[1].equals("-"))
                visorView.setText(Double.toString(n1 - n2));
            else if(parts[1].equals("x"))
                visorView.setText(Double.toString(n1 * n2));
            else if(parts[1].equals("/")){
                if(n2 != 0.0)
                    visorView.setText(Double.toString(n1 / n2));
                else
                    errorsView.setText("Erro: Divisao por Zero");
            }
            else{
                visorView.setText("");
                errorsView.setText("Erro: Operador Invalido");
            }
        }
    }

    public void clickBackSpaceButton(View view){

        EditText visorView = (EditText) findViewById(R.id.visor);
        TextView errorsView = (TextView) findViewById(R.id.errorsText);

        String[] parts = visorView.getText().toString().split(" ");

        errorsView.setText("");

        if(parts[0].length() == 0)
            return;
        else if(parts.length == 1)
            visorView.setText(parts[0].substring(0, parts[0].length() - 1));
        else if(parts.length == 2)
            visorView.setText(parts[0]);
        else if(parts.length == 3) {
            if (parts[2].length() > 1)
                visorView.setText(parts[0] + ' ' + parts[1] + ' ' + parts[2].substring(0, parts[2].length() - 1));
            else
                visorView.setText(parts[0] + ' ' + parts[1]);
        }
        else
            errorsView.setText("Erro desconhecido");
    }

    public void clickClearButton(View view){
        EditText visorView = (EditText) findViewById(R.id.visor);
        TextView errorsView = (TextView) findViewById(R.id.errorsText);

        visorView.setText("");
        errorsView.setText("");
    }
}