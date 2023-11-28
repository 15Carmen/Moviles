package com.example.carmenmartin_examen1trimestre.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/example/carmenmartin_examen1trimestre/viewmodels/VehiculosViewModel;", "Landroidx/lifecycle/ViewModel;", "daoSancion", "Lcom/example/carmenmartin_examen1trimestre/room/SancionDao;", "daoVehiculos", "Lcom/example/carmenmartin_examen1trimestre/room/VehiculosDao;", "(Lcom/example/carmenmartin_examen1trimestre/room/SancionDao;Lcom/example/carmenmartin_examen1trimestre/room/VehiculosDao;)V", "<set-?>", "Lcom/example/carmenmartin_examen1trimestre/states/VehiculosState;", "state", "getState", "()Lcom/example/carmenmartin_examen1trimestre/states/VehiculosState;", "setState", "(Lcom/example/carmenmartin_examen1trimestre/states/VehiculosState;)V", "state$delegate", "Landroidx/compose/runtime/MutableState;", "agregarVehiculo", "Lkotlinx/coroutines/Job;", "vehiculo", "Lcom/example/carmenmartin_examen1trimestre/Entidades/Vehiculos;", "app_debug"})
public final class VehiculosViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.carmenmartin_examen1trimestre.room.SancionDao daoSancion = null;
    private final com.example.carmenmartin_examen1trimestre.room.VehiculosDao daoVehiculos = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState state$delegate = null;
    
    public VehiculosViewModel(@org.jetbrains.annotations.NotNull
    com.example.carmenmartin_examen1trimestre.room.SancionDao daoSancion, @org.jetbrains.annotations.NotNull
    com.example.carmenmartin_examen1trimestre.room.VehiculosDao daoVehiculos) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.carmenmartin_examen1trimestre.states.VehiculosState getState() {
        return null;
    }
    
    private final void setState(com.example.carmenmartin_examen1trimestre.states.VehiculosState p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job agregarVehiculo(@org.jetbrains.annotations.NotNull
    com.example.carmenmartin_examen1trimestre.Entidades.Vehiculos vehiculo) {
        return null;
    }
}