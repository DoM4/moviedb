package aumenta.domenico.com.movies.backend.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by domenicoaumenta on 16/09/2017.
 */

class ProductionCountries {
    @SerializedName("iso_3166_1")
    private String ISO_3166_1;

    @SerializedName("name")
    private String Name;

    public String getISO_3166_1() {
        return ISO_3166_1;
    }

    public void setISO_3166_1(String ISO_3166_1) {
        this.ISO_3166_1 = ISO_3166_1;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "ProductionCountries{" +
                "ISO_3166_1='" + ISO_3166_1 + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
