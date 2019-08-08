/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.List;
import negocio.Formulario;

/**
 *
 * @author Aluno
 */
public interface DAOformulario {
    public boolean inserir(Formulario formulario) throws Exception; 
    public boolean remover(Formulario formulario) throws Exception;
    public Formulario atualizar(Formulario formulario, Formulario novo) throws Exception;
    public List<Formulario> buscar(Formulario formulario) throws Exception;
    public List<Formulario> listar() throws Exception; 
}
