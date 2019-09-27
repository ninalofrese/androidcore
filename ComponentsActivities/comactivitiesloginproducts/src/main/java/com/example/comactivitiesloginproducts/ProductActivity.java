package com.example.comactivitiesloginproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import static com.example.comactivitiesloginproducts.LoginActivity.NOME_KEY;

public class ProductActivity extends AppCompatActivity {
    private TextView nomeUsuario;
    private TextInputLayout nomeProduto;
    private TextInputLayout qtdeProduto;
    private TextInputLayout valorProduto;
    private Button btnCadastrar;
    private FloatingActionButton btnAdd;
    private LinearLayout viewCampos;
    int contador;

    public static final String NAME_ARRAY_KEY = "nome";
    public static final String QTTY_ARRAY_KEY = "quantidade";
    public static final String VALUE_ARRAY_KEY = "valor";

    ArrayList<String> listaNome = new ArrayList<>();
    ArrayList<Integer> listaQuantidade = new ArrayList<>();
    ArrayList<String> listaPreco = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        initViews();

        //Pega dados que vieram da tela de Login
        Intent intent = getIntent();

        if (intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();
            String username = bundle.getString(NOME_KEY);
            //Seta o nome do usuário no canto da tela
            nomeUsuario.setText(username);
        }
        //o botão de adicionar permite que registre-se 3 produtos, 1 de cada vez na mesma activity
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Traz os valores inputados nos campos
                String produto = nomeProduto.getEditText().getText().toString();
                String quantidade = qtdeProduto.getEditText().getText().toString();
                String valor = valorProduto.getEditText().getText().toString();

                //verifica contra null e vazio
                if (!produto.isEmpty() && !quantidade.isEmpty() && !valor.isEmpty()) {
                    //o contador limita o máximo de cadastros feitos na hora de adicionar
                    contador++;
                    if(contador <= 3){
                        //adiciona em arrays para que cada vez que preenche fique registrado
                        listaNome.add(produto);
                        listaQuantidade.add(Integer.parseInt(quantidade));
                        listaPreco.add(valor);

                        //chama método especial que limpa o formulário e confirma a ação no Snackbar
                        clearForm(viewCampos);
                        Snackbar.make(viewCampos, "Adicione um novo produto.", Snackbar.LENGTH_SHORT).show();
                    }
                    else{
                        Snackbar.make(viewCampos, "Você já adicionou três produtos.", Snackbar.LENGTH_SHORT).show();
                    }

                } else {
                    nomeProduto.setError("Preencha o nome do produto");
                    qtdeProduto.setError("Preencha a quantidade do produto");
                    valorProduto.setError("Preencha o preço do produto");
                }

            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(listaNome != null && listaPreco != null && listaQuantidade != null){
                    Intent intentNext = new Intent(ProductActivity.this, ListaActivity.class);

                    Bundle bundleNext = new Bundle();

                    //Transfere as listas como ArrayList, o double também foi como array para evitar exceções
                    bundleNext.putStringArrayList(NAME_ARRAY_KEY, listaNome);
                    bundleNext.putIntegerArrayList(QTTY_ARRAY_KEY, listaQuantidade);
                    bundleNext.putStringArrayList(VALUE_ARRAY_KEY, listaPreco);

                    intentNext.putExtras(bundleNext);

                    startActivity(intentNext);
                } else{
                    Snackbar.make(viewCampos, "Lista vazia. Insira um produto e adicione (+) antes de continuar.", Snackbar.LENGTH_LONG).show();
                }

            }
        });

    }

    public void initViews() {
        nomeUsuario = findViewById(R.id.text_product_loginname);
        nomeProduto = findViewById(R.id.inputlayout_product_name);
        qtdeProduto = findViewById(R.id.inputlayout_product_qtty);
        valorProduto = findViewById(R.id.inputlayout_product_value);
        btnCadastrar = findViewById(R.id.btn_product_cadastrar);
        btnAdd = findViewById(R.id.btn_adicionar_produto);
        viewCampos = findViewById(R.id.linearLayout);
    }

    private void clearForm(ViewGroup group) {
        //método que usa o ViewGroup para localizar os campos e esvaziar eles.
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }

            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearForm((ViewGroup)view);
        }
        //quando termina de limpar, coloca o focus no primeiro campo
        nomeProduto.requestFocus();
    }
}
