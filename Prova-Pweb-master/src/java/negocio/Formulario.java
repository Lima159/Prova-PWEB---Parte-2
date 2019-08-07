/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Aluno
 */
public class Formulario {
    private String destinatario;
    private String telDestinatario;
    private String emailDestinatario;
    private String remetente;
    private String telRemetente;
    private String emailRemetente;
    private String data;

    public Formulario() {
        this.destinatario = null;
        this.telDestinatario = null;
        this.emailDestinatario = null;
        this.remetente = null;
        this.telRemetente = null;
        this.emailRemetente = null;
        this.data = null;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getTelDestinatario() {
        return telDestinatario;
    }

    public void setTelDestinatario(String telDestinatario) {
        this.telDestinatario = telDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getTelRemetente() {
        return telRemetente;
    }

    public void setTelRemetente(String telRemetente) {
        this.telRemetente = telRemetente;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
        
    
}
