package org.jellyfin.mobile.data.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import org.jellyfin.mobile.data.entity.ServerEntity;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ServerDao_Impl implements ServerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ServerEntity> __insertionAdapterOfServerEntity;

  public ServerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfServerEntity = new EntityInsertionAdapter<ServerEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Server` (`id`,`hostname`,`last_used_timestamp`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ServerEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getHostname() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getHostname());
        }
        stmt.bindLong(3, value.getLastUsedTimestamp());
      }
    };
  }

  @Override
  public long insert(final ServerEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfServerEntity.insertAndReturnId(entity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public ServerEntity getServer(final long id) {
    final String _sql = "SELECT * FROM Server WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfHostname = CursorUtil.getColumnIndexOrThrow(_cursor, "hostname");
      final int _cursorIndexOfLastUsedTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "last_used_timestamp");
      final ServerEntity _result;
      if(_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpHostname;
        if (_cursor.isNull(_cursorIndexOfHostname)) {
          _tmpHostname = null;
        } else {
          _tmpHostname = _cursor.getString(_cursorIndexOfHostname);
        }
        final long _tmpLastUsedTimestamp;
        _tmpLastUsedTimestamp = _cursor.getLong(_cursorIndexOfLastUsedTimestamp);
        _result = new ServerEntity(_tmpId,_tmpHostname,_tmpLastUsedTimestamp);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ServerEntity getServerByHostname(final String hostname) {
    final String _sql = "SELECT * FROM Server WHERE hostname = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (hostname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, hostname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfHostname = CursorUtil.getColumnIndexOrThrow(_cursor, "hostname");
      final int _cursorIndexOfLastUsedTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "last_used_timestamp");
      final ServerEntity _result;
      if(_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpHostname;
        if (_cursor.isNull(_cursorIndexOfHostname)) {
          _tmpHostname = null;
        } else {
          _tmpHostname = _cursor.getString(_cursorIndexOfHostname);
        }
        final long _tmpLastUsedTimestamp;
        _tmpLastUsedTimestamp = _cursor.getLong(_cursorIndexOfLastUsedTimestamp);
        _result = new ServerEntity(_tmpId,_tmpHostname,_tmpLastUsedTimestamp);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long insert(final String hostname) {
    return ServerDao.DefaultImpls.insert(ServerDao_Impl.this, hostname);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
