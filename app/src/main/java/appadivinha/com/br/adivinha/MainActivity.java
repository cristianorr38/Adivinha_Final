package appadivinha.com.br.adivinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText txtJogador1;
    private EditText txtJogador2;
    private Button btnSortear;
    private TextView lblNumSorteado;
    private TextView lblJogVencedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        txtJogador1 = (EditText) findViewById(R.id.txtJogador1);
        txtJogador1.requestFocus();
        txtJogador2 = (EditText) findViewById(R.id.txtJogador2);
        lblNumSorteado = (TextView) findViewById(R.id.lbl_NumSorteado);
        lblJogVencedor = (TextView) findViewById(R.id.lbl_JogVencedor);

        btnSortear = (Button) findViewById(R.id.btnSortear);
        btnSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtJogador1.getText().toString().isEmpty()){
                    validaJog1();
                } else if (txtJogador2.getText().toString().isEmpty()){
                    validaJog2();
                } else {
                    int Jog1 = Integer.parseInt(txtJogador1.getText().toString());
                    int Jog2 = Integer.parseInt(txtJogador2.getText().toString());

                    if (Jog1 > 10){
                        validaJog1();
                    } else if (Jog2 > 10){
                        validaJog2();
                    } else {
                        Random random = new Random();
                        int resultado = random.nextInt(11);
                        lblNumSorteado.setText(getResources().getString(R.string.texto_numsorteado) + " " + resultado);
                        if(Jog1 == resultado && Jog2 == resultado){
                            lblJogVencedor.setText(R.string.texto_empate);
                            txtJogador1.requestFocus();
                        } else if (Jog1 == resultado){
                            lblJogVencedor.setText(R.string.texto_jog1venceu);
                            txtJogador1.requestFocus();
                        } else if (Jog2 == resultado){
                            lblJogVencedor.setText(R.string.texto_jog2venceu);
                            txtJogador1.requestFocus();
                        } else {
                            lblJogVencedor.setText(R.string.texto_ningvenceu);
                            txtJogador1.requestFocus();
                        }
                    }
                }
            }
        });
    }

    public void validaJog1(){
        Toast.makeText(getApplicationContext(), R.string.texto_msgnuminvalido, Toast.LENGTH_LONG).show();
        txtJogador1.requestFocus();
        lblNumSorteado.setText(R.string.texto_sorteio);
        lblJogVencedor.setText(R.string.texto_resultado);
    }

    public void validaJog2(){
        Toast.makeText(getApplicationContext(), R.string.texto_msgnuminvalido, Toast.LENGTH_LONG).show();
        txtJogador2.requestFocus();
        lblNumSorteado.setText(R.string.texto_sorteio);
        lblJogVencedor.setText(R.string.texto_resultado);
    }
}
