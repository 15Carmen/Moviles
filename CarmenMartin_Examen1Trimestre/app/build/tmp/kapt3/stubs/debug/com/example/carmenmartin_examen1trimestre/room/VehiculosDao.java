package com.example.carmenmartin_examen1trimestre.room;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u000b\u001a\u00020\fH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/carmenmartin_examen1trimestre/room/VehiculosDao;", "", "agregarVehiculo", "", "vehiculo", "Lcom/example/carmenmartin_examen1trimestre/Entidades/Vehiculos;", "(Lcom/example/carmenmartin_examen1trimestre/Entidades/Vehiculos;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getListaVehiculos", "Lkotlinx/coroutines/flow/Flow;", "", "getVehiculoporMatricula", "matricula", "", "app_debug"})
public abstract interface VehiculosDao {
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM tVehiculos")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.carmenmartin_examen1trimestre.Entidades.Vehiculos>> getListaVehiculos();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM tVehiculos WHERE matricula = :matricula")
    public abstract kotlinx.coroutines.flow.Flow<com.example.carmenmartin_examen1trimestre.Entidades.Vehiculos> getVehiculoporMatricula(int matricula);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert
    public abstract java.lang.Object agregarVehiculo(@org.jetbrains.annotations.NotNull
    com.example.carmenmartin_examen1trimestre.Entidades.Vehiculos vehiculo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}