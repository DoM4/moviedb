package aumenta.domenico.com.movies.backend.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by domenicoaumenta on 16/09/2017.
 */

class SpokenLanguages {
    @SerializedName("iso_639_1")
    private String ISO_639_1;

    @SerializedName("name")
    private String Name;

    public String getISO_639_1() {
        return ISO_639_1;
    }

    public void setISO_639_1(String ISO_639_1) {
        this.ISO_639_1 = ISO_639_1;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "SpokenLanguages{" +
                "ISO_639_1='" + ISO_639_1 + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
