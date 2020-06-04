package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class UpdateRequest {

    private Long id;
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;



    @NotBlank
    @Size(max = 50)
    @Email
    private String email;


    @Size(max = 220)
    private String nombre;


    @Size(max = 220)
    private String apellido;


    private String fecha_nacimiento;
    private String telefono;

    private String perfil;

    @Size(max = 20)
    private String genero;

    @Size(max = 220)
    private String lugar_acogida;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getLugar_acogida() {
        return lugar_acogida;
    }

    public void setLugar_acogida(String lugar_acogida) {
        this.lugar_acogida = lugar_acogida;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
