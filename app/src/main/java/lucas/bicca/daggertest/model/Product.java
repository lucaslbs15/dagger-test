package lucas.bicca.daggertest.model;

public class Product {

    private int id;
    private String description;
    private int quant;

    public Product(int id, String description, int quant) {
        this.id = id;
        this.description = description;
        this.quant = quant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
}
