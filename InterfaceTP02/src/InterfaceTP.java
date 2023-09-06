import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JOptionPane;

//Kayky Pessoa e John Demétrio

class Aluno {
    protected String endereco;
    protected int idade;
    protected String nome;
    protected UUID uuid;

    public Aluno(String endereco, int idade, String nome)
    {
        this.endereco = endereco;
        this.idade = idade;
        this.nome = nome;
        this.uuid = UUID.randomUUID();
    }
    public String getEndereco(){
        return endereco;
    }
    public int getIdade(){
        return idade;
    }
    public String getNome(){
        return nome;
    }
    public UUID getUuid(){
        return uuid;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setUuid(UUID uuid){
        this.uuid = uuid;
    }
}

public class InterfaceTP extends Frame {
    private TextField nomeField, idadeField, enderecoField;
    public ArrayList<Aluno> listaAlunos;

    public InterfaceTP() {
        listaAlunos = new ArrayList<>();
        

        Label nomeLabel = new Label("Nome:");
        nomeField = new TextField(20);

        Label idadeLabel = new Label("Idade:");
        idadeField = new TextField(3);

        Label enderecoLabel = new Label("Endereço:");
        enderecoField = new TextField(30);

        Button cadastrarButton = new Button("OK");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });

        Button limparButton = new Button("Limpar");
        limparButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                limparDados();
            }
        });

        Button mostrarButton = new Button("Mostrar");
        mostrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                mostrarAlunos();
            }
        });

        Button sairButton = new Button("Sair");
        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                sairPrograma();
            }
        });
        
        Container c1 = new Container();
        c1.setLayout(new GridLayout(3,2,10,10));

        Container c2 = new Container();
        c2.setLayout(new GridLayout(1, 4));

        setLayout(new BorderLayout(3, 5));
        Frame f = new Frame();
        c1.add(nomeLabel);
        c1.add(nomeField);
        c1.add(idadeLabel);
        c1.add(idadeField);
        c1.add(enderecoLabel);
        c1.add(enderecoField);
        f.add(c1, BorderLayout.CENTER);
        c2.add(cadastrarButton);
        c2.add(limparButton);
        c2.add(mostrarButton);
        c2.add(sairButton);
        f.add(c2,BorderLayout.SOUTH);

        f.setTitle("Cadastro de Aluno");
        f.setSize(400, 180);
        f.setVisible(true);
    }


    public void windowClosing(WindowEvent e) 
    {
        System.exit(0);
    }

    public void cadastrarAluno() 
    {
        String nome = nomeField.getText();
        int idade = Integer.parseInt(idadeField.getText());
        String endereco = enderecoField.getText();

        Aluno aluno = new Aluno(endereco, idade, nome);
        listaAlunos.add(aluno);
        System.out.println(listaAlunos);
    }

    private void limparDados()
    {
        nomeField.setText("");
        idadeField.setText("");
        enderecoField.setText("");
    }

    private void mostrarAlunos(){
        StringBuilder mensagem = new StringBuilder("Lista de alunos:\n");
        for (Aluno aluno: listaAlunos) {
            mensagem.append("ID: ").append(aluno.getUuid()).append(", Nome: ").append(aluno.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensagem.toString(), "Lista de Alunos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void sairPrograma(){
        System.exit(ABORT);
    }

    public static void main(String[] args) {
        new InterfaceTP();
    }
}
