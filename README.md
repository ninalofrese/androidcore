# Android Core
Quase tudo sobre Android Core, com base no conteúdo passado em aula e complementado com estudos.

## Alguns conceitos

- **XML:** É a linguagem de marcação para estruturar as informações. Ao invés do HTML, usa-se o XML.
- **Views:** View é qualquer elemento dentro do espaço da tela. Elas podem ser ViewGroup, Button, TextView, ImageView, etc.

## Algumas comunicações do Java com a tela

- **Toast:** Mensagem que pode ser curta ou lenta, o posicionamento pode ser diferente do padrão (área inferior da tela)
- **SnackBar:** Mensagem que aparece em uma barra, pode ser curta ou lenta, o posicionamento não pode ser alterado. Interage melhor com [CoordinatorLayout](https://medium.com/@rusinikita/simple-view-dodging-with-coordinatorlayout-f13cc32e0de6).

```
Toast.makeText(getApplicationContext(), "Não há dados!", Toast.LENGTH_SHORT).show();

Snackbar.make(viewCampos, "Mensagem", Snackbar.LENGTH_LONG).show();

//Centraliza posicionamento do Toast
Toast toast = Toast.makeText(this, texto, Toast.LENGTH_LONG);
toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
toast.show();
```

### Splash screen

É bem comum colocar timer na tela de splash.

```
private ImageView imgSplash;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgSplash = findViewById(R.id.image_spash_background);

        imgSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jump();
            }
        });

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        }, 3000);
    }

    private void jump() {
        timer.cancel();
        startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
        finish();
    }
```

## Ajustes de tela

#### ScrollView

Permite que a tela seja "rolável". Encapsula todo o layout, incluindo o viewgroup da activity.

#### adjustResize

É utilizado quando componentes da interface serão cobertos pelo soft keyboard. Um exemplo: com um formulário, o botão de submit pode ser ocultado pelo teclado quando se insere algo no input.

Precisa ser adicionado em dois lugares, no `<activity>` dentro do arquivo manifest.xml, e no ViewGroup do layout.

```
//viewgroup (Constraint, Linear)
android:fitsSystemWindows="true"

//<activity> no manifest.xml
android:windowSoftInputMode="adjustResize"
```
#### CoordinatorLayout

É um layout que permite controlar melhor os filhos, tanto nos cliques como nas animações. As views podem ter `layout_anchor` e `layout_anchorGravity`, que podem ser utilizados para colocar alguma view flutuando relativamente à outra.

https://android.jlelse.eu/coordinatorlayout-basic-8040c74cf426

https://medium.com/android-dev-br/design-support-library-c2c7aebd8cb


## Comunicação entre activities

Cada activity é uma instância diferente, então para uma ter acesso a dados da outra se transporta por meio de Intents.

#### Intent

```
// usada quando só quer iniciar uma nova activity, sem passar dados, com uma intenção vazia
startActivity(new Intent(this, mainActivity.class));

//essa construção permite passar algum dado
Intent intent = new Intent(this, DestinoActivity.class);
startActivity(intent);
```

#### Bundle
É como se fosse um container que vai **agrupar** os dados para colocar no Intent e mandar para uma outra activity. Ele é do tipo Map, como uma coleção.

- Bundle é um map que só trabalha com chaves do tipo String.

**Activity de origem**

```
Intent intent = new Intent(this, DestinoAcitivity.class);
String nome = edittext.getText().toString();
int idade = (int) edittext.getText().toString();

Bundle bundle = new Bundle();
bundle.putString("NOME", nome); //poderia ser putBoolean, putInteger, etc.
bundle.putInt("IDADE", idade);
intent.putExtras(bundle); //passa a bundle para o intent

startActivity(intent);
```

**Activity de destino**

```
Intent intent = getIntent();
Bundle bundle = intent.getExtras();
String nome = bundle.getString("NOME");
int idade = bundle.getInt("IDADE");

textNome.setText(nome);
```

#### Constantes

```
public static final String NOME_KEY = "nome";
public static final String TELEFONE_KEY = "telefone";
```

- Precisa ser visível para todo mundo (_public_) 
- Não precisa ter um objeto/instância para ser chamada (_static_)
- Não pode mudar, imutável (_final_)

ENUM é uma lista que guarda uma lista de constantes.

#### Fluxo de comunicação entre activities

![Diagrama de comunicação entre activities](/comunicacaoentreactivities/comunicacaoactivities-2.jpg)

**Activity 1 - Origem**
1. Primeiro registre a intenção de enviar dados para uma outra activity, instanciando uma **Intent** e informando qual a origem e qual o destino.
2. Cria um "pacote" que será usado para **agrupar** os valores, ou seja, instancia um Bundle.
3. Coloca os valores no "pacote", um por um, usando uma chave como referência. `putString(chave, valor);`
4. Coloca o pacote na intenção `intent.putExtras(bundle);`
5. Começa uma nova activity usando os dados da intenção `startActivity(intent)`

**Activity 2 - Destino**
1. Pega a intenção que foi enviada para ela. `Intent intent = getIntent();`
2. Pega o pacote que foi enviado dentro do intent `Bundle bundle = intent.getExtras();`
3. Pega os valores do pacote, um por um, buscando pela chave. `String nome = bundle.getString("NOME");`

Depois desse ponto, os valores podem ser manipulados e/ou exibidos, usando `textview.setText(nome)`, por exemplo.

## Fragments

É um pedaço da tela que pode ser reutilizado em outras partes do seu app. Ele faz parte de uma activity e depende dela para existir.

Um exemplo é o app do Gmail no tablet, que tem 3 fragmentos: menu à esquerda, lista de e-mails e corpo do e-mail. No celular, cada um deles é uma tela, mas só uma activity com vários fragmentos.
Outro exemplo é o bottom navigation do celular.

Vantagens:
- reutilização de telas (e é por esse motivo que elas não se comunicam diretamente, usam a Activity)
- diminui a duplicação de código
- permite modular uma activity
- facilita designs dinâmicos e acessíveis

### Ciclo de vida

![Ciclo de vida](fragments/androidlifecycles.png)

**Diferenças**

| Activity  | Fragment |
| ------------- | ------------- |
| só roda uma por vez  | pode ter vários rodando ao mesmo tempo  |
| funciona por si só  | precisa de uma activity para ser apresentado  |
| código único  | pode ser reutilizado por outras activities  |

Um pouco mais sobre o uso de cada uma: https://guides.codepath.com/android/creating-and-using-fragments

### Instanciando um fragment dentro de uma activity

Para colocar um fragmento de tela dentro de uma activity precisamos iniciar uma transação, fazer o replace e commitar. Tudo isso dentro da classe FragmentManager.

```
FragmentManager manager = getSupportFragmentManager();
FragmentTransaction transaction = manager.beginTransaction();
//id do container (frameLayout, constraint, etc) - e instancia a tela do fragment nomeDaClasse()
transaction.replace(R.id.local_do_fragment, new MeuFragment()); //
transaction.commit();
```

### Comunicação entre fragmentos

A interface é uma ponte de comunicação. Implementa interface na activity e adiciona a um atributo.

1. Cria interface de comunicação (que é uma ponte de comunicação) só com a assinatura de um método contendo o parâmetro com o tipo de dado que vai ser passado por ele. **[Interface]**

```
public interface Comunicador{
void recebeMensagem(TipoDeDado tipodedado);
}
```

2. Implementa a interface na activity, importando a sobrescrita do método. Adicione a lógica depois. **[Activity]**

```
public class MainActivity implements Comunicador{

@override
public void recebeMensagem(TipoDeDado tipodedado){
  //Entra a lógica de receber a mensagem, diretamente ou por meio de método
}
}
```

3. A comunicação será iniciada no Fragment1, e para isso ela precisará de um objeto que fará essa comunicação, mas ela não pode usar diretamente o objeto da Activity, porque dificultaria se ela fosse chamada por outra activity. Por isso, é preciso criar um atributo (dependência) do tipo da interface, que é mais genérico e flexível. `private Comunicador comunicador;` **[Fragment1]**

4. Para garantir que a activity implemente a interface quando o Fragment1 é anexado, sobrescreva o método onAttach(). Ele atribui à variável o contexto em que está sendo executado na activity, mudando o tipo de dado para o genérico da interface, o que só deve acontecer se ele tiver sido implementado pelo contexto (activity). **[Fragment1]**

```
@Override //extendido pela classe Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        
        //pode colocar ele dentro de um try/catch para não crashar na cara do usuário
        try {
            comunicador = (Comunicador) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Checa se o contexto da aplicação tem uma instância do comunicador
        if (context instanceof Comunicador){
          comunicador = (Comunicador) context;
        } else{
          throw new ClassCastException(context.toString() +
                    "must implement interface");
        }
    }
```

5. Agora a gente prepara o comunicador para enviar a mensagem do Fragment1 para a Activity, ao clicar no botão (ou botões), assim que a view for criada. **[Fragment1]**

```
public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primeiro, container, false);

//Chamada do método que inicializa as views
        initViews(view);

        //Ação de clique no botão referente ao Android
        btnAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Criando um objeto
                TipoDeDado android = new SistemaOperacional(R.drawable.cupcake,
                        "Android Cupcake 1.5 lançado em 2000");
                
                //Também pode checar se o comunicador está nulo
                if(comunicador != null){
                  comunicador.recebeMensagem(TipoDeDado tipodedado);
                }
                
                //passagem do parametro do objeto android
                comunicador.recebeMensagem(android);
            }
        });

       //Retorno da view
        return view;

```

6. Faz o replace dos fragmentos (criando um método para colocar a transação que envolve essa troca) **[Activity]**

```
MainActivity

onCreate(){
  //Aqui está sendo chamado dentro do onCreate porque inicia com o primeiroFragment visível
  replaceFragment(R.id.container2, new PrimeiroFragment());
}

private void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }
```

7. Agrupa os dados que serão enviados para o Fragment2. Pode ser colocado diretamente no método sobrescrito da interface `getMessage()` do **passo 2** ou em um método específico. **[Activity]**

```
public void setBundleToFragment(SistemaOperacional so, String CHAVE) {
//Instanciação do bundle
Bundle bundle = new Bundle();

//Setando um parcelable para o bundle através de chave e valor(valor objeto)
bundle.putParcelable(CHAVE, tipodedado);

//Instanciação do segundo fragmento
Fragment segundoFragment = new SegundoFragment();

//setando os valores do bundle para ser enviado para o segundo fragmento através do método setArguments()
segundoFragment.setArguments(bundle);

//Chamada do método que recarrega um fragmento em um container
replaceFragment(R.id.container1, segundoFragment);
}
```

8. O fragment2 só precisa receber os dados e mostrar. **[Fragment2]**

```
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_segundo, container, false);

        initViews(view);

        if(!getArguments().isEmpty()){
            SistemaOperacional sistemaOperacional = getArguments().getParcelable(SO_KEY);

            if(sistemaOperacional != null){

                Drawable drawable = getResources().getDrawable(sistemaOperacional.getImagem());

                imagem.setImageDrawable(drawable);
                txtNome.setText(sistemaOperacional.getNome());
            }
        }

        // Inflate the layout for this fragment
        return view;
    }
```

Links úteis:

- https://mobiledevhub.com/2017/12/11/android-fragments-fragment-fragment-communication/
- https://google-developer-training.github.io/android-developer-advanced-course-concepts/unit-1-expand-the-user-experience/lesson-1-fragments/1-2-c-fragment-lifecycle-and-communications/1-2-c-fragment-lifecycle-and-communications.html

## Parcelable / Serializable

Não é possível passar objetos diretamente entre activities/ fragments. Para fazer isso o modelo dos objetos precisam implementar a interface de Parcelable ou Serializable.

**Mas porque não passar os campos diretamente com bundle?** Se é só um campo, pode até compensar, mas se você tem de fato um objeto você não pode passar diretamente e, se tiver vários atributos, eles são passados avulsos com putInteger(), putDouble, etc. Aí o consumo de memória aumenta bastante, já que são passados de forma bruta. É para resolver também este problema que foi criado o Serializable, que transforma o objeto em binário, diminuindo o seu tamanho para passar com facilidade. Para melhorar ainda mais essa performance, criaram o Parcelable.

Sempre que precisa passar entre telas, se usa uma das práticas:

- **Serializable** pega um objeto que vai ser enviado para outra tela, deixa em binário e quando chega na outra tela ele deserializa.

- **Parcelable** faz a mesma coisa, deixa tudo em binário e facilita o envio de uma tela para outra. É sempre utilizado, principalmente para o caso de precisar usar o savedInstanceState com listas, onde requer que o objeto seja um Parcelable.

O link abaixo tem um exemplo de implementação em uma classe, e até em ArrayList.
https://medium.com/@lucas_marciano/por-que-usar-o-parcelable-ao-invés-do-serializable-5f7543a9c7f3
