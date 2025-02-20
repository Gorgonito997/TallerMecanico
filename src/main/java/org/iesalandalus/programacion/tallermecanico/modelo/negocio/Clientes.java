package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Clientes {

    Cliente coleccionClientes;

    List<Cliente> clientes;
    public Clientes(){
        clientes = new ArrayList<>();
    }

    public List<Cliente> get(){
        List <Cliente> nuevaCliente;
        nuevaCliente = clientes;
        return nuevaCliente;
    }

    public void insertar(Cliente cliente)throws TallerMecanicoExcepcion{
        Objects.requireNonNull(cliente,"No se puede insertar un cliente nulo.");
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        } else {
            throw new TallerMecanicoExcepcion("Ya existe un cliente con ese DNI.");
        }
    }

    public boolean modificar(Cliente cliente, String nombre, String telefono)throws TallerMecanicoExcepcion{
        Objects.requireNonNull(cliente, "No se puede modificar un cliente nulo.");

        if (clientes.contains(cliente)){



            if (nombre != null && !nombre.isBlank()){
                buscar(cliente).setNombre(nombre);
            }

            if (telefono != null && !telefono.isBlank()){
                buscar(cliente).setTelefono(telefono);
            }

            return true;

        } else {
            throw new TallerMecanicoExcepcion("No existe ningún cliente con ese DNI.");
        }
    }

    public Cliente buscar(Cliente cliente){
       Objects.requireNonNull(cliente, "No se puede buscar un cliente nulo.");
        if (clientes.contains(cliente)){
            int indexCliente = clientes.indexOf(cliente);
            return clientes.get(indexCliente);
        } else {
            return null;
        }
    }

    public void borrar(Cliente cliente)throws TallerMecanicoExcepcion{
        Objects.requireNonNull(cliente,"No se puede borrar un cliente nulo.");
        if (clientes.contains(cliente)){
            clientes.remove(cliente);
        } else {
            throw new TallerMecanicoExcepcion("No existe ningún cliente con ese DNI.");
        }
    }



}
