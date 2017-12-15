/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.ContatoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Contato;

/**
 *
 * @author Eduardo
 */

public class ContatoTableModel extends AbstractTableModel {

    //Lista de contatos a serem exibidos no tabela
    private List<Contato> linhas;
    //Array com os nomes das colunas
    private final String[] colunas = new String[] {"Nome", "Email", "Endereço"};
    //Constantes representando os indices das colunas
    private static final int NOME = 0;
    private static final int EMAIL = 1;
    private static final int ENDERECO = 2;

    //Contrutor para criar TableModel sem linhas
    public ContatoTableModel() {
        linhas = new ArrayList<>();
    }

    //Contrutor para criar TableModel contendo uma lista recebida por parametro
    public ContatoTableModel(List<Contato> listaDeContatos) {
        linhas = new ArrayList<>(listaDeContatos);
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case NOME:
                return String.class;
            case EMAIL:
                return String.class;
            case ENDERECO:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //Pega o contato referente a linha especificada
        Contato contato = linhas.get(rowIndex);

        switch (columnIndex) {
            case NOME:
                return contato.getNome();
            case EMAIL:
                return contato.getEmail();
            case ENDERECO:
                return contato.getEndereco();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //Pega o contato referente a linha especificada
        Contato contato = linhas.get(rowIndex);

        switch (columnIndex) {
            case NOME:
                contato.setNome((String) aValue);
            case EMAIL:
                contato.setEmail((String) aValue);
            case ENDERECO:
                contato.setEndereco((String) aValue);
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    //Retorna o contato referente a linha especificada
    public Contato getContato(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    //Adiciona o contato especificado ao modelo
    public void addContato(Contato contato) {
        //Adiciona o registro
        linhas.add(contato);

        //Pega a quantidade de registros e subtrai 1 para
        //achar o ultimo indice. A subtração e necessária
        //porque os indices começam em
        int ultimoIndice = getRowCount() - 1;

        //Notifica a mudança
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    //Remove o contato especificado ao modelo
    public void removeContato(int indiceLinha) {
        //Adiciona o registro
        linhas.remove(indiceLinha);

        //Notifica a mudança
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    //Adiciona uma lista de contatos no final da lista
    public void addListaDeContatos(List<Contato> contatos) {
        //Pega o tamanho antigo da tabela, que servirá
        //como indice para o primeiro dos novos registros
        int indice = getRowCount();

        //Adiciona o registro
        linhas.addAll(contatos);

        //Notifica a mudança
        fireTableRowsInserted(indice, indice + contatos.size());
    }

    //Remove todos os registros
    public void limpar() {
        //Remove todos os registros
        linhas.clear();

        //Notifica a mudança
        fireTableDataChanged();
    }
}
