package com.example.carmenmartin_examen1trimestre.room;

import java.lang.System;

@androidx.room.Database(entities = {com.example.carmenmartin_examen1trimestre.Entidades.Vehiculos.class, com.example.carmenmartin_examen1trimestre.Entidades.Sancion.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/carmenmartin_examen1trimestre/room/DatabaseVehiculos;", "Landroidx/room/RoomDatabase;", "()V", "sancionDao", "Lcom/example/carmenmartin_examen1trimestre/room/SancionDao;", "vehiculosDao", "Lcom/example/carmenmartin_examen1trimestre/room/VehiculosDao;", "app_debug"})
public abstract class DatabaseVehiculos extends androidx.room.RoomDatabase {
    
    public DatabaseVehiculos() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.carmenmartin_examen1trimestre.room.VehiculosDao vehiculosDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.carmenmartin_examen1trimestre.room.SancionDao sancionDao();
}