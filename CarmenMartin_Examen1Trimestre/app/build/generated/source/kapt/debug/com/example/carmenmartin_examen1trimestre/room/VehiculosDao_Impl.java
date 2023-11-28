package com.example.carmenmartin_examen1trimestre.room;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.carmenmartin_examen1trimestre.Entidades.Vehiculos;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class VehiculosDao_Impl implements VehiculosDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Vehiculos> __insertionAdapterOfVehiculos;

  public VehiculosDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVehiculos = new EntityInsertionAdapter<Vehiculos>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `tVehiculos` (`matricula`,`numMultas`,`sumaMultas`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final Vehiculos entity) {
        statement.bindLong(1, entity.getMatricula());
        statement.bindLong(2, entity.getNumMultas());
        statement.bindDouble(3, entity.getSumaMultas());
      }
    };
  }

  @Override
  public Object agregarVehiculo(final Vehiculos vehiculo,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfVehiculos.insert(vehiculo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Vehiculos>> getListaVehiculos() {
    final String _sql = "SELECT * FROM tVehiculos";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"tVehiculos"}, new Callable<List<Vehiculos>>() {
      @Override
      @NonNull
      public List<Vehiculos> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMatricula = CursorUtil.getColumnIndexOrThrow(_cursor, "matricula");
          final int _cursorIndexOfNumMultas = CursorUtil.getColumnIndexOrThrow(_cursor, "numMultas");
          final int _cursorIndexOfSumaMultas = CursorUtil.getColumnIndexOrThrow(_cursor, "sumaMultas");
          final List<Vehiculos> _result = new ArrayList<Vehiculos>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Vehiculos _item;
            final int _tmpMatricula;
            _tmpMatricula = _cursor.getInt(_cursorIndexOfMatricula);
            final int _tmpNumMultas;
            _tmpNumMultas = _cursor.getInt(_cursorIndexOfNumMultas);
            final double _tmpSumaMultas;
            _tmpSumaMultas = _cursor.getDouble(_cursorIndexOfSumaMultas);
            _item = new Vehiculos(_tmpMatricula,_tmpNumMultas,_tmpSumaMultas);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Vehiculos> getVehiculoporMatricula(final int matricula) {
    final String _sql = "SELECT * FROM tVehiculos WHERE matricula = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, matricula);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"tVehiculos"}, new Callable<Vehiculos>() {
      @Override
      @NonNull
      public Vehiculos call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMatricula = CursorUtil.getColumnIndexOrThrow(_cursor, "matricula");
          final int _cursorIndexOfNumMultas = CursorUtil.getColumnIndexOrThrow(_cursor, "numMultas");
          final int _cursorIndexOfSumaMultas = CursorUtil.getColumnIndexOrThrow(_cursor, "sumaMultas");
          final Vehiculos _result;
          if (_cursor.moveToFirst()) {
            final int _tmpMatricula;
            _tmpMatricula = _cursor.getInt(_cursorIndexOfMatricula);
            final int _tmpNumMultas;
            _tmpNumMultas = _cursor.getInt(_cursorIndexOfNumMultas);
            final double _tmpSumaMultas;
            _tmpSumaMultas = _cursor.getDouble(_cursorIndexOfSumaMultas);
            _result = new Vehiculos(_tmpMatricula,_tmpNumMultas,_tmpSumaMultas);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
