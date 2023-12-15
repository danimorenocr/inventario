package com.vainilla.interfaces;

import java.util.List;

public interface Funcionalidad<T> {

    public boolean registrar(T elObjeto);

    public List<T> consultar(String orden);

    public T buscar(Integer llavePrimaria);

    public Boolean eliminar(Integer llavePrimaria);

    public Boolean actualizar(T elObjeto);

    public Integer totalRegistros();

}
