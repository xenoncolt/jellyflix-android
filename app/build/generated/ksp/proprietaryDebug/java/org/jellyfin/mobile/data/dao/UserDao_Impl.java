package org.jellyfin.mobile.data.dao;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jellyfin.mobile.data.entity.ServerEntity;
import org.jellyfin.mobile.data.entity.ServerUser;
import org.jellyfin.mobile.data.entity.UserEntity;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserEntity> __insertionAdapterOfUserEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  private final SharedSQLiteStatement __preparedStmtOfLogout;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserEntity = new EntityInsertionAdapter<UserEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `User` (`id`,`server_id`,`user_id`,`access_token`,`last_login_timestamp`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getServerId());
        if (value.getUserId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserId());
        }
        if (value.getAccessToken() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAccessToken());
        }
        stmt.bindLong(5, value.getLastLoginTimestamp());
      }
    };
    this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE User SET access_token = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfLogout = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE User SET access_token = NULL WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public long insert(final UserEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfUserEntity.insertAndReturnId(entity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long upsert(final long serverId, final String userId, final String accessToken) {
    __db.beginTransaction();
    try {
      long _result = UserDao.DefaultImpls.upsert(UserDao_Impl.this, serverId, userId, accessToken);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(final long userId, final String accessToken) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    int _argIndex = 1;
    if (accessToken == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, accessToken);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, userId);
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdate.release(_stmt);
    }
  }

  @Override
  public void logout(final long userId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfLogout.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, userId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfLogout.release(_stmt);
    }
  }

  @Override
  public ServerUser getServerUser(final long serverId, final long userId) {
    final String _sql = "SELECT * FROM User WHERE server_id = ? AND id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, serverId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, userId);
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
      try {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
        final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "server_id");
        final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
        final int _cursorIndexOfAccessToken = CursorUtil.getColumnIndexOrThrow(_cursor, "access_token");
        final int _cursorIndexOfLastLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "last_login_timestamp");
        final LongSparseArray<ServerEntity> _collectionServer = new LongSparseArray<ServerEntity>();
        while (_cursor.moveToNext()) {
          final long _tmpKey = _cursor.getLong(_cursorIndexOfServerId);
          _collectionServer.put(_tmpKey, null);
        }
        _cursor.moveToPosition(-1);
        __fetchRelationshipServerAsorgJellyfinMobileDataEntityServerEntity(_collectionServer);
        final ServerUser _result;
        if(_cursor.moveToFirst()) {
          final UserEntity _tmpUser;
          if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfServerId) && _cursor.isNull(_cursorIndexOfUserId) && _cursor.isNull(_cursorIndexOfAccessToken) && _cursor.isNull(_cursorIndexOfLastLoginTimestamp))) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpServerId;
            _tmpServerId = _cursor.getLong(_cursorIndexOfServerId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpAccessToken;
            if (_cursor.isNull(_cursorIndexOfAccessToken)) {
              _tmpAccessToken = null;
            } else {
              _tmpAccessToken = _cursor.getString(_cursorIndexOfAccessToken);
            }
            final long _tmpLastLoginTimestamp;
            _tmpLastLoginTimestamp = _cursor.getLong(_cursorIndexOfLastLoginTimestamp);
            _tmpUser = new UserEntity(_tmpId,_tmpServerId,_tmpUserId,_tmpAccessToken,_tmpLastLoginTimestamp);
          }  else  {
            _tmpUser = null;
          }
          ServerEntity _tmpServer = null;
          final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfServerId);
          _tmpServer = _collectionServer.get(_tmpKey_1);
          _result = new ServerUser(_tmpUser,_tmpServer);
        } else {
          _result = null;
        }
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        _cursor.close();
        _statement.release();
      }
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public ServerUser getServerUser(final long serverId, final String userId) {
    final String _sql = "SELECT * FROM User WHERE server_id = ? AND user_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, serverId);
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
      try {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
        final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "server_id");
        final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
        final int _cursorIndexOfAccessToken = CursorUtil.getColumnIndexOrThrow(_cursor, "access_token");
        final int _cursorIndexOfLastLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "last_login_timestamp");
        final LongSparseArray<ServerEntity> _collectionServer = new LongSparseArray<ServerEntity>();
        while (_cursor.moveToNext()) {
          final long _tmpKey = _cursor.getLong(_cursorIndexOfServerId);
          _collectionServer.put(_tmpKey, null);
        }
        _cursor.moveToPosition(-1);
        __fetchRelationshipServerAsorgJellyfinMobileDataEntityServerEntity(_collectionServer);
        final ServerUser _result;
        if(_cursor.moveToFirst()) {
          final UserEntity _tmpUser;
          if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfServerId) && _cursor.isNull(_cursorIndexOfUserId) && _cursor.isNull(_cursorIndexOfAccessToken) && _cursor.isNull(_cursorIndexOfLastLoginTimestamp))) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpServerId;
            _tmpServerId = _cursor.getLong(_cursorIndexOfServerId);
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpAccessToken;
            if (_cursor.isNull(_cursorIndexOfAccessToken)) {
              _tmpAccessToken = null;
            } else {
              _tmpAccessToken = _cursor.getString(_cursorIndexOfAccessToken);
            }
            final long _tmpLastLoginTimestamp;
            _tmpLastLoginTimestamp = _cursor.getLong(_cursorIndexOfLastLoginTimestamp);
            _tmpUser = new UserEntity(_tmpId,_tmpServerId,_tmpUserId,_tmpAccessToken,_tmpLastLoginTimestamp);
          }  else  {
            _tmpUser = null;
          }
          ServerEntity _tmpServer = null;
          final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfServerId);
          _tmpServer = _collectionServer.get(_tmpKey_1);
          _result = new ServerUser(_tmpUser,_tmpServer);
        } else {
          _result = null;
        }
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        _cursor.close();
        _statement.release();
      }
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public UserEntity getByUserId(final long serverId, final String userId) {
    final String _sql = "SELECT * FROM User WHERE server_id = ? AND user_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, serverId);
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "server_id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfAccessToken = CursorUtil.getColumnIndexOrThrow(_cursor, "access_token");
      final int _cursorIndexOfLastLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "last_login_timestamp");
      final UserEntity _result;
      if(_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpServerId;
        _tmpServerId = _cursor.getLong(_cursorIndexOfServerId);
        final String _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
        }
        final String _tmpAccessToken;
        if (_cursor.isNull(_cursorIndexOfAccessToken)) {
          _tmpAccessToken = null;
        } else {
          _tmpAccessToken = _cursor.getString(_cursorIndexOfAccessToken);
        }
        final long _tmpLastLoginTimestamp;
        _tmpLastLoginTimestamp = _cursor.getLong(_cursorIndexOfLastLoginTimestamp);
        _result = new UserEntity(_tmpId,_tmpServerId,_tmpUserId,_tmpAccessToken,_tmpLastLoginTimestamp);
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
  public List<UserEntity> getAllForServer(final long serverId) {
    final String _sql = "SELECT * FROM User WHERE server_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, serverId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "server_id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfAccessToken = CursorUtil.getColumnIndexOrThrow(_cursor, "access_token");
      final int _cursorIndexOfLastLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "last_login_timestamp");
      final List<UserEntity> _result = new ArrayList<UserEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserEntity _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpServerId;
        _tmpServerId = _cursor.getLong(_cursorIndexOfServerId);
        final String _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
        }
        final String _tmpAccessToken;
        if (_cursor.isNull(_cursorIndexOfAccessToken)) {
          _tmpAccessToken = null;
        } else {
          _tmpAccessToken = _cursor.getString(_cursorIndexOfAccessToken);
        }
        final long _tmpLastLoginTimestamp;
        _tmpLastLoginTimestamp = _cursor.getLong(_cursorIndexOfLastLoginTimestamp);
        _item = new UserEntity(_tmpId,_tmpServerId,_tmpUserId,_tmpAccessToken,_tmpLastLoginTimestamp);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long insert(final long serverId, final String userId, final String accessToken) {
    return UserDao.DefaultImpls.insert(UserDao_Impl.this, serverId, userId, accessToken);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshipServerAsorgJellyfinMobileDataEntityServerEntity(
      final LongSparseArray<ServerEntity> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<ServerEntity> _tmpInnerMap = new LongSparseArray<ServerEntity>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), null);
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipServerAsorgJellyfinMobileDataEntityServerEntity(_tmpInnerMap);
          _map.putAll(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<ServerEntity>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipServerAsorgJellyfinMobileDataEntityServerEntity(_tmpInnerMap);
        _map.putAll(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`hostname`,`last_used_timestamp` FROM `Server` WHERE `id` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfHostname = 1;
      final int _cursorIndexOfLastUsedTimestamp = 2;
      while(_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_itemKeyIndex);
        if (_map.containsKey(_tmpKey)) {
          final ServerEntity _item_1;
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
          _item_1 = new ServerEntity(_tmpId,_tmpHostname,_tmpLastUsedTimestamp);
          _map.put(_tmpKey, _item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
