package com.vendedores.vendedores.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "precio")
    private String precio;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private Long telefono;

    @Column(name = "uso")
    private String uso;

    @Column(name = "coments")
    private String coments;

    @Column(nullable = true, length = 64)
    private String photos;

    @Transient
    public String getPhotosImagePath(){
        if (photos == null || id == null) return null;

        return "/vendedor-photos/" + id + "/" + this.photos;
    }

    // relacion muchos a muchos con productos
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "vendedor_producto", joinColumns = {
            @JoinColumn(name = "vendedor_id", referencedColumnName = "id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "producto_id", referencedColumnName = "id", nullable = false, updatable = false)
    })

    private Set<Producto> producto = new HashSet<>();

    public Vendedor () {
    }

    public Vendedor(String name, String precio, String email, Long telefono, String uso, String coments, String photos) {
        this.name = name;
        this.precio = precio;
        this.email = email;
        this.telefono = telefono;
        this.uso = uso;
        this.coments = coments;
        this.photos = photos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getUso() {
        return uso;
    }

    public void setComents(String coments) {
        this.coments = coments;
    }

    public String getComents() {
        return coments;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getPhotos() {
        return photos;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public Set<Producto> getProducto() {
        return producto;
    }
    
    public void setProducto(Set<Producto> producto) {
        this.producto = producto;
    }
    

    @Override
    public String toString() {
        return "Vendedor{" + "name=" + name + ", precio=" + precio + ", email=" + email + ", telefono=" + telefono +", uso=" + uso + ", coments=" + coments +", photos=" + photos +'}';
    }

}