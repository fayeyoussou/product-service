package sn.youdev.productservice.exception;

public class ProduitNotFoundException extends  Exception{
    public ProduitNotFoundException() {
            super("Produit Non Trouve !");
        }

        public ProduitNotFoundException(Long id) {
            super("Produit "+id+" non trouvé !");
        }

}
