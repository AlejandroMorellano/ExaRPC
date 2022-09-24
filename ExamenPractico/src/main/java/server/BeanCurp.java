package server;

public class BeanCurp {

    private String nombre;
    private String p_apellido;
    private String m_apellido;
    private int año;
    private int mes;
    private int dia;
    private String codigoEst;
    private String sexo;
    private String CURP;

    public BeanCurp(){

    }

    public BeanCurp(String nombre, String p_apellido, String m_apellido, int año, int mes, int dia, String codigoEst, String sexo, String CURP) {
        this.nombre = nombre;
        this.p_apellido = m_apellido;
        this.año = año;
        this.mes = mes;
        this.dia = dia;
        this.codigoEst = codigoEst;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getP_apellido() {
        return p_apellido;
    }

    public void setP_apellido(String p_apellido) {
        this.p_apellido = p_apellido;
    }

    public String getM_apellido() {
        return m_apellido;
    }

    public void setM_apellido(String m_apellido) {
        this.m_apellido = m_apellido;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getCodigoEst() {
        return codigoEst;
    }

    public void setCodigoEst(String codigoEst) {
        this.codigoEst = codigoEst;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }
}
