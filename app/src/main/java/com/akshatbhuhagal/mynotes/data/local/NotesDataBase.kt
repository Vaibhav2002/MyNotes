package com.akshatbhuhagal.mynotes.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.akshatbhuhagal.mynotes.data.local.dao.NoteDao
import com.akshatbhuhagal.mynotes.data.local.entities.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NotesDataBase : RoomDatabase() {

    companion object {

        private var notesDataBase: NotesDataBase? = null

        @Synchronized
        fun getDataBase(context: Context): NotesDataBase {
            return notesDataBase ?: Room.databaseBuilder(
                context, NotesDataBase::class.java, "notes.db")
                .build().also {
                    notesDataBase = it
            }
        }
    }

    abstract fun noteDao(): NoteDao
}
