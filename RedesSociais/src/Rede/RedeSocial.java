package Rede;

public abstract class RedeSocial {
    private String senha;
    private int numAmigos;

    public String getSenha() {
        return senha;
    }

    public int getNumAmigos() {
        return numAmigos;
    }

    public RedeSocial(String senha, int numAmigos) {
        this.senha = senha;
        this.numAmigos = numAmigos;
    }

    public abstract void postarFoto();
    public abstract void postarVideo();
    public abstract void postarComentario();
    public void curtirPublicacao(){
        System.out.println("Curtiu uma publicação");
    }
}
