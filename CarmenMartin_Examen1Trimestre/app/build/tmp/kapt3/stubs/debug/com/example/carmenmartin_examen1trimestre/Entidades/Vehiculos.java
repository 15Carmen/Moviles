package com.example.carmenmartin_examen1trimestre.Entidades;

import java.lang.System;

@androidx.room.Entity(tableName = "tVehiculos")
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/example/carmenmartin_examen1trimestre/Entidades/Vehiculos;", "", "matricula", "", "numMultas", "sumaMultas", "", "(IID)V", "getMatricula", "()I", "getNumMultas", "getSumaMultas", "()D", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class Vehiculos {
    @androidx.room.PrimaryKey
    private final int matricula = 0;
    @androidx.room.ColumnInfo(name = "numMultas")
    private final int numMultas = 0;
    @androidx.room.ColumnInfo(name = "sumaMultas")
    private final double sumaMultas = 0.0;
    
    @org.jetbrains.annotations.NotNull
    public final com.example.carmenmartin_examen1trimestre.Entidades.Vehiculos copy(int matricula, int numMultas, double sumaMultas) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public Vehiculos() {
        super();
    }
    
    public Vehiculos(int matricula, int numMultas, double sumaMultas) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getMatricula() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getNumMultas() {
        return 0;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final double getSumaMultas() {
        return 0.0;
    }
}