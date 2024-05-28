package Rede;

public class GooglePlus extends RedeSocial implements VideoConferencia, Compartilhamento{
    public GooglePlus(String senha, int numAmigos) {
        super(senha, numAmigos);
    }

    @Override
    public void postarFoto() {
        System.out.println("Postou uma foto no Google Plus!");

    }

    @Override
    public void postarVideo() {
        System.out.println("Postou um video no Google Plus!");

    }

    @Override
    public void postarComentario() {
        System.out.println("Postou um comentário no Google Plus!");

    }

    @Override
    public void curtirPublicacao(){
        System.out.println("Curtiu uma publicação no Google Plus!");

    }

    @Override
    public void compartilhar() {
        System.out.println("Compartilhou um conteúdo no Google Plus");

    }

    @Override
    public void fazStreaming() {
        System.out.println("Realizou vídeo conferência no Google Plus");
    }
}
