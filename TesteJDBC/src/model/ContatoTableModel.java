/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Eduardo
 */

public class ContatoTableModel extends AbstractTableModel {

    private List<Contato> linhas;
    private final String[] colunas = new String[] {"Nome", "Email", "Endereço"};
    private static final int NOME = 0;
    private static final int EMAIL = 1;
    private static final int ENDERECO = 2;

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
    
    public Contato getContato(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    
    public void removeContato(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
}
