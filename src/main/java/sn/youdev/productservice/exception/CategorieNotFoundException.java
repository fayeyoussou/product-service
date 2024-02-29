package sn.youdev.productservice.exception;

public class CategorieNotFoundException extends Exception{
    public CategorieNotFoundException() {
        super("Catégorie Not Found");
    }

    public CategorieNotFoundException(Long id) {
        super("Catégorie "+id+" non trouvé !");
    }
}
