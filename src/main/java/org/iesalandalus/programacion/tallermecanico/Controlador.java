package org.iesalandalus.programacion.tallermecanico;

import org.iesalandalus.programacion.tallermecanico.Vista.Consola;
import org.iesalandalus.programacion.tallermecanico.Vista.Vista;
import org.iesalandalus.programacion.tallermecanico.modelo.Modelo;
import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Controlador {
    private Modelo modelo;
    private Vista vista;
    public Controlador(Modelo modelo, Vista vista){
        Objects.requireNonNull(modelo,"El modelo no puede ser nulo.");
        Objects.requireNonNull(vista,"La vista no puede ser nula.");
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setControlador(this);
    }

    public void comenzar() throws TallerMecanicoExcepcion {
        modelo.comenzar();
        vista.comenzar();
    }

    public void terminar(){
        vista.terminar();
        modelo.terminar();
    }

    public void insertar(Cliente cliente) throws TallerMecanicoExcepcion {

        modelo.insertar(cliente);
    }

    public void insertar(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
        modelo.insertar(vehiculo);
    }

    public void insertar(Revision revision) throws TallerMecanicoExcepcion {
        modelo.insertar(revision);
    }

    public void buscar(Cliente cliente){
        modelo.buscar(cliente);
    }

    public void buscar(Vehiculo vehiculo){
        modelo.buscar(vehiculo);
    }

    public void buscar(Revision revision){

        modelo.buscar(revision);
    }

    public Cliente modificar(Cliente cliente, String nombre, String telefono) throws TallerMecanicoExcepcion {

        return modelo.modificar(cliente,nombre,telefono);
    }

    public Revision anadirHoras(Revision revision, int horas) throws TallerMecanicoExcepcion {
        return modelo.anadirHoras(revision,horas);
    }

    public Revision anadirPrecioMaterial(Revision revision, float precioMaterial) throws TallerMecanicoExcepcion {
        return modelo.anadirPrecioMaterial(revision,precioMaterial);
    }

    public Revision cerrar(Revision revision, LocalDate fechaDeCierre) throws TallerMecanicoExcepcion {
        return modelo.cerrar(revision,fechaDeCierre);
    }

    public void borrar(Cliente cliente) throws TallerMecanicoExcepcion {
        modelo.borrar(cliente);
    }

    public void borrar(Vehiculo vehiculo) throws TallerMecanicoExcepcion{
        modelo.borrar(vehiculo);
    }

    public void borrar(Revision revision) throws TallerMecanicoExcepcion{
        modelo.borrar(revision);
    }

    public List<Cliente> getClientes(){
        return modelo.getClientes();
    }

    public List<Vehiculo> getVehiculos(){
        return modelo.getVehiculos();
    }

    public List<Revision> getRevisiones(){
        return modelo.getRevisiones();
    }

    public List<Revision> getRevisionesCliente(Cliente cliente){
        return modelo.getRevisiones(cliente);
    }

    public List<Revision> getRevisionesVehiculo(Vehiculo vehiculo){
        return modelo.getRevisiones(vehiculo);
    }




}
