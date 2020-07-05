package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

public class UserProfileResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String telefono;
    private String perfil;
    private String genero;
    private String lugar_acogida;
    private List<String> roles;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPerfil() {
        return perfil;
    }

    public String getGenero() {
        return genero;
    }

    public String getLugar_acogida() {
        return lugar_acogida;
    }

    public List<String> getRoles() {
        return roles;
    }

    public UserProfileResponse() {
    }

    public UserProfileResponse(Long id, String username, String email, String password, String nombre, String apellido, Date fecha_nacimiento, String telefono, String perfil, String genero, String lugar_acogida, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.perfil = perfil;
        this.genero = genero;
        this.lugar_acogida = lugar_acogida;
        this.roles = roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setLugar_acogida(String lugar_acogida) {
        this.lugar_acogida = lugar_acogida;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
