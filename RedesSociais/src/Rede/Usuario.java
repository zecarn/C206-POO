package Rede;

import Exceptions.UnChecked;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String nome;

    public String getNome() {
        return nome;
    }

    private String email;

    Map<String, RedeSocial> rede = new HashMap<>();

    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
    public void usuario(RedeSocial redesSociais) throws UnChecked {
        if(redesSociais instanceof Instagram){
            rede.put("Instagram", redesSociais);
        }
        else if (redesSociais instanceof Facebook) {
            rede.put("Facebook", redesSociais);
        }
        else if (redesSociais instanceof GooglePlus) {
            rede.put("Google Plus", redesSociais);
        }
        else if (redesSociais instanceof Twitter) {
            rede.put("Twitter", redesSociais);
        }
        else
            throw new UnChecked("Rede Social não localizada");
    }
}
