package com.example.contactlistroom

import android.provider.ContactsContract.Contacts
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contactlistroom.entidades.ContactsEntity

@Dao
interface ContactDao {

    //Función que devuelve todos los contactos de la base de datos
    @Query("SELECT * FROM contactos")
     fun getAllContacts() : LiveData<List<Contacts>>

    //Función que inserta un nuevo contacto a la base de datos y que en caso de haber algún problema
    //reemplaza el contacto problemático con el nuevo
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contacts: ContactsEntity)

    //Función que elimina un contacto de la base de datos
    @Delete
    suspend fun deleteContact(contacts: ContactsEntity)


}