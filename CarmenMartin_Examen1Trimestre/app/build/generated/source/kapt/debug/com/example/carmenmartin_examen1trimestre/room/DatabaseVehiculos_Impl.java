package com.example.carmenmartin_examen1trimestre.room;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DatabaseVehiculos_Impl extends DatabaseVehiculos {
  private volatile VehiculosDao _vehiculosDao;

  private volatile SancionDao _sancionDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `tVehiculos` (`matricula` INTEGER NOT NULL, `numMultas` INTEGER NOT NULL, `sumaMultas` REAL NOT NULL, PRIMARY KEY(`matricula`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `tSancion` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `matricula` INTEGER NOT NULL, `velociidad` REAL NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c70a14ceb17021e7c69eaccc3cba5abd')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `tVehiculos`");
        db.execSQL("DROP TABLE IF EXISTS `tSancion`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsTVehiculos = new HashMap<String, TableInfo.Column>(3);
        _columnsTVehiculos.put("matricula", new TableInfo.Column("matricula", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTVehiculos.put("numMultas", new TableInfo.Column("numMultas", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTVehiculos.put("sumaMultas", new TableInfo.Column("sumaMultas", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTVehiculos = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTVehiculos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTVehiculos = new TableInfo("tVehiculos", _columnsTVehiculos, _foreignKeysTVehiculos, _indicesTVehiculos);
        final TableInfo _existingTVehiculos = TableInfo.read(db, "tVehiculos");
        if (!_infoTVehiculos.equals(_existingTVehiculos)) {
          return new RoomOpenHelper.ValidationResult(false, "tVehiculos(com.example.carmenmartin_examen1trimestre.Entidades.Vehiculos).\n"
                  + " Expected:\n" + _infoTVehiculos + "\n"
                  + " Found:\n" + _existingTVehiculos);
        }
        final HashMap<String, TableInfo.Column> _columnsTSancion = new HashMap<String, TableInfo.Column>(3);
        _columnsTSancion.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTSancion.put("matricula", new TableInfo.Column("matricula", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTSancion.put("velociidad", new TableInfo.Column("velociidad", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTSancion = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTSancion = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTSancion = new TableInfo("tSancion", _columnsTSancion, _foreignKeysTSancion, _indicesTSancion);
        final TableInfo _existingTSancion = TableInfo.read(db, "tSancion");
        if (!_infoTSancion.equals(_existingTSancion)) {
          return new RoomOpenHelper.ValidationResult(false, "tSancion(com.example.carmenmartin_examen1trimestre.Entidades.Sancion).\n"
                  + " Expected:\n" + _infoTSancion + "\n"
                  + " Found:\n" + _existingTSancion);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "c70a14ceb17021e7c69eaccc3cba5abd", "5f6ab5550250d8ee19d660274564ccde");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "tVehiculos","tSancion");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `tVehiculos`");
      _db.execSQL("DELETE FROM `tSancion`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(VehiculosDao.class, VehiculosDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SancionDao.class, SancionDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public VehiculosDao vehiculosDao() {
    if (_vehiculosDao != null) {
      return _vehiculosDao;
    } else {
      synchronized(this) {
        if(_vehiculosDao == null) {
          _vehiculosDao = new VehiculosDao_Impl(this);
        }
        return _vehiculosDao;
      }
    }
  }

  @Override
  public SancionDao sancionDao() {
    if (_sancionDao != null) {
      return _sancionDao;
    } else {
      synchronized(this) {
        if(_sancionDao == null) {
          _sancionDao = new SancionDao_Impl(this);
        }
        return _sancionDao;
      }
    }
  }
}
