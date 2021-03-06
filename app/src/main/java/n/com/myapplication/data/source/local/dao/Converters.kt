package n.com.myapplication.data.source.local.dao

import androidx.room.TypeConverter
import com.google.gson.Gson
import n.com.myapplication.util.extension.notNull
import java.util.*

class Converters {

  @TypeConverter
  fun fromTimestamp(value: Long?): Date? {
    return value?.let { Date(it) }
  }

  @TypeConverter
  fun dateToTimestamp(date: Date?): Long? {
    return date?.time?.toLong()
  }

  @TypeConverter
  fun objectsToJson(objects: Any, gson: Gson): String? {
    return gson.toJson(objects)
  }

  @TypeConverter
  fun jsonToObjects(json: String, gson: Gson, type: Class<*>): Any? {
    json.notNull {
      return gson.fromJson(it, type)
    }
    return null
  }
}