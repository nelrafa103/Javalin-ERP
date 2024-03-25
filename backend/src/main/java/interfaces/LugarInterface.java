package interfaces;

import java.util.Date;

public class LugarInterface {
    public String lugar;
    public Date fecha;
    public double longitud;
    public double latitud;


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }
    public String getLugar() {
        return lugar;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    public double getLatitud() {
        return latitud;
    }
    public double getLongitud() {
        return longitud;
    }
}
