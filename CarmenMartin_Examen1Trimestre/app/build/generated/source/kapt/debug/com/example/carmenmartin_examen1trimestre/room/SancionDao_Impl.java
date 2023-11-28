package com.example.carmenmartin_examen1trimestre.room;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.example.carmenmartin_examen1trimestre.Entidades.Sancion;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SancionDao_Impl implements SancionDao {
  private final RoomDatabase __db;

  public SancionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public Flow<List<Sancion>> getListaVehiculosSancion() {
    final String _sql = "SELECT * FROM tSancion";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"tSancion"}, new Callable<List<Sancion>>() {
      @Override
      @NonNull
      public List<Sancion> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMatricula = CursorUtil.getColumnIndexOrThrow(_cursor, "matricula");
          final int _cursorIndexOfVelocidad = CursorUtil.getColumnIndexOrThrow(_cursor, "velociidad");
          final List<Sancion> _result = new ArrayList<Sancion>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Sancion _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpMatricula;
            _tmpMatricula = _cursor.getInt(_cursorIndexOfMatricula);
            final double _tmpVelocidad;
            _tmpVelocidad = _cursor.getDouble(_cursorIndexOfVelocidad);
            _item = new Sancion(_tmpId,_tmpMatricula,_tmpVelocidad);
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
  public Flow<Sancion> obtenerVehiculoSancionPorMatricula(final int matricula) {
    final String _sql = "SELECT * FROM tsancion WHERE matricula = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, matricula);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"tsancion"}, new Callable<Sancion>() {
      @Override
      @NonNull
      public Sancion call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMatricula = CursorUtil.getColumnIndexOrThrow(_cursor, "matricula");
          final int _cursorIndexOfVelocidad = CursorUtil.getColumnIndexOrThrow(_cursor, "velociidad");
          final Sancion _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpMatricula;
            _tmpMatricula = _cursor.getInt(_cursorIndexOfMatricula);
            final double _tmpVelocidad;
            _tmpVelocidad = _cursor.getDouble(_cursorIndexOfVelocidad);
            _result = new Sancion(_tmpId,_tmpMatricula,_tmpVelocidad);
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
