module com.mycompany.par4_proy2p_barrios_centeno_moreno {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.par4_proy2p_barrios_centeno_moreno to javafx.fxml;
    exports com.mycompany.par4_proy2p_barrios_centeno_moreno;
}
