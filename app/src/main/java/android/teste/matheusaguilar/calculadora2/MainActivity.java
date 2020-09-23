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
        String text = visorView.getText().toString();

        char last = '\0';

        if(text.length() > 0)
            last = text.charAt(text.length() - 1);

        if(last == '+' || last == '-' || last == 'x' || last == '/')
            visorView.setText(text + ' ' + view.getTag().toString());
        else
            visorView.setText(text + view.getTag().toString());

        errorsView.setText("");
    }

    public void clickOperatorButton(View view){
        EditText visorView = (EditText) findViewById(R.id.visor);
        TextView errorsView = (TextView) findViewById(R.id.errorsText);
        String text = visorView.getText().toString();

        visorView.setText(text + ' ' + view.getTag().toString());
        errorsView.setText("");
    }

    public void clickPointButton(View view){
        EditText visorView = (EditText) findViewById(R.id.visor);
        TextView errorsView = (TextView) findViewById(R.id.errorsText);
        String text = visorView.getText().toString();

        char last = '\0';

        if(text.length() > 0)
            last = text.charAt(text.length() - 1);

        if(last == '+' || last == '-' || last == 'x' || last == '/')
            visorView.setText(text + ' ' + '.');
        else
            visorView.setText(text + '.');

        errorsView.setText("");
    }

    public void clickEqualButton(View view){
        EditText visorView = (EditText) findViewById(R.id.visor);
        TextView errorsView = (TextView) findViewById(R.id.errorsText);

        String text = visorView.getText().toString();
        String parts[] = text.split(" ");

        if(parts.length == 3){
            double n1, n2;
            try{
                n1 = Double.parseDouble(parts[0]);
                n2 = Double.parseDouble(parts[2]);
            }
            catch(NumberFormatException e){
                visorView.setText("");
                errorsView.setText("Erro: Sintaxa Inválida");
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
                else{
                    visorView.setText("");
                    errorsView.setText("Erro: Divisao por Zero");
                }
            }
            else{
                visorView.setText("");
                errorsView.setText("Erro: Operador Invalido");
            }
        }
        else{
            visorView.setText("");
            errorsView.setText("Erro: Sintaxe Inválida");
        }
    }

    public void clickBackSpaceButton(View view){
        EditText visorView = (EditText) findViewById(R.id.visor);
        TextView errorsView = (TextView) findViewById(R.id.errorsText);
        String text = visorView.getText().toString();

        if(text.length() > 0) {

            char last = text.charAt(text.length() - 1);

            if(last == ' ')
                visorView.setText(text.substring(0, text.length() - 3));
            else if(last == '+' || last == '-' || last == 'x' || last == '/')
                visorView.setText(text.substring(0, text.length() - 2));
            else
                visorView.setText(text.substring(0, text.length() - 1));
        }
        errorsView.setText("");
    }

    public void clickClearButton(View view){
        EditText visorView = (EditText) findViewById(R.id.visor);
        TextView errorsView = (TextView) findViewById(R.id.errorsText);
        String text = visorView.getText().toString();

        visorView.setText("");
        errorsView.setText("");
    }
}