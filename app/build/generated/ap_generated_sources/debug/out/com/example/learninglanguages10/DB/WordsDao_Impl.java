package com.example.learninglanguages10.DB;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WordsDao_Impl implements WordsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Words> __insertionAdapterOfWords;

  private final EntityDeletionOrUpdateAdapter<Words> __updateAdapterOfWords;

  public WordsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWords = new EntityInsertionAdapter<Words>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `words` (`id`,`word`,`translation`,`language`,`level`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Words value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.getWord() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getWord());
        }
        if (value.getTranslation() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTranslation());
        }
        if (value.getLanguage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLanguage());
        }
        if (value.getLevel() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLevel());
        }
      }
    };
    this.__updateAdapterOfWords = new EntityDeletionOrUpdateAdapter<Words>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `words` SET `id` = ?,`word` = ?,`translation` = ?,`language` = ?,`level` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Words value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.getWord() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getWord());
        }
        if (value.getTranslation() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTranslation());
        }
        if (value.getLanguage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLanguage());
        }
        if (value.getLevel() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLevel());
        }
        if (value.id == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.id);
        }
      }
    };
  }

  @Override
  public void insert(final Words words) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWords.insert(words);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Words words) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWords.handle(words);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Words> getAll() {
    final String _sql = "SELECT * FROM words";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfWord = CursorUtil.getColumnIndexOrThrow(_cursor, "word");
      final int _cursorIndexOfTranslation = CursorUtil.getColumnIndexOrThrow(_cursor, "translation");
      final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
      final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
      final List<Words> _result = new ArrayList<Words>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Words _item;
        _item = new Words();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpWord;
        if (_cursor.isNull(_cursorIndexOfWord)) {
          _tmpWord = null;
        } else {
          _tmpWord = _cursor.getString(_cursorIndexOfWord);
        }
        _item.setWord(_tmpWord);
        final String _tmpTranslation;
        if (_cursor.isNull(_cursorIndexOfTranslation)) {
          _tmpTranslation = null;
        } else {
          _tmpTranslation = _cursor.getString(_cursorIndexOfTranslation);
        }
        _item.setTranslation(_tmpTranslation);
        final String _tmpLanguage;
        if (_cursor.isNull(_cursorIndexOfLanguage)) {
          _tmpLanguage = null;
        } else {
          _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
        }
        _item.setLanguage(_tmpLanguage);
        final String _tmpLevel;
        if (_cursor.isNull(_cursorIndexOfLevel)) {
          _tmpLevel = null;
        } else {
          _tmpLevel = _cursor.getString(_cursorIndexOfLevel);
        }
        _item.setLevel(_tmpLevel);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Words> getLanguage() {
    final String _sql = "SELECT language FROM words   GROUP BY language";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLanguage = 0;
      final List<Words> _result = new ArrayList<Words>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Words _item;
        _item = new Words();
        final String _tmpLanguage;
        if (_cursor.isNull(_cursorIndexOfLanguage)) {
          _tmpLanguage = null;
        } else {
          _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
        }
        _item.setLanguage(_tmpLanguage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Words> getLevel() {
    final String _sql = "SELECT level FROM words GROUP BY level";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLevel = 0;
      final List<Words> _result = new ArrayList<Words>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Words _item;
        _item = new Words();
        final String _tmpLevel;
        if (_cursor.isNull(_cursorIndexOfLevel)) {
          _tmpLevel = null;
        } else {
          _tmpLevel = _cursor.getString(_cursorIndexOfLevel);
        }
        _item.setLevel(_tmpLevel);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Words> getCorrectAnswer(final String level, final String language) {
    final String _sql = "SELECT word, translation FROM words WHERE level LIKE ? AND language LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (level == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, level);
    }
    _argIndex = 2;
    if (language == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, language);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfWord = 0;
      final int _cursorIndexOfTranslation = 1;
      final List<Words> _result = new ArrayList<Words>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Words _item;
        _item = new Words();
        final String _tmpWord;
        if (_cursor.isNull(_cursorIndexOfWord)) {
          _tmpWord = null;
        } else {
          _tmpWord = _cursor.getString(_cursorIndexOfWord);
        }
        _item.setWord(_tmpWord);
        final String _tmpTranslation;
        if (_cursor.isNull(_cursorIndexOfTranslation)) {
          _tmpTranslation = null;
        } else {
          _tmpTranslation = _cursor.getString(_cursorIndexOfTranslation);
        }
        _item.setTranslation(_tmpTranslation);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Words> getIncorrectAnswers(final String language, final String word) {
    final String _sql = "SELECT word, translation FROM words WHERE language = ? AND word != ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (language == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, language);
    }
    _argIndex = 2;
    if (word == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, word);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfWord = 0;
      final int _cursorIndexOfTranslation = 1;
      final List<Words> _result = new ArrayList<Words>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Words _item;
        _item = new Words();
        final String _tmpWord;
        if (_cursor.isNull(_cursorIndexOfWord)) {
          _tmpWord = null;
        } else {
          _tmpWord = _cursor.getString(_cursorIndexOfWord);
        }
        _item.setWord(_tmpWord);
        final String _tmpTranslation;
        if (_cursor.isNull(_cursorIndexOfTranslation)) {
          _tmpTranslation = null;
        } else {
          _tmpTranslation = _cursor.getString(_cursorIndexOfTranslation);
        }
        _item.setTranslation(_tmpTranslation);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
