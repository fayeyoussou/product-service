package sn.youdev.productservice.exception;

public class UniteNotFoundException extends Exception{
    public UniteNotFoundException() {
        super("Unité Non Trouve !");
    }

    public UniteNotFoundException(Long id) {
        super("Unité "+id+" non trouvé !");
    }
}
