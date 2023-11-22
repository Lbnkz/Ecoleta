package entity;

public class CollectPoint {

    private int id;
    private String nome;
    private String email;
    private String cidade;
    private String tipoResiduo;  
    private double latitude;
    private double longitude;

    public CollectPoint() {
    }

    public CollectPoint(int id, String nome, String email, String cidade, String tipoResiduo, double latitude, double longitude) {
        this.id = id;
        this.nome = nome;
        this.email = email;  
        this.cidade = cidade;
        this.tipoResiduo = tipoResiduo;  
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoResiduo() {
        return tipoResiduo;
    }

    public void setTipoResiduo(String tipoResiduo) {
        this.tipoResiduo = tipoResiduo;
    }

}
