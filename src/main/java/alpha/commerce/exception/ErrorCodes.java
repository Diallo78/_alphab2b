package alpha.commerce.exception;

public enum ErrorCodes {

    // FOR ADDRESS
    ADDRESS_NOT_FOUND(999),
    // FOR ARTICLES
    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001), // La limite pour article de ]1000 - 2000]
    // FOR BRAND
    BRAND_NOT_FOUND(2000),
    // FOR BUSINESS
    BUSINESS_NOT_FOUND(3000),
    // FOR CATEGORY
    CATEGORY_NOT_FOUND(4000),
    // FOR CLIENT AND FOR COMMANDE CLIENT AND CMD ITEMS CLIENT 5000 - 7000
    CLIENT_NOT_FOUND(5000),
    COMMANDE_NOT_FOUND(6000),
    COMMANDE_ITEM_NOT_FOUND(7000),
    // FOR FOURNISSEUR AND COMMANDE FOURNISSEUR AND CMD FOURNISSEUR ITEM
    FOURNISSEUR_NOT_FOUND(8000),
    COMMANDE_FOURNISSEUR_NOT_FOUND(9000),
    COMMANDE_FOURNISSEUR_ITEM_NOT_FOUND(10000),
    // FOR CUSTOMER
    CUSTOMER_NOT_FOUND(11000),
    // FOR ROLE
    ROLE_NOT_FOUND(12000),
    // FOR MVT STK
    MVT_STK_NOT_FOUND(13000),
    // FOR SALES AND SALES LINE (VENTE)
    SALES_NOT_FOUND(14000),
    SALES_LINE_NOT_FOUND(15000)
    ;
    private int code;
    ErrorCodes(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
