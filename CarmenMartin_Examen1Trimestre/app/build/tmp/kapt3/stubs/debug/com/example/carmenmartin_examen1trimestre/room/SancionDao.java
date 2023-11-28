package com.example.carmenmartin_examen1trimestre.room;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\t"}, d2 = {"Lcom/example/carmenmartin_examen1trimestre/room/SancionDao;", "", "getListaVehiculosSancion", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/carmenmartin_examen1trimestre/Entidades/Sancion;", "obtenerVehiculoSancionPorMatricula", "matricula", "", "app_debug"})
public abstract interface SancionDao {
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM tSancion")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.carmenmartin_examen1trimestre.Entidades.Sancion>> getListaVehiculosSancion();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM tsancion WHERE matricula = :matricula")
    public abstract kotlinx.coroutines.flow.Flow<com.example.carmenmartin_examen1trimestre.Entidades.Sancion> obtenerVehiculoSancionPorMatricula(int matricula);
}