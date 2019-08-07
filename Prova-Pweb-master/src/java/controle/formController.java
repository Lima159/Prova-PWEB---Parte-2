package controle;

import banco.DAOformularioSQLite;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import negocio.Formulario;

@ManagedBean(name="formController")
@RequestScoped
public class formController implements Serializable {
    private Formulario formulario;
    private DAOformularioSQLite bd;
    private List<Formulario> forms;
    
    //@PostConstruct
    /*public void forms() throws Exception {
        this.forms = bd.listar();
    }*/
    
    public formController() {
        this.formulario = new Formulario();
        this.bd = new DAOformularioSQLite();
    }

    public List<Formulario> getForms() {
       
        try {
            return bd.listar();
        } catch (Exception ex) {
            Logger.getLogger(formController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setForms(List<Formulario> forms) {
        this.forms = forms;
    }
    
    public Formulario getFormulario(){
        return this.formulario;
    }
    
    public DAOformularioSQLite getBd(){
        return this.bd;
    }
        
    public void salvar() throws SQLException, Exception{
       FacesContext context = FacesContext.getCurrentInstance();
       //getBd().inserir(this.formulario);
       
       if(this.getBd().inserir(this.formulario) == true)
       {
           context.addMessage(null, new FacesMessage("Adicionado ao banco!", null));
       }
       else
       {
           context.addMessage(null, new FacesMessage("Falha ao adicionar ao banco!", null));
       }
    }
    
    public void editar(){
        //
    }
}
