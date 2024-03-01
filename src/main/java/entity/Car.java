package entity;

public class Car {
    private String vendor;

    private String model;

    private Integer series;

    public Car() {
    }

    public Car(String vendor, String model, Integer series) {
        this.vendor = vendor;
        this.model = model;
        this.series = series;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
               "vendor='" + vendor + '\'' +
               ", model='" + model + '\'' +
               ", series=" + series +
               '}';
    }
}
