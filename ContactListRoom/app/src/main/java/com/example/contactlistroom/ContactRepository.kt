package com.example.contactlistroom

import android.provider.ContactsContract.Contacts
import androidx.lifecycle.LiveData

class ContactRepository (private val contactDao : ContactDao){

    //Función que muestra todos los contactos de la base de datos
    fun getAllContacts() : LiveData<List<Contacts>> {
        return contactDao.getAllContacts()
    }

    //Función que inserta un contacto en la base de datos
    fun insertContact(contacts: Contacts){
        contactDao.insertContact(contacts)
    }

    //Función que borra el contacto de la base de datos
    fun deleteContact(contacts: Contacts){
        contactDao.deleteContact(contacts)
    }
}