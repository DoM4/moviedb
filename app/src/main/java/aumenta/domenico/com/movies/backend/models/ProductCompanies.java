package aumenta.domenico.com.movies.backend.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by domenicoaumenta on 16/09/2017.
 */

class ProductCompanies {
    @SerializedName("name")
    private String Name;

    @SerializedName("id")
    private int ProductCompanyId;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getProductCompanyId() {
        return ProductCompanyId;
    }

    public void setProductCompanyId(int productCompanyId) {
        ProductCompanyId = productCompanyId;
    }

    @Override
    public String toString() {
        return "ProductCompanies{" +
                "Name='" + Name + '\'' +
                ", ProductCompanyId=" + ProductCompanyId +
                '}';
    }
}
